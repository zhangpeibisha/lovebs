package org.nix.lovedomain.security;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;

/**
 * @author zhangpei
 * @version 1.0
 * @description 第三方登陆后的自定义处理方式，默认会跳转到注册页面 {@link org.nix.lovedomain.security.core.social.SocialConfig}
 * @date 2019/2/1
 */
//@Component
public class DemoConnectionSignUp implements ConnectionSignUp {
    @Override
    public String execute(Connection<?> connection) {
        //根据社交用户信息默认创建用户并返回用户唯一标识
        return connection.getDisplayName();
    }
}
