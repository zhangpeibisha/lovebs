package org.nix.lovedomain.controller;

import org.nix.lovedomain.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangpei
 * @version 1.0
 * @description 用户控制器，执行一些关于用户的操作
 * @date 2019/2/1
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @PostMapping("/register")
    public void register(User user, HttpServletRequest request) {

        //不管是注册用户还是绑定用户，都会拿到一个用户唯一标识。
        String userId = user.getUsername();
        // 执行注册操作
        providerSignInUtils.doPostSignUp(userId, new ServletWebRequest(request));
    }

}
