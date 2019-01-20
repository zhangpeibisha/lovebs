package org.nix.zpbs.config.authentication.mobile;

import io.netty.channel.socket.DefaultSocketChannelConfig;
import org.nix.zpbs.config.security.LoveAuthenticationFailHandler;
import org.nix.zpbs.config.security.LoveAuthenticationSuccessHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 配置SMS的一些配置信息
 *
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/20
 */
@Component
public class SmsCodeAuthenticationSecurityConfig
        extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Resource
    private LoveAuthenticationSuccessHandler loveAuthenticationSuccessHandler;

    @Resource
    private LoveAuthenticationFailHandler loveAuthenticationFailHandler;

    @Resource
    private UserDetailsService userDetailsService;

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        // 设置一个过滤器
        SmsCodeAuthenticationFilter filter = new SmsCodeAuthenticationFilter();
        filter.setAuthenticationManager(builder.getSharedObject(AuthenticationManager.class));
        filter.setAuthenticationSuccessHandler(loveAuthenticationSuccessHandler);
        filter.setAuthenticationFailureHandler(loveAuthenticationFailHandler);

        // 短信验证服务
        SmsCodeAuthenticationProvider provider = new SmsCodeAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);

        // 设置过滤器和验证服务
        builder.authenticationProvider(provider)
                .addFilterAfter(filter, UsernamePasswordAuthenticationFilter.class);
    }
}
