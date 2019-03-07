package org.nix.lovedomain.security;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangpei
 * @version 1.0
 * @description Rbac服务实现
 * @date 2019/3/7
 */
@Slf4j
@Component
public class RbacServiceImpl implements RbacService {

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof AuthenUserDetail) {
            log.info("获取用户信息{}", JSONUtil.toJsonStr(principal));
            return true;
        }
        log.info("不是指定类型的用户{},class={}", JSONUtil.toJsonStr(principal), principal.getClass());
        return false;
    }
}
