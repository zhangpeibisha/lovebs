package org.nix.lovedomain.security;

import org.nix.lovedomain.security.core.oauthorize.AuthorizeConfigProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

@Component
public class EvaluationAuthorizeConfigProvider implements AuthorizeConfigProvider {

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry urlRegistry) {
        urlRegistry.antMatchers("/abcd.html").authenticated();
    }
}
