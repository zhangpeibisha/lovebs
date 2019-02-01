package org.nix.lovedomain.security.core.properties;

import lombok.Data;
import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author zhangpei
 * @version 1.0
 * @description Weixin配置文件
 * @date 2019/2/1
 */
@Data
public class WeixinProperties extends SocialProperties {
    /**
     * 第三方id，用来决定发起第三方登录的url，默认是 weixin。
     */
    private String providerId = "weixin";
}
