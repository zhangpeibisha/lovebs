package org.nix.lovedomain.security.core;

import org.nix.lovedomain.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/27
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
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
}
