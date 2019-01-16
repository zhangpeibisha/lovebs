package org.nix.zpbs.config.security;

import org.nix.zpbs.config.properties.security.SecurityProperties;
import org.nix.zpbs.service.impl.UserDetailsServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/13
 */
@Configuration
@EnableWebSecurity
@EnableConfigurationProperties(value = SecurityProperties.class)
@EnableGlobalMethodSecurity(prePostEnabled = true)  //  启用方法级别的权限认证
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsServiceImpl userDetailsService;

    @Resource
    private SecurityProperties securityProperties;

    @Resource
    private LoveAuthenticationSuccessHandler loveAuthenticationSuccessHandler;

    @Resource
    private LoveAuthenticationFailHandler loveAuthenticationFailHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                // 设置登陆页面
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(loveAuthenticationSuccessHandler)
                .failureHandler(loveAuthenticationFailHandler)
                .and()
                .authorizeRequests()
                // 配置的登陆页应该不用权限
                .antMatchers(securityProperties.getBrowser().getLoginPage()).permitAll()
                // 身份认证接口不需要认证
                .antMatchers("/authentication/require").permitAll()
                // 登陆包里面的所有信息都不用认证
                .antMatchers("/login/**").permitAll()
                .antMatchers("/static/login/signIn.html").permitAll()
                // 所有请求都需要认证
                .anyRequest()
                .authenticated()
                // 关闭防止跨站请求的处理
                .and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        String password = "bisha520";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(password);
        System.out.println(encode);
        System.out.println(encode.length());
    }

}
