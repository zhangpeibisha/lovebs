package org.nix.zpbs.config.properties.security;

import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/25
 */
@Data
public class SessionProperties {
    /**
     * session过期跳转处理的页面
     */
    private String sessionTimeOutUrl = "/authentication/session/timeout";
    /**
     * 一次性这个账户能够登陆多少个session
     */
    private Integer maximumSessions = 1;
    /**
     * 当登陆数量达到最大时，新的登陆是否会把旧的登陆踢掉
     */
    private boolean maxSessionsPreventsLogin;

}
