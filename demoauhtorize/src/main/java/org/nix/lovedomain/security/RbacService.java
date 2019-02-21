package org.nix.lovedomain.security;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangpei
 * @version 1.0
 * @description 权限配置接口
 * @date 2019/2/7
 */
public interface RbacService {
    /**
     * @param request 用户请求
     * @param authentication 用户信息
     * @return boolean
     * @description 判断用户是否有某个权限没有
     * @author zhangpe0312@qq.com
     * @date 2019/2/7
     */
    boolean hasPermission(HttpServletRequest request, Authentication authentication);

}
