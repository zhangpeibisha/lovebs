package org.nix.lovedomain.security.core.properties;

import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @description 浏览器属性配置类
 * @date 2019/1/27
 */
@Data
public class BrowserProperties {

    /**
     * 用户登陆响应类型
     */
    private LoginResponseType loginType = LoginResponseType.JSON;

    /**
     * 记住我功能的多少秒
     */
    private int rememberMeSeconds = 3600;

    /**
     * 默认的登陆页面
     */
    private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;
    /**
     * 默认的注册页面
     */
    private String signUpUrl = SecurityConstants.DEFAULT_SIGN_UP_PAGE_URL;
    /**
     * 默认注销成功返回页面
     */
    private String logoutPage = SecurityConstants.DEFAULT_LOGOUT_PAGE_URL;
    /**
     * 设置默认的退出url路径
     */
    private String logoutUrl = "/logout";
    /**
     * session配置
     */
    private SessionProperties session = new SessionProperties();
    /**
     * 登陆成功跳转的页面
     */
    private String loginSuccessPage = SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM;

}
