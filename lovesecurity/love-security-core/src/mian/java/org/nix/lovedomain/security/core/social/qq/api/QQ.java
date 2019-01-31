package org.nix.lovedomain.security.core.social.qq.api;

/**
 * @author zhangpei
 * @version 1.0
 * @description QQ获取用户信息接口
 * @date 2019/1/31
 */
public interface QQ {
    /**
     * @return org.nix.lovedomain.security.core.social.qq.api.QQUserInfo
     * @description 获取QQ用户的详细信息
     * @author zhangpe0312@qq.com
     * @date 2019/1/31
     */
    QQUserInfo getUserInfo();
}
