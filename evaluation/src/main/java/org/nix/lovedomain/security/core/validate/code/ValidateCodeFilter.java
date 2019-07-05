package org.nix.lovedomain.security.core.validate.code;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.nix.lovedomain.security.core.properties.SecurityConstants;
import org.nix.lovedomain.security.core.properties.SecurityProperties;
import org.nix.lovedomain.security.core.properties.ValidateCodeProperties;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangpei
 * @version 1.0
 * @description 验证码验证过滤器，验证用户输入是否和申请的代码是否一致
 * @date 2019/1/27
 */
@Slf4j
@Component("validateCodeFilter")
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {

    /**
     * 验证码校验失败处理器
     */
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;
    /**
     * 系统配置信息
     */
    @Autowired
    private SecurityProperties securityProperties;
    /**
     * 系统中的校验码处理器
     */
    @Autowired
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;
    /**
     * 存放所有需要校验验证码的url
     */
    private Map<String, ValidateCodeType> urlMap = new HashMap<>();
    /**
     * 验证请求url与配置的url是否匹配的工具类
     */
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    /**
     * @return void
     * @description 初始化要拦截的url配置信息
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        ValidateCodeProperties validate = securityProperties.getValidate();
        urlMap.put(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM, ValidateCodeType.IMAGE);
        addUrlToMap(validate.getImage().getValidateUrls(), ValidateCodeType.IMAGE);
        urlMap.put(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE, ValidateCodeType.SMS);
        addUrlToMap(validate.getSms().getValidateUrls(), ValidateCodeType.SMS);
        log.info("初始化拦截路径url:{}", JSONUtil.toJsonStr(urlMap));
    }

    /**
     * @param urlString 需要拦截的url路径信息
     * @param type      验证码类型
     * @return void
     * @description 讲系统中配置的需要校验验证码的URL根据校验的类型放入map
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    protected void addUrlToMap(String urlString, ValidateCodeType type) {
        if (StringUtils.isNotBlank(urlString)) {
            String[] urls = StringUtils.splitByWholeSeparatorPreserveAllTokens(urlString, ",");
            for (String url : urls) {
                urlMap.put(url, type);
            }
        }
    }

    /**
     * @param request 用户请求
     * @param response 用户响应
     * @param filterChain 过滤器链
     * @return void
     * @description 验证验证码是否正确
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        ValidateCodeType type = getValidateCodeType(request);
//        if (type != null) {
//            log.info("校验请求(" + request.getRequestURI() + ")中的验证码,验证码类型" + type);
//            try {
//                validateCodeProcessorHolder.findValidateCodeProcessor(type)
//                        .validate(new ServletWebRequest(request, response));
//                log.info("验证码校验通过");
//            } catch (ValidateCodeException exception) {
//                authenticationFailureHandler.onAuthenticationFailure(request, response, exception);
//                return;
//            }
//        }
        filterChain.doFilter(request, response);
    }

    /**
     * @param request 用户请求信息
     * @return org.nix.lovedomain.security.core.validate.code.ValidateCodeType
     * @description 获取用户验证码类型
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    private ValidateCodeType getValidateCodeType(HttpServletRequest request) {
        ValidateCodeType result = null;
        String requestMethod = "get";
        if (!StringUtils.equalsIgnoreCase(request.getMethod(), requestMethod)) {
            Set<String> urls = urlMap.keySet();
            for (String url : urls) {
                if (pathMatcher.match(url, request.getRequestURI())) {
                    result = urlMap.get(url);
                }
            }
        }
        return result;
    }
}
