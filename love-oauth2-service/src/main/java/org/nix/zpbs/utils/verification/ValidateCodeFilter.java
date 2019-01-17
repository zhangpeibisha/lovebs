package org.nix.zpbs.utils.verification;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.nix.zpbs.config.properties.security.SecurityProperties;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.naming.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/17
 */
@Data
@Slf4j
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {

    private VerificationCode imageVerification;

    private AuthenticationFailureHandler authenticationFailureHandler;

    private SecurityProperties securityProperties;

    private Set<String> urls = new HashSet<>();

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        // 登陆页必须验证
        String loginPage = securityProperties.getBrowser().getLoginRequestUrl();
        log.info("登陆请求路径为{}",loginPage);
        urls.add(loginPage);
        // 添加自定义的页面
        String[] split = securityProperties.getValidate().getUrls().split(",");
        Collections.addAll(urls, split);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("进入验证码过滤器");
        final boolean[] action = {false};
        urls.forEach(url -> {
            if (pathMatcher.match(url, request.getRequestURI())) {
                action[0] = true;
            }
        });
        if (action[0]) {
            log.info("进入验证码过滤器进行验证码验证");
            try {
                // 验证用户输入的数据是否正确
                imageVerification.submitVerification(request, response);
            } catch (ValidateCodeException e) {
                log.info("验证码验证异常{}",e.getMessage());
                // 进入验证失败处理器
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }
}
