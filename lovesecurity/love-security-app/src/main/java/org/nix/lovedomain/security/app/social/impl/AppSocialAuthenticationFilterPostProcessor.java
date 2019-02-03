package org.nix.lovedomain.security.app.social.impl;

import org.nix.lovedomain.security.core.social.SocialAuthenticationFilterPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * @author zhangpei
 * @version 1.0
 * @description app使用时第三方登陆成功处理器
 * @date 2019/2/3
 */
@Component
public class AppSocialAuthenticationFilterPostProcessor implements SocialAuthenticationFilterPostProcessor {

    @Autowired
    private AuthenticationSuccessHandler loveAuthenticationSuccessHandler;

    @Override
    public void process(SocialAuthenticationFilter socialAuthenticationFilter) {

        socialAuthenticationFilter.setAuthenticationSuccessHandler(loveAuthenticationSuccessHandler);

    }
}
