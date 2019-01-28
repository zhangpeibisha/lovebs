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
     * 默认的登出页面
     */
    private String signUpUrl = SecurityConstants.DEFAULT_LOGOUT_PAGE_URL;
}
