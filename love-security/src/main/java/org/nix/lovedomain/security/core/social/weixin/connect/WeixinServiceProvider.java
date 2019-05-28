package org.nix.lovedomain.security.core.social.weixin.connect;

import org.nix.lovedomain.security.core.social.weixin.api.Weixin;
import org.nix.lovedomain.security.core.social.weixin.api.WeixinImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * @author zhangpei
 * @version 1.0
 * @description 微信服务提供商
 * @date 2019/2/1
 */
public class WeixinServiceProvider extends AbstractOAuth2ServiceProvider<Weixin> {
    /**
     * 微信获取授权码的url
     */
    private static final String URL_AUTHORIZE = "https://open.weixin.qq.com/connect/qrconnect";
    /**
     * 微信获取accessToken的url
     */
    private static final String URL_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token";

    /**
     * @param appId     微信应用id
     * @param appSecret 密码
     * @description 通过应用id和密码生成一个提供商
     * @author zhangpe0312@qq.com
     * @date 2019/2/1
     */

    public WeixinServiceProvider(String appId, String appSecret) {
        super(new WeixinOAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
    }

    /**
     * @param accessToken
     * @return Weixin
     * @description 获取用户信息，通过用户授权口令
     * @author zhangpe0312@qq.com
     * @date 2019/2/1
     * @see org.springframework.social.oauth2.AbstractOAuth2ServiceProvider#getApi(java.lang.String)
     */

    @Override
    public Weixin getApi(String accessToken) {
        return new WeixinImpl(accessToken);
    }
}
