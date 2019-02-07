package org.nix.lovedomain.security.app;

import org.nix.lovedomain.security.core.oauthorize.AuthorizeConfigManger;
import org.nix.lovedomain.security.core.oauthorize.LoveAuthorizeConfigManger;
import org.nix.lovedomain.security.core.properties.SecurityConstants;
import org.nix.lovedomain.security.core.validate.code.ValidateCodeBeanConfig;
import org.nix.lovedomain.security.core.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @author zhangpei
 * @version 1.0
 * @description 配置资源服务器, 配置安全配置
 * @date 2019/2/2
 */
@Configuration
@EnableResourceServer
public class LoveResourcesServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler loveAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler loveAuthenticationFailureHandler;

    /**
     * @see org.nix.lovedomain.security.core.social.SocialConfig
     * 第三方登陆配置
     */
    @Autowired
    private SpringSocialConfigurer loveSocialSecurityConfig;
    /**
     * @see ValidateCodeBeanConfig
     * 验证码配置
     */
    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    /**
     * url权限配置器
     * @see LoveAuthorizeConfigManger
     */
    @Autowired
    private AuthorizeConfigManger authorizeConfigManger;

    /**
     * @param http
     * @return void
     * @description app安全配置
     * @author zhangpe0312@qq.com
     * @date 2019/2/3
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(loveAuthenticationSuccessHandler)
                .failureHandler(loveAuthenticationFailureHandler);

        http.apply(validateCodeSecurityConfig)
                .and()
                .apply(loveSocialSecurityConfig)
                .and().csrf().disable();
        // 配置url权限
        authorizeConfigManger.config(http.authorizeRequests());
    }
}
