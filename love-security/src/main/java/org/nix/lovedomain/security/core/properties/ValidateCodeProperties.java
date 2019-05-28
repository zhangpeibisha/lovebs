package org.nix.lovedomain.security.core.properties;

import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @description 验证码配置信息，是全部的验证码配置集合
 * @date 2019/1/27
 */
@Data
public class ValidateCodeProperties {

    /**
     * @see ImageProperties
     * 图片验证码特有的配置信息
     */
    private ImageProperties image = new ImageProperties();

    /**
     * @see SmsProperties
     * 短信验证码特有的配置信息
     */
    private SmsProperties sms = new SmsProperties();
}
