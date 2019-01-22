package org.nix.zpbs.utils.social;

import org.nix.zpbs.config.properties.security.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
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

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/22
 */
@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired(required = false)
    private ConnectionSignUp connectionSignUp;

    @Resource
    private ConnectionFactoryLocator connectionFactoryLocator;

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource,
                connectionFactoryLocator, Encryptors.noOpText());
        repository.setTablePrefix(securityProperties.getSocial().getQq().getQqTablePrefix());

        if (connectionSignUp != null) {
            repository.setConnectionSignUp(connectionSignUp);
        }
        return repository;
    }

    /**
     * @return 配置获取用户信息
     */
    @Bean
    public ProviderSignInUtils providerSignInUtils(){
        return new ProviderSignInUtils(connectionFactoryLocator
                ,getUsersConnectionRepository(connectionFactoryLocator));
    }

    @Bean
    public LoveSpringSocialConfigurer loveSpringSocialConfigurer(){
        String filterProcessesUrl = securityProperties.getSocial().getFilterProcessesUrl();
        LoveSpringSocialConfigurer configurer = new LoveSpringSocialConfigurer(filterProcessesUrl);
        // 配置注册页
        configurer.signupUrl(securityProperties.getBrowser().getSignUpUrl());
        return configurer;
    }

    /**
     * 微信绑定和解绑
     * 当另外注入了该类的实例，则该实例不生效
     * 绑定为post方法，delete方法为解绑
     */
    @Bean({"connect/weixinConnect","connect/weixinConnected"})
    @ConditionalOnMissingBean(LoveConnectView.class)
    public LoveConnectView loveConnectView(){
        return new LoveConnectView();
    }

}
