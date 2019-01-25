package org.nix.zpbs.config.properties.security;

import lombok.Data;
import org.nix.zpbs.config.properties.constants.DefaultConstants;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/16
 */
@Data
public class BrowserProperties {

    /**
     * 请求登陆验证的路径
     */
    private String loginRequestUrl = DefaultConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM;

    /**
     * 默认登陆页
     */
    private String loginPage = DefaultConstants.DEFAULT_LOGIN_PAGE_URL;

    /**
     * 登陆方式，默认返回JSON
     */
    private LoginType loginType = LoginType.JSON;

    /**
     * 登陆失败页
     */
    private String loginFailPage = "/login/signIn.html";

    /**
     * 注册页
     */
    private String signUpUrl = "/login/register.html";

    private SessionProperties session = new SessionProperties();

    public static enum LoginType {
        /**
         * 登陆方式定义，跳转和JSON
         */
        REDIRECT,
        JSON;
    }

}
