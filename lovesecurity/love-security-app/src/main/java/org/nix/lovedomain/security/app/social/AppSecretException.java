package org.nix.lovedomain.security.app.social;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/2/3
 */
public class AppSecretException extends RuntimeException {

    public AppSecretException() {
    }

    public AppSecretException(String message) {
        super(message);
    }

    public AppSecretException(String message, Throwable cause) {
        super(message, cause);
    }
}
