package org.nix.lovedomain.security.core.social.qq.connet;

import org.nix.lovedomain.security.core.social.qq.api.QQ;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * @author zhangpei
 * @version 1.0
 * @description QQ链接工厂
 * @date 2019/1/31
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {
    public QQConnectionFactory(String providerId, String appId, String appSecret) {
        super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
    }
}
