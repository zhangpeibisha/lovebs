package org.nix.zpbs.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.nix.zpbs.model.User;
import org.nix.zpbs.pojo.base.BaseResult;
import org.nix.zpbs.pojo.dto.request.user.UserRegisterDTO;
import org.nix.zpbs.service.UserService;
import org.nix.zpbs.utils.social.SocialUserInfo;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

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

    @Resource
    private ProviderSignInUtils providerSignInUtils;

    @ApiOperation(value = "用户注册接口",nickname = "register",notes = "返回注册成功信息")
    @ApiResponses(value = {
            @ApiResponse(code = 400,message = "用户请求输入坏的参数的时候",response = RuntimeException.class)
    })
    @PostMapping(value = "/info")
    public BaseResult register(@Valid UserRegisterDTO register, HttpServletRequest request){
        userService.register(register,request);
        User userByAccount = userService.getUserByAccount(register.getUserName());
        providerSignInUtils.doPostSignUp(String.valueOf(userByAccount.getId())
                ,new ServletWebRequest(request));
        return new BaseResult().success("注册成功,用户id为:");
    }

    @ApiOperation(value = "获取社交用户信息的接口",nickname = "getSocialUserInfo",notes = "返回社交用户信息")
    @GetMapping(value = "/socialUserInfo")
    public SocialUserInfo getSocialUserInfo(HttpServletRequest request){
        // 获取社交用户的信息
        Connection<?> connectionFromSession =
                providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
        SocialUserInfo socialUserInfo = null;
        if (connectionFromSession != null){
            socialUserInfo = new SocialUserInfo();
            socialUserInfo.setHeadimg(connectionFromSession.getImageUrl());
            socialUserInfo.setNickname(connectionFromSession.getDisplayName());
            ConnectionKey key = connectionFromSession.getKey();
            socialUserInfo.setProviderId(key.getProviderId());
            socialUserInfo.setProviderUserId(key.getProviderUserId());
        }
        if (socialUserInfo == null){
            throw new RuntimeException("用户未绑定社交账号");
        }
        return socialUserInfo;
    }

}
