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
     * 验证码验证路径配置
     */
    private String validateUrl = "/verification/**";
    /**
     * 短信和图片验证码的配置信息
     */
    private ImageValidateProperties image = new ImageValidateProperties();
    private SmsValidateProperties sms = new SmsValidateProperties();
}
