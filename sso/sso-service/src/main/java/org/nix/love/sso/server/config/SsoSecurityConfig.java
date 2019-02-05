package org.nix.love.sso.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zhangpei
 * @version 1.0
 * @description 单点登陆安全配置
 * @date 2019/2/5
 */
@Configuration
public class SsoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDeatilServiceImpl userDeatilService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 表单登陆
        http.formLogin()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 指定自己的用户服务和加密器
        auth.userDetailsService(userDeatilService).passwordEncoder(passwordEncoder());
    }

    /**
     * @return org.springframework.security.crypto.password.PasswordEncoder
     * @description 密码加密使用
     * @see UserDeatilServiceImpl
     * @author zhangpe0312@qq.com
     * @date 2019/2/5
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
