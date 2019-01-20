package org.nix.zpbs.config.authentication.mobile;

import lombok.Data;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/20
 */
@Data
public class SmsCodeAuthenticationProvider implements AuthenticationProvider {

    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        SmsCodeAuthenticationToken token = (SmsCodeAuthenticationToken) authentication;
        // 获取到手机号码，得到用户信息
        UserDetails user = userDetailsService.loadUserByUsername((String) token.getPrincipal());
        if (user == null){
            throw new InternalAuthenticationServiceException("无法获取用户信息");
        }
        // 获取到用户信息，并设置权限
        SmsCodeAuthenticationToken authenticationToken = new SmsCodeAuthenticationToken(user,user.getAuthorities());
        // 将认证信息copy到token中去
        authenticationToken.setDetails(token.getDetails());
        return authenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // 判断传进来的值是不是指定的class
        return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
