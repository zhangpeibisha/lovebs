package org.nix.lovedomain.security.core.social.qq.config;

import org.nix.lovedomain.security.core.properties.QQProperties;
import org.nix.lovedomain.security.core.properties.SecurityProperties;
import org.nix.lovedomain.security.core.social.qq.connet.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/**
 * @author zhangpei
 * @version 1.0
 * @description QQ自动配置,当用户配置了 love.security.social.qq.app-id参数时该配置生效
 * @date 2019/1/31
 */
@Configuration
@ConditionalOnProperty(prefix = "love.security.social.qq", name = "appId")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        QQProperties qqConfig = securityProperties.getSocial().getQq();
        return new QQConnectionFactory(qqConfig.getProviderId(), qqConfig.getAppId(), qqConfig.getAppSecret());
    }

}
