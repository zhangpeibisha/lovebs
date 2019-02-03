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
    private OAuth2ClientProperties[] clients = {};
}
