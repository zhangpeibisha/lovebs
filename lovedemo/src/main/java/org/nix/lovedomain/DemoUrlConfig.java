package org.nix.lovedomain;

import org.nix.lovedomain.security.core.oauthorize.AuthorizeConfigProvider;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * @author zhangpei
 * @version 1.0
 * @description url权限设置
 * @date 2019/2/7
 */
@Component
public class DemoUrlConfig implements AuthorizeConfigProvider {

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry urlRegistry) {
        urlRegistry.antMatchers(HttpMethod.POST, "/user/browser/register").permitAll();
        urlRegistry.antMatchers("/social/user").permitAll();
    }
}
