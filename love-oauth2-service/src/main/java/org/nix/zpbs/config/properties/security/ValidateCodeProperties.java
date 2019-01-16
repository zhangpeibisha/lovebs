package org.nix.zpbs.config.properties.security;

import lombok.Data;

/**
 * 验证码配置管理
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/16
 */
@Data
public class ValidateCodeProperties {
    /**
     * 验证码超时时间
     */
    private Integer expired = 60;
    /**
     * 请求发送给服务器存储该key的value为验证码的值
     */
    private String requestValidateKey = "imageKey";
}
