package org.nix.zpbs.utils.verification.sms;

import org.nix.zpbs.utils.verification.AbstractConfirmationCode;
import org.nix.zpbs.utils.verification.ValidateCode;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import javax.annotation.Resource;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/19
 */
@Component("smsConfirmationCode")
public class SmsConfirmationCode extends AbstractConfirmationCode {

    @Resource
    private SmsCodeSender smsCodeSender;

    @Override
    protected void send(ServletWebRequest request, ValidateCode generate) throws Exception {
        String paramName = "phone";
        // 获取到参数的值
        String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);
        smsCodeSender.send(mobile, generate.getCode());
    }
}
