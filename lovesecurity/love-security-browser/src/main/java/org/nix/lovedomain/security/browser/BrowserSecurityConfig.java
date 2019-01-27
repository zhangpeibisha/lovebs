package org.nix.lovedomain.security.browser;

import org.nix.lovedomain.security.core.authentication.AbstractChannelSecurityConfig;
import org.nix.lovedomain.security.core.properties.SecurityProperties;
import org.nix.lovedomain.security.core.validate.code.ValidateCodeBeanConfig;
import org.nix.lovedomain.security.core.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * @author zhangpei
 * @version 1.0
 * @description 浏览器安全配置
 * @date 2019/1/27
 */
@Configuration
public class BrowserSecurityConfig extends AbstractChannelSecurityConfig {

    /**
     * @see SecurityProperties
     * 系统安全配置信息
     */
    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 数据源配置
     */
    @Autowired
    private DataSource dataSource;

    /**
     * 用户认证服务
     */
    @Autowired
    private UserDetailsService userDetailsService;
    /**
     * @see ValidateCodeBeanConfig
     * 验证码配置
     */
    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;


    /**
     * @param http http安全配置
     * @return void
     * @description 配置浏览器的安全权限信息
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        applyPasswordAuthenticationConfig(http);
        http.apply(validateCodeSecurityConfig);

    }

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
