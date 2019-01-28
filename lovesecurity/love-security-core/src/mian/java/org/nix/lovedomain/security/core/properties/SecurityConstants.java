package org.nix.lovedomain.security.core.properties;

/**
 * @author zhangpei
 * @version 1.0
 * @description 系统常量信息
 * @date 2019/1/27
 */
public interface SecurityConstants {
    /**
     * 校验时从请求中获取的参数的名字
     *
     * @see org.nix.lovedomain.security.core.validate.code.ValidateCodeType
     */
    String DEFAULT_PARAMETER_NAME_CODE_SMS = "sms";
    /**
     * 校验时从请求中获取的参数的名字
     *
     * @see org.nix.lovedomain.security.core.validate.code.ValidateCodeType
     */
    String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "image";
    /**
     * 请求验证码生成的路径前缀
     *
     * @see org.nix.lovedomain.security.core.validate.code.ValidateCodeController
     */
    String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/validate";
    /**
     * 默认的用户名密码登录请求处理url
     *
     * @see org.nix.lovedomain.security.core.validate.code.ValidateCodeFilter
     */
    String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/authentication/form";
    /**
     * 默认的手机验证码登录请求处理url
     *
     * @see org.nix.lovedomain.security.core.validate.code.ValidateCodeFilter
     */
    String DEFAULT_LOGIN_PROCESSING_URL_MOBILE = "/authentication/mobile";
    /**
     * 当请求需要身份认证时，默认跳转的url
     *
     * @see org.nix.lovedomain.security.core.authentication.AbstractChannelSecurityConfig
     */
    String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";
    /**
     * 默认的登陆页面的url
     */
    String DEFAULT_LOGIN_PAGE_URL = "/love-signIn.html";
    /**
     * 默认的登出页面
     */
    String DEFAULT_LOGOUT_PAGE_URL = "/love-signUp.html";
}
