package org.nix.zpbs.utils.verification;

import org.springframework.security.core.AuthenticationException;

/**
 * 验证码权限异常
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/17
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg, Throwable t) {
        super(msg, t);
    }

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
