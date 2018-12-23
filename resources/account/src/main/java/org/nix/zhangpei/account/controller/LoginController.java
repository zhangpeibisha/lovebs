package org.nix.zhangpei.account.controller;

import org.nix.zhangpei.account.controller.dto.LoginDTO;
import org.nix.zhangpei.account.controller.dto.base.BaseDTO;
import org.nix.zhangpei.account.service.LoginService;
import org.nix.zhangpei.account.service.vo.LoginVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/23
 */
@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping(value = "/{account}/{password}")
    public LoginDTO login(@PathVariable(value = "account")String account,
                          @PathVariable(value = "password")String password){
        LoginVO login = loginService.login(account, password);
        return new LoginDTO(true,"登陆成功",200,login);
    }

    @PostMapping(value = "/{account}/{password}")
    public BaseDTO register(@PathVariable(value = "account")String account,
                            @PathVariable(value = "password")String password){
        loginService.register(account,password);
        return new BaseDTO(true,"注册成功",200);
    }


}
