package org.nix.zpbs.utils.verification;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.nix.zpbs.config.properties.constants.DefaultConstants;
import org.nix.zpbs.config.properties.security.SecurityProperties;
import org.nix.zpbs.utils.verification.image.ImageConfirmationCode;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/17
 */
@Data
@Slf4j
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {
    /**
     * 验证失败处理器
     */
    private AuthenticationFailureHandler authenticationFailureHandler;
    /**
     * 配置文件信息
     */
    private SecurityProperties securityProperties;

    /**
     * 系统的校验码处理器
     */
    private ValidateCodeGenerateHolder validateCodeGenerateHolder;

    /**
     * 存放所有需要校验验证码的url
     * key url路径 value验证类型
     */
    private Map<String, ValidateCodeType> urlMap = new HashMap<>();

    /**
     * 验证请求Url与配置的url是否匹配工具类
     */
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        // 添加图片验证码到登陆页面
        urlMap.put(DefaultConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM, ValidateCodeType.IMAGE);
        addUrlToMap(securityProperties.getValidate().getImage().getUrl(), ValidateCodeType.IMAGE);
        // 添加手机验证码验证路径
        urlMap.put(DefaultConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE, ValidateCodeType.SMS);
        addUrlToMap(securityProperties.getValidate().getImage().getUrl(), ValidateCodeType.SMS);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        ValidateCodeType type = getValidateCodeType(request);
        if (type != null) {
            logger.info("校验请求(" + request.getRequestURI() + ")中的验证码,验证码类型" + type);
            try {
                validateCodeGenerateHolder.findValidateCodeProcessor(type)
                        .check(new ServletWebRequest(request, response));
                logger.info("验证码校验通过");
            } catch (ValidateCodeException exception) {
                authenticationFailureHandler.onAuthenticationFailure(request, response, exception);
                return;
            }
        }
        filterChain.doFilter(request,response);
    }


    /**
     * 讲系统中配置的需要校验验证码的URL根据校验的类型放入map
     *
     * @param urlString
     * @param type
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
     * 获取校验码的类型，如果当前请求不需要校验，则返回null
     *
     * @param request
     * @return
     */
    private ValidateCodeType getValidateCodeType(HttpServletRequest request) {
        ValidateCodeType result = null;
        if (!StringUtils.equalsIgnoreCase(request.getMethod(), "get")) {
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
