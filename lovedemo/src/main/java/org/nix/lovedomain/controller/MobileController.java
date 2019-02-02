package org.nix.lovedomain.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangpei
 * @version 1.0
 * @description 移动设备控制器
 * @date 2019/1/31
 */
@RestController
public class MobileController {

    @PostMapping("/authentication/mobile")
    public String validateSuccess(){
        return "短信登陆成功";
    }

}
