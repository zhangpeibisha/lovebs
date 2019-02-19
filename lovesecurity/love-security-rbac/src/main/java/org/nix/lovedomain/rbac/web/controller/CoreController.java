package org.nix.lovedomain.rbac.web.controller;

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
    public String index() {
        return "login";
    }


    @GetMapping("/page/{page}")
    public String jump(@PathVariable("page") String page) {
        return page;
    }
}
