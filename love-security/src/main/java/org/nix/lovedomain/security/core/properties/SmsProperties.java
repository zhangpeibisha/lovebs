package org.nix.lovedomain.security.core.properties;

import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @description 短信验证码配置类信息
 * @date 2019/1/27
 */
@Data
public class SmsProperties {
    /**
     * 验证码长度
     */
    private int length = 6;
    /**
     * 过期时间
     */
    private int expireIn = 60;
    /**
     * 需要图片验证的路径
     */
    private String validateUrls;

}
