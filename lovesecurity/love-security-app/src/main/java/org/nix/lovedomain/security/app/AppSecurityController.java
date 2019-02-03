package org.nix.lovedomain.security.app;

import org.nix.lovedomain.security.app.social.AppSingUpUtils;
import org.nix.lovedomain.security.core.dto.SocialUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangpei
 * @version 1.0
 * @description 将社交账号的信息封装到UserInfo里面
 * @date 2019/2/3
 */
@RestController
public class AppSecurityController {
    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @Autowired
    private AppSingUpUtils appSingUpUtils;

    /**
     * @param request
     * @return org.nix.lovedomain.security.core.dto.SocialUserInfo
     * @description 实现第三方登陆注册操作
     * @author zhangpe0312@qq.com
     * @date 2019/2/3
     */
    @GetMapping("/social/signUp")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public SocialUserInfo getSocialUserInfo(HttpServletRequest request) {
        SocialUserInfo userInfo = new SocialUserInfo();
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
        userInfo.setProviderId(connection.getKey().getProviderId());
        userInfo.setProviderUserId(connection.getKey().getProviderUserId());
        userInfo.setNickname(connection.getDisplayName());
        userInfo.setHeadImg(connection.getImageUrl());
        // 将session进行转存到redis中
        appSingUpUtils.saveConnectionData(new ServletWebRequest(request), connection.createData());
        return userInfo;
    }
}
