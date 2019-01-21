package org.nix.zpbs.utils.social.qq.config;

import org.nix.zpbs.config.properties.security.QQProperties;
import org.nix.zpbs.config.properties.security.SecurityProperties;
import org.nix.zpbs.utils.social.base.SocialAutoConfigurerAdapter;
import org.nix.zpbs.utils.social.qq.connet.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/**
 * 当配置了love.security.social.qq.appId时配置生效
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/21
 */
@Configuration
@ConditionalOnProperty(prefix = "love.security.social.qq",name = "appId")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        QQProperties qqConfig = securityProperties.getSocial().getQq();
        return new QQConnectionFactory(qqConfig.getProviderId(), qqConfig.getAppId(), qqConfig.getAppSecret());
    }
}
