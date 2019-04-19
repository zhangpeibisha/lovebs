package org.nix.lovedomain.security;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.model.Resources;
import org.nix.lovedomain.security.url.PermissionUrlConfig;
import org.nix.lovedomain.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description Rbac服务实现
 * @date 2019/3/7
 */
@Slf4j
@Component(value = "rbacService")
public class RbacServiceImpl implements RbacService {

    @Resource
    private ResourcesService resourcesService;
    /**
     * 这是不需要鉴权的路径缓存
     */
    private volatile List<Resources> permissionAllCache;

    @Autowired(required = false)
    private List<PermissionUrlConfig> permissionUrlConfigs;

    /**
     * 路径匹配工具
     */
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public boolean hasPermission(HttpServletRequest httpServletRequest, Authentication authentication) {
        loadPermissionAllUrl();
        if (isPermissionUrl(httpServletRequest)) {
            return true;
        }
        return userHasPermission(httpServletRequest, authentication);
    }

    private void loadPermissionAllUrl() {
        if (permissionAllCache == null) {
            synchronized (this) {
                permissionAllCache = new ArrayList<>();
                if (permissionUrlConfigs != null) {
                    permissionUrlConfigs.forEach(permissionUrlConfig -> permissionUrlConfig.config(permissionAllCache));
                }
                permissionAllCache.addAll(resourcesService.findPermissionAllResources());
            }
        }
    }

    private boolean isPermissionUrl(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        for (Resources next : permissionAllCache) {
            if (antPathMatcher.match(next.getUrl(), requestURI)) {
                String resourceMethod = next.getMethod();
                if (resourceMethod == null) {
                    return true;
                }
                return resourceMethod.toUpperCase()
                        .equals(method.toUpperCase());
            }
        }
        return false;
    }

    private boolean userHasPermission(HttpServletRequest httpServletRequest, Authentication authentication) {
        String requestURI = httpServletRequest.getRequestURI();
        String method = httpServletRequest.getMethod();
        Object principal = authentication.getPrincipal();
        if (principal instanceof AuthenUserDetail) {
            log.info("获取用户信息{}", JSONUtil.toJsonStr(principal));
            List<UrlGrantedAuthority> grantedAuthorities = ((AuthenUserDetail) principal).getGrantedAuthorities();
            for (UrlGrantedAuthority next : grantedAuthorities) {
                if (antPathMatcher.match(next.getUrl(), requestURI)) {
                    String resourceMethod = next.getHttpMethod();
                    if (resourceMethod == null) {
                        return true;
                    }
                    return resourceMethod.toUpperCase()
                            .equals(method.toUpperCase());
                }
            }
            return false;
        }
        log.info("不是指定类型的用户{},class={}", JSONUtil.toJsonStr(principal), principal.getClass());
        return false;
    }
}
