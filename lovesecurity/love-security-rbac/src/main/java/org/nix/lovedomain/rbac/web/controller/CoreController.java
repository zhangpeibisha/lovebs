package org.nix.lovedomain.rbac.web.controller;

import org.nix.lovedomain.rbac.util.auth.core.extractor.PermissionResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhangpei
 * @version 1.0
 * @description 核心控制器
 * @date 2019/2/18
 */
@Controller
public class CoreController {

    @GetMapping("/")
    @PermissionResource(name = "登陆页",description = "登录页跳转,属于通用资源",open = true)
    public String index() {
        return "login";
    }


    @GetMapping("/page/{page}")
    public String jump(@PathVariable("page") String page) {
        return page;
    }
}
