package org.nix.lovedomain.security.core.oauthorize;

import org.nix.lovedomain.security.core.properties.BrowserProperties;
import org.nix.lovedomain.security.core.properties.SecurityConstants;
import org.nix.lovedomain.security.core.properties.SecurityProperties;
import org.nix.lovedomain.security.core.properties.SocialProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * @author zhangpei
 * @version 1.0
 * @description 权限模块默认的url权限定义
 * @date 2019/2/6
 */
@Component
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
    }
}
