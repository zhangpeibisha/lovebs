package org.nix.zpbs.utils.social;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

/**
 * 默认是否需要用户注册信息
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/22
 */
@Component
public class LoveConnectionSignUp implements ConnectionSignUp {

    /**
     * 使用用户昵称作为唯一标识
     * @param connection 获取社交的链接信息
     * @return 返回唯一标识信息
     */
    @Override
    public String execute(Connection<?> connection) {
        return connection.getDisplayName();
    }
}
