package org.nix.zpbs.config.properties.constants;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/19
 */
public interface LoginConstants {

    /**
     * 当请求需要身份认证时，默认跳转的url
     * @see org.nix.zpbs.controller.OAuth2Controller
     * @see org.nix.zpbs.config.security.SecurityConfig
     * @see org.nix.zpbs.config.properties.security.BrowserProperties
     * @see {signIn.html}
     */
    String DEFAULT_UNAUTHENTICATED_URL = "/authentication/require";

    /**
     * 默认的用户名密码登录请求处理url
     * @see org.nix.zpbs.config.security.SecurityConfig 使用
     */
    String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/authentication/form";

    /**
     * 默认登录页面
     * @see org.nix.zpbs.config.security.SecurityConfig
     * @see org.nix.zpbs.config.properties.security.BrowserProperties
     */
    String DEFAULT_LOGIN_PAGE_URL = "/login/signIn.html";

    /**
     * 由于不加static会被安全框架拦截，所以需要加入使得访问这个页面不用鉴权
     * @see org.nix.zpbs.config.security.SecurityConfig
     */
    String DEFAULT_STATIC_LOGIN_PAGE_URL = "/static/login/signIn.html";

    /**
     * html登陆页面里的数据都不用鉴权
     * @see org.nix.zpbs.config.security.SecurityConfig
     */
    String DEFAULT_LOGIN_HEMTP_PACK = "/login/**";
}
