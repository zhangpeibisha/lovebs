package org.nix.zpbs.utils.social;

import lombok.Data;

/**
 * 社交用户基本信息
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/22
 */
@Data
public class SocialUserInfo {

    private String providerId;

    private String providerUserId;

    private String nickname;

    private String headimg;

}
