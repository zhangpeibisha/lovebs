package org.nix.lovedomain.security.core.properties;

import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @description oauth2客户端信息配置
 * @date 2019/2/3
 */
@Data
public class OAuth2ClientProperties {

    private String clientId;

    private String clientSecret;

    private int accessTokenValidateSeconds = 7200;
}
