package org.nix.lovedomain.security.core.social.weixin.api;

/**
 * @author zhangpei
 * @version 1.0
 * @description 微信API接口，主要用来获取微信用户的授权信息
 * @date 2019/2/1
 */
public interface Weixin {
    /**
     * @param openId 用户在微信端的唯一id
     * @return WeixinUserInfo
     * @description 获取微信用户的用户信息
     * @author zhangpe0312@qq.com
     * @date 2019/2/1
     */
    WeixinUserInfo getUserInfo(String openId);

}
