package org.nix.lovedomain.security.browser;

import org.nix.lovedomain.security.core.authentication.AbstractChannelSecurityConfig;
import org.nix.lovedomain.security.core.properties.BrowserProperties;
import org.nix.lovedomain.security.core.properties.SecurityConstants;
import org.nix.lovedomain.security.core.properties.SecurityProperties;
import org.nix.lovedomain.security.core.properties.SocialProperties;
import org.nix.lovedomain.security.core.validate.code.ValidateCodeBeanConfig;
import org.nix.lovedomain.security.core.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

/**
 * @author zhangpei
 * @version 1.0
 * @description 浏览器安全配置
 * @date 2019/1/27
 */
@Configuration
public class BrowserSecurityConfig extends AbstractChannelSecurityConfig {

    /**
     * @see SecurityProperties
     * 系统安全配置信息
     */
    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 数据源配置
     */
    @Autowired
    private DataSource dataSource;

    /**
     * 用户认证服务
     */
    @Autowired
    private UserDetailsService userDetailsService;
    /**
     * @see ValidateCodeBeanConfig
     * 验证码配置
     */
    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    /**
     * @see org.nix.lovedomain.security.core.social.SocialConfig
     * 第三方登陆配置
     */
    @Autowired
    private SpringSocialConfigurer loveSocialSecurityConfig;

    /**
     * @param http http安全配置
     * @return void
     * @description 配置浏览器的安全权限信息
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        applyPasswordAuthenticationConfig(http);
        BrowserProperties browser = securityProperties.getBrowser();
        SocialProperties social = securityProperties.getSocial();
        http.apply(validateCodeSecurityConfig)
                .and()
                .apply(loveSocialSecurityConfig)
                .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(browser.getRememberMeSeconds())
                .userDetailsService(userDetailsService)
                .and()
                .authorizeRequests()
                .antMatchers(
                        SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                        browser.getLoginPage(),
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                        browser.getSignUpUrl(),
                        social.getFilterProcessesUrl() + "/*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }

    /**
     * @return org.springframework.security.crypto.password.PasswordEncoder
     * @description 注入 {@link BCryptPasswordEncoder} 作为用户密码加密工具类
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    @Bean("passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * @return org.springframework.security.web.authentication.rememberme.PersistentTokenRepository
     * @description 配置{记住我}这个功能
     * @author zhangpe0312@qq.com
     * @date 2019/1/28
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
//        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }
}
