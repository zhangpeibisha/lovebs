package org.nix.lovedomain.security;

import org.nix.lovedomain.rbac.service.interfaces.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.SynchronousQueue;

/**
 * @author zhangpei
 * @version 1.0
 * @description rbac权限服务具体实现
 * @date 2019/2/7
 */
@Component("rbacServiceImpl")
public class RbacServiceImpl implements RbacService {

    @Autowired
    private PermissionService permissionService;
    /**
     * 路径匹配工具
     */
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            String username = userDetails.getUsername();
            // 读取用户所有用的所有url
            Set<String> urls = new HashSet<>();
            // 当前请求的uri
            String requestURI = request.getRequestURI();
            for (String url : urls) {
                if (antPathMatcher.match(url,requestURI)){
                    return true;
                }
            }
        }
        SynchronousQueue synchronousQueue;
        return false;
    }
}
