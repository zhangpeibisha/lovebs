package org.nix.zpbs.utils.verification.sms;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.nix.zpbs.config.properties.security.SecurityProperties;
import org.nix.zpbs.utils.verification.Generate;
import org.nix.zpbs.utils.verification.ValidateCode;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 一个短信验证码生成器
 *
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/18
 */
@Getter
@Setter
public class SmsGenerate implements Generate {

    @Resource
    private SecurityProperties securityProperties;

    /**
     * @return 创建一个验证码对象
     */
    @Override
    public ValidateCode generate() {
        String code = RandomStringUtils
                .randomNumeric(securityProperties
                        .getValidate()
                        .getSms().getLength());
        return new ValidateCode(code, securityProperties
                .getValidate().getSms().getExpireIn());
    }
}
