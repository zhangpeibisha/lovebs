package org.nix.zpbs.utils.verification.sms;

import org.nix.zpbs.utils.verification.Generate;
import org.nix.zpbs.utils.verification.ValidateCode;
import org.springframework.stereotype.Component;

/**
 * 一个短信验证码生成器
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/18
 */
public class SmsGenerate implements Generate {

    /**
     * @return 创建一个验证码对象
     */
    @Override
    public ValidateCode generate() {
        return new ValidateCode("123456",60);
    }
}
