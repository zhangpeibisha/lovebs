package org.nix.lovedomain.security.core.social.qq.connet;

import org.nix.lovedomain.security.core.social.qq.api.QQ;
import org.nix.lovedomain.security.core.social.qq.api.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * @author zhangpei
 * @version 1.0
 * @description 构建QQ服务提供者从而和
 * API {@link core.social.qq.api} 组合创建一个链接工厂 {@link QQConnectionFactory}
 * @date 2019/1/31
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    private String appId;
    /**
     * 将用户导向第三方服务
     */
    private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";
    /**
     * 授权后获取令牌的地址
     */
    private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";

    /**
     * @param appId     QQ互联申请的应用id
     * @param appSecret QQ互联申请的应用密码
     * @description 构建一个QQ服务提供商
     * @author zhangpe0312@qq.com
     * @date 2019/1/31
     */
    public QQServiceProvider(String appId, String appSecret) {
        super(new QQOAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
        this.appId = appId;
    }

    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken, appId);
    }
}
