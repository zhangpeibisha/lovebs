package org.nix.lovedomain.security.core.properties;

import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @description 第三方应用配置信息
 * @date 2019/1/31
 */
@Data
public class SocialProperties {

    private String filterProcessesUrl = "/auth";

    /**
     * QQ登陆的配置信息
     */
    private QQProperties qq = new QQProperties();
}
