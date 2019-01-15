package org.nix.zpbs.config.properties.security;

import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/16
 */
@Data
public class BrowserProperties {

    /**
     * 默认登陆页
     */
    private String loginPage = "/login/signIn.html";

    /**
     * 登陆方式，默认返回JSON
     */
    private LoginType loginType = LoginType.JSON;

    /**
     * 登陆失败页
     */
    private String loginFailPage = "/login/signIn.html";

    public static enum LoginType{
        /**
         * 登陆方式定义，跳转和JSON
         */
        REDIRECT,
        JSON;
    }

}
