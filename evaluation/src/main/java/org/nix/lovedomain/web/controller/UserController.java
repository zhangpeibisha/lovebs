package org.nix.lovedomain.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangpei
 * @version 1.0
 * @description 用户控制器
 * @date 2019/3/7
 */
@RestController
public class UserController {

    @GetMapping(value = "/hello/{id}")
    public String hello(@PathVariable Integer id) {
        return "hello " + id;
    }

}
