package org.nix.zpbs.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.nix.zpbs.utils.verification.image.ImageVerification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 各种验证码控制器
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/17
 */
@Api(description = "用于对用户申请的验证码进行生成和校验的控制器")
@RequestMapping(value = "/verification")
@RestController
public class VerificationController {

    @Resource
    private ImageVerification imageVerification;

    @ApiOperation(value = "图片验证码生成器")
    @GetMapping(value = "/image")
    public void createImageVerification(HttpServletRequest request, HttpServletResponse response){
        imageVerification.createVerification(request,response);
    }

}
