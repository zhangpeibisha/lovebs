package org.nix.lovedomain.security.core.oauthorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * @author zhangpei
 * @version 1.0
 * @description 收集所有权限配置信息
 * @date 2019/2/6
 */
public interface AuthorizeConfigManger {

    /**
     * @param urlRegistry 配置url权限的对象
     * @return void
     * @description 收集所有权限配置信息
     * @author zhangpe0312@qq.com
     * @date 2019/2/6
     */
    void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry urlRegistry);

}
