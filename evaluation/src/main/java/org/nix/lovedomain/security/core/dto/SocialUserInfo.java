package org.nix.lovedomain.security.core.dto;

import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @description 第三方用户信息实体类
 * @date 2019/2/1
 */
@Data
public class SocialUserInfo {
    /**
     * 本系统中的应用id
     */
    private String providerId;
    /**
     * 用户在第三方应用的唯一id
     */
    private String providerUserId;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 用户头像
     */
    private String headImg;
}
