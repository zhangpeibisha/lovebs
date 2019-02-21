package org.nix.lovedomain.security;

import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.security.core.oauthorize.AuthorizeConfigProvider;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description demo模块权限定义 @Order 默认最后加载
 * @date 2019/2/7
 */
@Component
@Order
@Slf4j
public class DemoAuthorizeConfigProvider implements AuthorizeConfigProvider {

    /**
     * @param urlRegistry url权限
     * @return void
     * @description url权限控制
     * @see org.nix.lovedomain.security.rbac.RbacServiceImpl#hasPermission(HttpServletRequest, Authentication)
     * @author zhangpe0312@qq.com
     * @date 2019/2/7
     */
    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry urlRegistry) {
        // 自定义权限表达式
        log.info("进入权限配置 DemoAuthorizeConfigProvider");
//        urlRegistry.antMatchers("/**").permitAll();
        urlRegistry
                .anyRequest()
                .access("@rbacServiceImpl.hasPermission(request,authentication)");
    }

}
