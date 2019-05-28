package org.nix.lovedomain.security.core.validate.code.sms;

import lombok.Data;
import org.apache.commons.lang.RandomStringUtils;
import org.nix.lovedomain.security.core.properties.SecurityProperties;
import org.nix.lovedomain.security.core.properties.SmsProperties;
import org.nix.lovedomain.security.core.validate.code.ValidateCode;
import org.nix.lovedomain.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhangpei
 * @version 1.0
 * @description Sms短信发送器
 * @date 2019/1/28
 */
@Component("smsValidateCodeGenerator")
@Data
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode generator() {
        SmsProperties sms = securityProperties.getValidate().getSms();
        String code = RandomStringUtils.randomNumeric(sms.getLength());
        return new ValidateCode(code, sms.getExpireIn());
    }
}
