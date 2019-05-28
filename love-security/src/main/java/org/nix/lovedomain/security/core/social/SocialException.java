package org.nix.lovedomain.security.core.social;

/**
 * @author zhangpei
 * @version 1.0
 * @description 社交异常处理类
 * @date 2019/1/31
 */
public class SocialException extends RuntimeException{

    public SocialException() {
    }

    public SocialException(String message) {
        super(message);
    }

    public SocialException(String message, Throwable cause) {
        super(message, cause);
    }
}
