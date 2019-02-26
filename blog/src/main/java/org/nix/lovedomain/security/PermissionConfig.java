package org.nix.lovedomain.security;

import org.nix.lovedomain.security.core.oauthorize.AuthorizeConfigProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * @author zhangpei
 * @version 1.0
 * @description 权限配置
 * @date 2019/2/26
 */
@Component
public class PermissionConfig implements AuthorizeConfigProvider {

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry urlRegistry) {
        // 登陆部分都不需要权限
        urlRegistry.antMatchers("/login/**").permitAll();
    }
}
