package org.nix.lovedomain.security.app.social.openid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/**
 * @author zhangpei
 * @version 1.0
 * @description OpenIdAuthenticationSecurityConfig配置类
 * @date 2019/2/3
 */
@Component
public class OpenIdAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private AuthenticationSuccessHandler loveAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler loveAuthenticationFailureHandler;

    @Autowired
    private SocialUserDetailsService userDetailsService;

    @Autowired
    private UsersConnectionRepository usersConnectionRepository;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        OpenIdAuthenticationFilter openidauthenticationfilter = new OpenIdAuthenticationFilter();
        openidauthenticationfilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        openidauthenticationfilter.setAuthenticationSuccessHandler(loveAuthenticationSuccessHandler);
        openidauthenticationfilter.setAuthenticationFailureHandler(loveAuthenticationFailureHandler);

        OpenIdAuthenticationProvider openidauthenticationprovider = new OpenIdAuthenticationProvider();
        openidauthenticationprovider.setUserDetailsService(userDetailsService);
        openidauthenticationprovider.setUsersConnectionRepository(usersConnectionRepository);

        http.authenticationProvider(openidauthenticationprovider)
                .addFilterAfter(openidauthenticationfilter, UsernamePasswordAuthenticationFilter.class);

    }

}
