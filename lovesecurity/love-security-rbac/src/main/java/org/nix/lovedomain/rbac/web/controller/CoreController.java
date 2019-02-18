package org.nix.lovedomain.rbac.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Yun
 * @Description:
 * @Date: Created in 2017-12-08 15:23
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
