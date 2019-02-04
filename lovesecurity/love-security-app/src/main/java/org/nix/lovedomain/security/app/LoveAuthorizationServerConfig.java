package org.nix.lovedomain.security.app;

import org.nix.lovedomain.security.core.properties.OAuth2ClientProperties;
import org.nix.lovedomain.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.annotation.Resource;

/**
 * @author zhangpei
 * @version 1.0
 * @description 权限服务配置, 实现认证服务器
 * @date 2019/2/2
 */
@Configuration
@EnableAuthorizationServer
public class LoveAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 将令牌存入redis中
     */
    @Resource
    private TokenStore tokenStore;

    @Autowired(required = false)
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * @param endpoints
     * @return void
     * @description 配置入口
     * @author zhangpe0312@qq.com
     * @date 2019/2/3
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                .tokenStore(tokenStore);

        if (jwtAccessTokenConverter != null){
            endpoints.accessTokenConverter(jwtAccessTokenConverter);
        }
    }

    /**
     * @param clients
     * @return void
     * @description 配置第三方应用
     * @author zhangpe0312@qq.com
     * @date 2019/2/3
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        InMemoryClientDetailsServiceBuilder inMemoryClientDetailsServiceBuilder = clients.inMemory();

        OAuth2ClientProperties[] oAuth2Clients = securityProperties.getOAuth2().getClients();
        if (oAuth2Clients == null) {
            return;
        }
        for (OAuth2ClientProperties oAuth2ClientProperties : oAuth2Clients) {
            inMemoryClientDetailsServiceBuilder
                    .withClient(oAuth2ClientProperties.getClientId())
                    .secret(oAuth2ClientProperties.getClientSecret())
                    // 指定令牌过期时间
                    .accessTokenValiditySeconds(oAuth2ClientProperties.getAccessTokenValidateSeconds())
                    // 指定授权类型，比如刷新令牌、密码模式、授权码模式、自定义模式等
                    .scopes("all")
                    // 应用配置拥有的权限范围
                    .authorizedGrantTypes("password","refresh_token");
        }
    }
}

