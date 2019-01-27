package org.nix.lovedomain.security.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;

/**
 * @author zhangpei
 * @version 1.0
 * @description 验证码安全配置类
 * @date 2019/1/27
 */
@Component("validateCodeSecurityConfig")
public class ValidateCodeSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private Filter validateCodeFilter;

    /**
     * @param http http安全配置
     * @return void
     * @description 添加验证码安全过滤器
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(validateCodeFilter, AbstractPreAuthenticatedProcessingFilter.class);
    }

}
