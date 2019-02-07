package org.nix.lovedomain.security.browser;

import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.security.core.authentication.AbstractChannelSecurityConfig;
import org.nix.lovedomain.security.core.oauthorize.AuthorizeConfigManger;
import org.nix.lovedomain.security.core.oauthorize.LoveAuthorizeConfigManger;
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
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

/**
 * @author zhangpei
 * @version 1.0
 * @description 浏览器安全配置
 * @date 2019/1/27
 */
@Slf4j
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
     * @see BrowserSecurityBeanConfig
     * session失效策略
     */
    @Autowired
    private InvalidSessionStrategy invalidSessionStrategy;

    /**
     * @see BrowserSecurityBeanConfig
     * session过期策略
     */
    @Autowired
    private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;

    /**
     * 配置默认的退出处理器
     * @see BrowserSecurityBeanConfig
     */
    @Autowired
    private LogoutSuccessHandler loveLogoutSuccessHandler;

    /**
     * url权限配置器
     * @see LoveAuthorizeConfigManger
     */
    @Autowired
    private AuthorizeConfigManger authorizeConfigManger;

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
                // 记住我管理
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(browser.getRememberMeSeconds())
                .userDetailsService(userDetailsService)
                .and()
                // session管理
                .sessionManagement()
                .invalidSessionStrategy(invalidSessionStrategy)
                .maximumSessions(browser.getSession().getMaximumSessions())
                .maxSessionsPreventsLogin(browser.getSession().isMaxSessionsPreventsLogin())
                .expiredSessionStrategy(sessionInformationExpiredStrategy)
                .and()
                .and()
                // 登出配置
                .logout()
                .logoutUrl(securityProperties.getBrowser().getLogoutUrl())
                .logoutSuccessHandler(loveLogoutSuccessHandler)
                .deleteCookies("JSESSIONID")
                .and()
                .csrf().disable();
        // 配置url权限信息
        authorizeConfigManger.config(http.authorizeRequests());
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
