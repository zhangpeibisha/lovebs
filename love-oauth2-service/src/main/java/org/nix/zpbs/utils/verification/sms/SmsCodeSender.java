package org.nix.zpbs.utils.verification.sms;

/**
 * 定义给手机发送短信
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/19
 */
public interface SmsCodeSender {

    void send(String mobile, String code);

}
