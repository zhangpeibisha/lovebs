package org.nix.lovedomain.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @author zhangpei
 * @version 1.0
 * @description 验证码异常
 * @date 2019/1/27
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String message) {
        super(message);
    }

    public ValidateCodeException(String message, Throwable cause) {
        super(message, cause);
    }
}
