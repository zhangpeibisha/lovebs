package org.nix.lovedomain.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.AuthenticationManager;

import java.util.Arrays;

@Configuration
public class SecurityConfig {

    @Bean
    public AffirmativeBased accessDecisionManager(){
        return new AffirmativeBased(Arrays.asList(authenticatedVoter(),roleVoter(),urlMatchVoter()));
    }

    @Bean
    public AuthenticatedVoter authenticatedVoter(){
        return new AuthenticatedVoter();
    }

    @Bean
    public RoleVoter roleVoter(){
        return new RoleVoter();
    }

    @Bean
    public UrlMatchVoter urlMatchVoter(){
        return new UrlMatchVoter();
    }

    @Bean
    public UrlFilterInvocationSecurityMetadataSource securityMetadataSource(){
        return new UrlFilterInvocationSecurityMetadataSource();
    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    public UrlFilterSecurityInterceptor urlFilterSecurityInterceptor(){
        UrlFilterSecurityInterceptor urlFilterSecurityInterceptor = new UrlFilterSecurityInterceptor();
        urlFilterSecurityInterceptor.setAuthenticationManager(authenticationManager);
        urlFilterSecurityInterceptor.setAccessDecisionManager(accessDecisionManager());
        urlFilterSecurityInterceptor.setSecurityMetadataSource(securityMetadataSource());
        return urlFilterSecurityInterceptor;
    }

}
