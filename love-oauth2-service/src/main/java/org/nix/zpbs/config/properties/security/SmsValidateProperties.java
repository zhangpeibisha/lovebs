package org.nix.zpbs.config.properties.security;

import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/20
 */
@Data
public class SmsValidateProperties {

    private int length = 6;
    private int expireIn = 60;

    private String url;

}
