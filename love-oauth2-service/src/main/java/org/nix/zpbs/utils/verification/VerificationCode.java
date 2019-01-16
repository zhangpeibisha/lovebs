package org.nix.zpbs.utils.verification;


import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 各种验证码的接口
 *
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/17
 */
public interface VerificationCode {

    /**
     * 创建验证码信息
     * @param request http请求
     * @param response http响应
     */
    void createVerification(HttpServletRequest request, HttpServletResponse response);

    /**
     * 验证码信息验证用户输入是否正确
     * @param request http请求
     * @param response http响应
     */
    void submitVerification(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException;
}
