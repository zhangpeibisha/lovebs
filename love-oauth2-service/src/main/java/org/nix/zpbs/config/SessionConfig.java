package org.nix.zpbs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/25
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds= 1800)
public class SessionConfig {
    //冒号后的值为没有配置文件时，制动装载的默认值
    @Value("${spring.redis.host:localhost}")
    String HostName;
    @Value("${spring.redis.port:6379}")
    int Port;
    @Bean
    public JedisConnectionFactory connectionFactory() {
        JedisConnectionFactory connection = new JedisConnectionFactory();
        connection.setPort(Port);
        connection.setHostName(HostName);
        return connection;
    }
}
