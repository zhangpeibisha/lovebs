package org.nix.lovedomain.security.core.oauthorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * @author zhangpei
 * @version 1.0
 * @description 权限配置接口，用户只需要实现该接口，然后注入到spring容器中时就可以配置好权限信息了
 date 2019/2/6
 */
public interface AuthorizeConfigProvider {

    /**
     * @param urlRegistry 配置url权限的对象
     * @return void
     * @description 配置指定url的使用权限
     * @author zhangpe0312@qq.com
     * @date 2019/2/6
     */
    void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry urlRegistry);

}
