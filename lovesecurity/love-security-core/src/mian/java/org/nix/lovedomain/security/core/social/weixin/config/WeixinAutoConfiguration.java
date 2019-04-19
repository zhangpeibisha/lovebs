package org.nix.lovedomain.security.core.social.weixin.config;

import org.nix.lovedomain.security.core.properties.SecurityProperties;
import org.nix.lovedomain.security.core.properties.WeixinProperties;
import org.nix.lovedomain.security.core.social.LoveConnectView;
import org.nix.lovedomain.security.core.social.weixin.connect.WeixinConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.web.servlet.View;

/**
 * @author zhangpei
 * @version 1.0
 * @description 微信配置进入spring容器中的信息
 * @date 2019/2/1
 */
@Configuration
@ConditionalOnProperty(prefix = "love.security.social.weixin", name = "app-id")
public class WeixinAutoConfiguration extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        WeixinProperties weixinConfig = securityProperties.getSocial().getWeixin();
        return new WeixinConnectionFactory(weixinConfig.getProviderId(), weixinConfig.getAppId(),
                weixinConfig.getAppSecret());
    }

    /**
     * @return org.springframework.web.servlet.View
     * @description 微信解绑和绑定的操作
     * @see LoveConnectView
     * @author zhangpe0312@qq.com
     * @date 2019/2/1
     */
    @Bean({"connect/weixinConnect", "connect/weixinConnected"})
    @ConditionalOnMissingBean(name = "weixinConnectedView")
    public View weixinConnectedView() {
        return new LoveConnectView();
    }
}
