package org.nix.lovedomain.controller;

import org.nix.lovedomain.security.browser.dto.BaseResultDTO;
import org.springframework.http.HttpStatus;
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
    public BaseResultDTO validateSuccess(){
        return new BaseResultDTO("短信登陆成功",HttpStatus.OK);
    }

}
