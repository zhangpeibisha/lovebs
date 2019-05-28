package org.nix.lovedomain.security.core.social.qq.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.nix.lovedomain.security.core.social.SocialException;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

/**
 * @author zhangpei
 * @version 1.0
 * @description QQ获取用户信息的实现
 * @date 2019/1/31
 */
@Slf4j
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {
    private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";
    private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";

    private String appId;

    private String openId;

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * @param accessToken 用户同意授权后获取的口令
     * @param appId       应用id
     * @description 由于默认将accessToken放入请求头里面 {@link AbstractOAuth2ApiBinding}
     * 中一个参数的构造函数中，但是QQ的请求放在了请求连接中
     * @author zhangpe0312@qq.com
     * @date 2019/1/31
     */
    public QQImpl(String accessToken, String appId) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.appId = appId;
        String url = String.format(URL_GET_OPENID, accessToken);
        String result = getRestTemplate().getForObject(url, String.class);
        this.openId = StringUtils.substringBetween(result, "\"openid\":\"", "\"}");
        log.info("QQ调用结果信息为：{} \n 获取的openId为：{}", result, openId);
    }

    /**
     * @return QQUserInfo
     * @description {@link QQ#getUserInfo()}
     * @author zhangpe0312@qq.com
     * @date 2019/1/31
     */
    @Override
    public QQUserInfo getUserInfo() {
        String url = String.format(URL_GET_USERINFO, appId, openId);
        String result = getRestTemplate().getForObject(url, String.class);
        log.info("获取QQ用户信息为：{}", result);
        QQUserInfo userInfo;
        try {
            userInfo = objectMapper.readValue(result, QQUserInfo.class);
            userInfo.setOpenId(openId);
            return userInfo;
        } catch (Exception e) {
            throw new SocialException("获取QQ用户信息失败", e);
        }
    }
}
