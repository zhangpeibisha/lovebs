package org.nix.zhangpei.love.recording.controller.controller;

import com.alibaba.fastjson.JSON;
import org.nix.zhangpei.love.recording.controller.controller.resolver.User;
import org.nix.zhangpei.love.recording.controller.dto.result.BaseResultDTO;
import org.nix.zhangpei.love.recording.controller.dto.result.UserInfoResult;
import org.nix.zhangpei.love.recording.controller.dto.user.UserLoginDTO;
import org.nix.zhangpei.love.recording.controller.dto.user.UserRegisterDTO;
import org.nix.zhangpei.love.recording.controller.dto.user.UserUpdateDTO;
import org.nix.zhangpei.love.recording.service.UserService;
import org.nix.zhangpei.love.recording.service.vo.UserVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.PostUpdate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/28
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping(value = "/login")
    public BaseResultDTO login(@ModelAttribute UserLoginDTO userLogin, HttpServletRequest request) {
        UserVO userVO = userService.checkLoginInfo(userLogin);
        if (userVO == null) {
            return new BaseResultDTO("登陆失败",HttpStatus.BAD_REQUEST.value());
        }
        HttpSession session = request.getSession();
        session.setAttribute("user",userVO);
        session.invalidate();
        return new BaseResultDTO("登陆成功",HttpStatus.OK.value());
    }

    @PostMapping(value = "/register")
    public BaseResultDTO register(@ModelAttribute UserRegisterDTO userRegister){
        userService.register(userRegister);
        return new BaseResultDTO("注册成功",HttpStatus.OK.value());
    }

    @PutMapping(value = "/update")
    public BaseResultDTO updateUserInfo(@RequestBody UserUpdateDTO userUpdate, @User UserVO userVO){
        UserVO updateUser = userService.updateUser(userUpdate);
        if (updateUser != null){
            return new UserInfoResult("更新成功",HttpStatus.OK.value(),updateUser);
        }
        return new UserInfoResult("更新失败",HttpStatus.BAD_REQUEST.value());
    }
}

