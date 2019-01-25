package org.nix.zpbs.config.security;

import org.nix.zpbs.config.properties.security.SecurityProperties;
import org.nix.zpbs.config.properties.security.SessionProperties;
import org.nix.zpbs.config.session.LoveExpiredSessionStrategy;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/25
 */
@Component
public class LoveSessionConfig
        extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Resource
    private SecurityProperties securityProperties;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        SessionProperties session = securityProperties.getBrowser().getSession();
        http.sessionManagement()
                // session过期如何处理
                .invalidSessionUrl(session.getSessionTimeOutUrl())
                // 设置用户的登陆数量控制
                .maximumSessions(session.getMaximumSessions())
                // 处理session策略
                .expiredSessionStrategy(new LoveExpiredSessionStrategy())
                // 如果用户登陆数已经达到一定的数量则不允许在登陆了
                .maxSessionsPreventsLogin(session.isMaxSessionsPreventsLogin())
                .and()
                .and()
                .authorizeRequests().antMatchers(
                // session过期请求不要权限
                session.getSessionTimeOutUrl()).permitAll();
    }
}
