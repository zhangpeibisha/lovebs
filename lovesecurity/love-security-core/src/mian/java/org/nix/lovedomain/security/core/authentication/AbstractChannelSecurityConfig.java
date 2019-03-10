package org.nix.lovedomain.security.core.authentication;

import org.nix.lovedomain.security.core.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author zhangpei
 * @version 1.0
 * @description 抽象安全模块配置信息
 * @date 2019/1/27
 */
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler loveAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler loveAuthenticationFailureHandler;

    /**
     * @param http http安全配置
     * @return void
     * @description 基本配置账号密码权限
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
        http.formLogin()
                // 自定义登录页url,默认为/login
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                // 登录请求拦截的url,也就是form表单提交时指定的action
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(loveAuthenticationSuccessHandler)
                .failureHandler(loveAuthenticationFailureHandler);
    }
}
