/**
 *
 */
package org.nix.zpbs.utils.verification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zhailiang
 */
@Component
public class ValidateCodeGenerateHolder {

    @Autowired
    private Map<String, ConfirmationCode> confirmationCodeMap;

    public ConfirmationCode findValidateCodeProcessor(ValidateCodeType type) {
        return findValidateCodeProcessor(type.toString().toLowerCase());
    }

    public ConfirmationCode findValidateCodeProcessor(String type) {
        // 获取处理器的名字
        String name = type.toLowerCase() + ConfirmationCode.class.getSimpleName();
        // 查询处理器是否存在
        ConfirmationCode processor = confirmationCodeMap.get(name);
        if (processor == null) {
            throw new ValidateCodeException("验证码处理器" + name + "不存在");
        }
        return processor;
    }

}
