package org.nix.lovedomain.security.core.properties;

/**
 * @author zhangpei
 * @version 1.0
 * @description 系统常量信息
 * @date 2019/1/27
 */
public interface SecurityConstants {
    /**
     * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
     *
     * @see org.nix.lovedomain.security.core.validate.code.ValidateCodeType
     */
    String DEFAULT_PARAMETER_NAME_CODE_SMS = "sms";
    /**
     * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
     *
     * @see org.nix.lovedomain.security.core.validate.code.ValidateCodeType
     */
    String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "image";
    /**
     * 发送短信验证码 或 验证短信验证码时，传递手机号的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";
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
    String DEFAULT_LOGOUT_PAGE_URL = "";
    /**
     * 默认注册页面
     */
    String DEFAULT_SIGN_UP_PAGE_URL = "/love-signUp.html";
    /**
     * session失效默认的跳转地址
     */
    String DEFAULT_SESSION_INVALID_URL = "/session/invalid";
    /**
     * openid参数名
     */
    String DEFAULT_PARAMETER_NAME_OPENID = "openId";
    /**
     * providerId参数名
     */
    String DEFAULT_PARAMETER_NAME_PROVIDERID = "providerId";
    /**
     * 默认的OPENID登录请求处理url
     */
    String DEFAULT_LOGIN_PROCESSING_URL_OPENID = "/authentication/openid";
}
