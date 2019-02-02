package org.nix.lovedomain.controller;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangpe0312@qq.com
 * @description 验证认证服务器是否成功
 * @date 2019/2/2
 * @return
 */
public class AuthenticationControllerTest {

    /**
     * 1.获取token信息 GET方法
     * http://localhost:8080/oauth/authorize?response_type=code&client_id=love&scope=all&redirect_uri=http://example.com
     * 2.用户确定授权信息
     * 3.通过token获取到用户权限信息 POST方法
     * http://localhost:8080/oauth/token
     */

    /**
     * @return void
     * @description 获取授权码
     * @author zhangpe0312@qq.com
     * @date 2019/2/2
     */
    @Test
    public void applyAuthorizeCode() {
        // 请求路径
        String authorizeUrl = "http://localhost:8080/oauth/authorize";
        Map<String, Object> parameters = new HashMap<String, Object>();
        // 请求类型，该测试使用授权码
        parameters.put("response_type", "code");
        // 请求获取验证码的第三方应用
        parameters.put("client_id", "love");
        // 授权后重定向url
        parameters.put("redirect_uri", "http://example.com");
        // 授权范围
        parameters.put("scope", "all");

        String result = HttpUtil.get(authorizeUrl, parameters);
        System.out.println(result);
    }

    /**
     * @param
     * @return void
     * @description 获取token
     * @author zhangpe0312@qq.com
     * @date 2019/2/2
     */
    @Test
    public void applyToken() {
//        String tokenUrl = "http://localhost:8080/oauth/token";
//        Map<String, Object> parameters = new HashMap<String, Object>();
//        parameters.put("grant_type", "authorization_code");
//        parameters.put("code", "0gNPYX");
//        parameters.put("redirect_uri", "http://example.com");
//        parameters.put("client_id", "love");
//        parameters.put("client_secret", "love-secret");
//        parameters.put("scope", "all");
//
//        String post = HttpRequest.post(tokenUrl)
//                .header("ContentType", "application/x-www-form-urlencoded")
//                .form(parameters)
//                .execute().body();
//        System.out.println(post);
        String body = HttpRequest.post("http://localhost:8080/oauth/token?\n" +
                "grant_type=authorization_code\n" +
                "&code=0gNPYX&client_id=love\n" +
                "&client_secret=love-secret&redirect_uri=http://baidu.com").execute().body();
        System.out.println(body);
    }
}