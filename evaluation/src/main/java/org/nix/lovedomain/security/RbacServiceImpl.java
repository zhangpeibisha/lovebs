package org.nix.lovedomain.security;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.model.ResourcesModel;
import org.nix.lovedomain.service.ResourcesService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
     * 路径匹配工具
     */
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public boolean hasPermission(HttpServletRequest httpServletRequest, Authentication authentication) {
        if (isDisable(httpServletRequest)) {
            return false;
        }
        return userHasPermission(httpServletRequest, authentication);
    }

    /**
     * 判断该资源是否禁用
     *
     * @param httpServletRequest
     * @return
     */
    private boolean isDisable(HttpServletRequest httpServletRequest) {
        String requestURI = httpServletRequest.getRequestURI();
        String method = httpServletRequest.getMethod();
        List<ResourcesModel> disableUrl = resourcesService.findDisableUrl();
        if (CollUtil.isEmpty(disableUrl)) {
            return false;
        }
        for (ResourcesModel resourcesModel : disableUrl) {
            boolean access = antPathMatcher.match(resourcesModel.getUrl(), requestURI)
                    && methodMatch(method,resourcesModel.getMethod());
            if (access) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断用户是否拥有权限
     *
     * @param httpServletRequest
     * @param authentication
     * @return
     */
    private boolean userHasPermission(HttpServletRequest httpServletRequest, Authentication authentication) {
        String requestURI = httpServletRequest.getRequestURI();
        String method = httpServletRequest.getMethod();
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetail) {
            List<UrlGrantedAuthority> grantedAuthorities = ((UserDetail) principal).getGrantedAuthorities();
            for (UrlGrantedAuthority next : grantedAuthorities) {
                if (antPathMatcher.match(next.getUrl(), requestURI)) {
                    String resourceMethod = next.getHttpMethod();
                    if (resourceMethod == null) {
                        return true;
                    }
                    return methodMatch(method,resourceMethod);
                }
            }
            return false;
        }
        log.info("不是指定类型的用户{},class={}", JSONUtil.toJsonStr(principal), principal.getClass());
        return false;
    }

    private boolean methodMatch(String expectation,String match){
        return findMethods(match).contains(expectation);
    }

    private List<String> findMethods(String methods) {
        if (methods.contains(",")) {
            return CollUtil.newArrayList(methods.split(","));
        }
        return CollUtil.newArrayList(methods);
    }
}
