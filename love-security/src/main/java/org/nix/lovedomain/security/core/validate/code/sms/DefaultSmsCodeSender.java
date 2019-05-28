package org.nix.lovedomain.security.core.validate.code.sms;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangpei
 * @version 1.0
 * @description 默认实现手机短信验证码发送
 * @date 2019/1/28
 */
@Slf4j
public class DefaultSmsCodeSender implements SmsCodeSender {

    /**
     * @param mobile 手机号码
     * @param code   验证码
     * @return void
     * @description 打印在日志中，实际使用需要自己另外实现
     * @author zhangpe0312@qq.com
     * @date 2019/1/28
     */
    @Override
    public void send(String mobile, String code) {
        log.info("向手机{}发送短信验证码{}", mobile, code);
    }

}
