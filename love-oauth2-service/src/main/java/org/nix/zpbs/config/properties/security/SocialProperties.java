package org.nix.zpbs.config.properties.security;

import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/16
 */
@Data
public class SocialProperties {
    private String filterProcessesUrl = "/auth";
    private QQProperties qq = new QQProperties();
}
