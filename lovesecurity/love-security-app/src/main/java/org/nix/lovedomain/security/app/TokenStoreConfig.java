package org.nix.lovedomain.security.app;

import org.nix.lovedomain.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @author zhangpei
 * @version 1.0
 * @description token保存方法
 * @date 2019/2/3
 */
@Configuration
public class TokenStoreConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    @ConditionalOnProperty(prefix = "love.security.oauth2", name = "tokenStore", havingValue = "redis")
    public TokenStore redisTokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    /**
     * @author zhangpe0312@qq.com
     * @description matchIfMissing = true没有配置项也生效
     * @date 2019/2/4
     * @return
     */
    @Configuration
    @ConditionalOnProperty(prefix = "love.security.oauth2", name = "tokenStore", havingValue = "jwt", matchIfMissing = true)
    public static class JwtConfig {

        @Autowired
        private SecurityProperties securityProperties;

        @Bean
        public TokenStore jwtTokenStore() {
            return new JwtTokenStore(jwtAccessTokenConverter());
        }

        @Bean
        public JwtAccessTokenConverter jwtAccessTokenConverter() {
            JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
            //指定密签
            converter.setSigningKey(securityProperties.getOAuth2().getJwtSigningKey());
            return converter;
        }

	/*	@Bean
		@ConditionalOnBean(TokenEnhancer.class)
		public TokenEnhancer jwtTokenEnhancer() {
			return new ImoocJwtTokenEnhancer();
		}*/

    }

}
