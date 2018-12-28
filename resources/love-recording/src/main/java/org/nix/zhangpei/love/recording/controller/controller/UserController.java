package org.nix.zhangpei.love.recording.controller.controller;

import org.nix.zhangpei.love.recording.controller.dto.result.BaseResultDTO;
import org.nix.zhangpei.love.recording.controller.dto.user.UserLoginDTO;
import org.nix.zhangpei.love.recording.service.UserService;
import org.nix.zhangpei.love.recording.service.vo.UserVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

}
