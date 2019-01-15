package org.nix.zpbs.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.nix.zpbs.pojo.base.BaseResult;
import org.nix.zpbs.pojo.dto.request.user.UserRegisterDTO;
import org.nix.zpbs.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 用户接口
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/8
 */
@RestController
@Api(description = "用户控制器接口")
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "用户注册接口",nickname = "register",notes = "返回注册成功信息")
    @ApiResponses(value = {
            @ApiResponse(code = 400,message = "用户请求输入坏的参数的时候",response = RuntimeException.class)
    })
    @PostMapping(value = "/info")
    public BaseResult register(@Valid UserRegisterDTO register, HttpServletRequest request){
        userService.register(register,request);
        return new BaseResult().success("注册成功");
    }


}
