package org.nix.lovedomain.security.core.oauthorize;

import org.nix.lovedomain.security.core.properties.BrowserProperties;
import org.nix.lovedomain.security.core.properties.SecurityConstants;
import org.nix.lovedomain.security.core.properties.SecurityProperties;
import org.nix.lovedomain.security.core.properties.SocialProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsUtils;

/**
 * @author zhangpei
 * @version 1.0
 * @description 权限模块默认的url权限定义
 * 排序最前面时为了使得框架自定义的权限最开始加载，后续自定义权限可以覆盖模块的权限配置
 * @date 2019/2/6
 */
@Component
@Order(Integer.MIN_VALUE)
public class LoveAuthorizeConfigProvider implements AuthorizeConfigProvider {

    /**
     * @see SecurityProperties
     * 系统安全配置信息
     */
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry urlRegistry) {
        BrowserProperties browser = securityProperties.getBrowser();
        SocialProperties social = securityProperties.getSocial();
        urlRegistry.antMatchers(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                browser.getLoginPage(),
                SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                browser.getSignUpUrl(),
                social.getFilterProcessesUrl() + "/*")
                .permitAll();
        //让Spring security放行所有preflight request
        urlRegistry.requestMatchers(CorsUtils::isPreFlightRequest).permitAll();
    }
}
