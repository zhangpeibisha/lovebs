package org.nix.lovedomain.security;

import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.security.core.oauthorize.AuthorizeConfigProvider;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(Integer.MAX_VALUE - 20)
public class EvaluationAuthorizeConfigProvider implements AuthorizeConfigProvider {

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry urlRegistry) {
        urlRegistry.antMatchers("/**")
                .access("@rbacService.hasPermission(request,authentication)");
    }
}
