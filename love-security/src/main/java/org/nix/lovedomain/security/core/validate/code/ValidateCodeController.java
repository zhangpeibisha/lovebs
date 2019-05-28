package org.nix.lovedomain.security.core.validate.code;

import org.nix.lovedomain.security.core.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhangpei
 * @version 1.0
 * @description 验证码请求内置控制器
 * @date 2019/1/27
 */
@RestController
public class ValidateCodeController {

    @Autowired
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;

    /**
     * @param request 用户请求
     * @param response 用户请求响应
     * @param type 请求验证码类型 {@link ValidateCodeType}
     * @return void
     * @description 创建验证码，根据验证码类型不同，调用不同的 {@link ValidateCodeProcessor}接口实现
     * @author zhangpe0312@qq.com
     * @date 2019/1/27
     */

    @GetMapping(SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/{type}")
    public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type)
            throws Exception {
        validateCodeProcessorHolder.findValidateCodeProcessor(type).create(new ServletWebRequest(request, response));
    }

}
