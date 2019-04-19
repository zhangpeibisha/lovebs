package org.nix.lovedomain.security.core.social.qq.connet;

import org.nix.lovedomain.security.core.social.qq.api.QQ;
import org.nix.lovedomain.security.core.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @author zhangpei
 * @version 1.0
 * @description QQ API适配器 {@link org.nix.lovedomain.security.core.social.qq.api.QQ}
 * @date 2019/1/31
 */
public class QQAdapter implements ApiAdapter<QQ> {
    /**
     * @param api
     * @return boolean
     * @description 测试API是否通过
     * @author zhangpe0312@qq.com
     * @date 2019/1/31
     */
    @Override
    public boolean test(QQ api) {
        return true;
    }

    /**
     * @param api
     * @param values 链接信息
     * @return void
     * @description 获取远程调用QQ的信息
     * @author zhangpe0312@qq.com
     * @date 2019/1/31
     */
    @Override
    public void setConnectionValues(QQ api, ConnectionValues values) {
        // 拿到QQ的用户信息
        QQUserInfo userInfo = api.getUserInfo();
        // QQ的昵称
        values.setDisplayName(userInfo.getNickname());
        // QQ用户的小头像（40*40）
        values.setImageUrl(userInfo.getFigureurl_qq_1());
        // QQ用户的主页
        values.setProfileUrl(null);
        // QQ用户在服务商那边的唯一标识
        values.setProviderUserId(userInfo.getOpenId());
    }

    /**
     * @param api 通过API获取到用户信息
     * @return org.springframework.social.connect.UserProfile
     * @description 获取到用户的标准信息，进行解绑之类的操作
     * @author zhangpe0312@qq.com
     * @date 2019/1/31
     */
    @Override
    public UserProfile fetchUserProfile(QQ api) {
        return null;
    }

    /**
     * @param api
     * @param message 更新的信息
     * @return void
     * @description 更新个人主页信息
     * @author zhangpe0312@qq.com
     * @date 2019/1/31
     */
    @Override
    public void updateStatus(QQ api, String message) {

    }
}
