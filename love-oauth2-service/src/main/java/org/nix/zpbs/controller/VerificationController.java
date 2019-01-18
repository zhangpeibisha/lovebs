package org.nix.zpbs.controller;

import io.swagger.annotations.Api;
import org.nix.zpbs.utils.verification.ValidateCodeGenerateHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

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
    private ValidateCodeGenerateHolder validateCodeProcessorHolder;

    /**
     * 创建验证码，根据验证码类型不同，调用不同的 {@link ValidateCodeGenerateHolder}接口实现
     *
     * @param request 请求
     * @param response 响应
     * @param type 验证码类型
     * @throws Exception 发生的意外
     */
    @GetMapping("/{type}")
    public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type)
            throws Exception {
        validateCodeProcessorHolder.findValidateCodeProcessor(type)
                .create(new ServletWebRequest(request, response));
    }

}
