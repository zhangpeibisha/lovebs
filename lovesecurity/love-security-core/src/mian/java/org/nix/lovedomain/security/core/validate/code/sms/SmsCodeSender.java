package org.nix.lovedomain.security.core.validate.code.sms;

/**
 * @author zhangpei
 * @version 1.0
 * @description Sms发送者接口，定义如何发送短信验证码
 * @date 2019/1/28
 */
public interface SmsCodeSender {

    /**
     * @param mobile 手机号码
     * @param code 验证码
     * @return void
     * @description 由实现类决定以什么方式发送短信验证码
     * @author zhangpe0312@qq.com
     * @date 2019/1/28
     */
    void send(String mobile, String code);

}
