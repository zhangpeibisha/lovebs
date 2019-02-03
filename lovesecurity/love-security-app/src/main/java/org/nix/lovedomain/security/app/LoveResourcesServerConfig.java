package org.nix.lovedomain.security.app;

import org.nix.lovedomain.security.core.properties.BrowserProperties;
import org.nix.lovedomain.security.core.properties.SecurityConstants;
import org.nix.lovedomain.security.core.properties.SecurityProperties;
import org.nix.lovedomain.security.core.properties.SocialProperties;
import org.nix.lovedomain.security.core.validate.code.ValidateCodeBeanConfig;
import org.nix.lovedomain.security.core.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

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
     * @see ValidateCodeBeanConfig
     * 验证码配置
     */
    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    /**
     * @see SecurityProperties
     * 系统安全配置信息
     */
    @Autowired
    private SecurityProperties securityProperties;



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

        BrowserProperties browser = securityProperties.getBrowser();
        SocialProperties social = securityProperties.getSocial();
        http.apply(validateCodeSecurityConfig)
            .and()
            // url权限管理
            .authorizeRequests()
            .antMatchers(
                    SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                    SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                    browser.getLoginPage(),
                    SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                    browser.getSignUpUrl(),
                    social.getFilterProcessesUrl() + "/*",
                    social.getConnect() + "/*")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and().csrf().disable();
    }
}
