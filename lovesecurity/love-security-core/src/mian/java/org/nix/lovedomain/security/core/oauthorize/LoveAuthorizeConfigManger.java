package org.nix.lovedomain.security.core.oauthorize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author zhangpei
 * @version 1.0
 * @description 收集rul权限信息实现
 * @date 2019/2/6
 */
@Component
public class LoveAuthorizeConfigManger implements AuthorizeConfigManger{

    @Autowired
    private Set<AuthorizeConfigProvider> authorizeConfigProviders;


    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry urlRegistry) {
        authorizeConfigProviders.forEach(authorizeConfigProvider -> authorizeConfigProvider.config(urlRegistry));
        // 其余请求都需要身份认证
        urlRegistry.anyRequest().authenticated();
    }
}
