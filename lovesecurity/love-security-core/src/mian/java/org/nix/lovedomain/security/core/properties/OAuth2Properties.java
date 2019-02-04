package org.nix.lovedomain.security.core.properties;

import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @description oauth2配置信息
 * @date 2019/2/3
 */
@Data
public class OAuth2Properties {
    /**
     * 配置客户端信息
     */
    private OAuth2ClientProperties[] clients = {};

    /**
     * jwt密钥配置
     */
    private String jwtSigningKey = "love-zhang-pei-bi-sha";
}
