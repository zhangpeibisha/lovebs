package org.nix.lovedomain.security.core.social;

import org.nix.lovedomain.security.core.properties.BrowserProperties;
import org.nix.lovedomain.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

/**
 * @author zhangpei
 * @version 1.0
 * @description 第三方应用的本地配置
 * @date 2019/1/31
 */
@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 如果用户自定义了链接登陆了则使用用户的，如果没有自定义则使用默认的进入注册页面进行绑定
     */
    @Autowired(required = false)
    private ConnectionSignUp connectionSignUp;

    /**
     * @param connectionFactoryLocator
     * @return org.springframework.social.connect.UsersConnectionRepository
     * @description 将第三方应用的绑定信息存储到数据库中，
     * 如果数据库表有前缀请加上 {repository.setTablePrefix("prefix");}
     * @author zhangpe0312@qq.com
     * @date 2019/1/31
     */
    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        // 测试环境对用户信息不加密 {Encryptors.noOpText()}
        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource,
                connectionFactoryLocator, Encryptors.noOpText());
        if (connectionSignUp != null) {
            repository.setConnectionSignUp(connectionSignUp);
        }
        return repository;
    }

    /**
     * @return org.springframework.social.security.SpringSocialConfigurer
     * @description 配置自己的第三方登陆后跳转的注册页面，当第三方用户在本系统中没有账户绑定时
     * configurer.signupUrl(securityProperties.getBrowser().getSignUpUrl());
     * @author zhangpe0312@qq.com
     * @date 2019/2/1
     * @see BrowserProperties#getSignUpUrl()
     */
    @Bean
    public SpringSocialConfigurer loveSocialSecurityConfig() {
        String filterProcessesUrl = securityProperties.getSocial().getFilterProcessesUrl();
        LoveSpringSocialConfigurer configurer = new LoveSpringSocialConfigurer(filterProcessesUrl);
        configurer.signupUrl(securityProperties.getBrowser().getSignUpUrl());
        return configurer;
    }

    /**
     * @param connectionFactoryLocator
     * @return org.springframework.social.connect.web.ProviderSignInUtils
     * @description 从session中获取到用户授权的信息工具类
     * @author zhangpe0312@qq.com
     * @date 2019/2/1
     */
    @Bean
    public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator) {
        return new ProviderSignInUtils(connectionFactoryLocator,
                getUsersConnectionRepository(connectionFactoryLocator)) {
        };
    }
}
