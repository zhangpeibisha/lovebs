package org.nix.zpbs.utils.verification.sms;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/19
 */
@Slf4j
public class DefaultSmsCodeSender implements SmsCodeSender{

    @Override
    public void send(String mobile, String code) {
        log.info("给手机{}发送验证码{}",mobile,code);
    }
}
