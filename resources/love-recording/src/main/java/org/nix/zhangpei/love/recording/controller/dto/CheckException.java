package org.nix.zhangpei.love.recording.controller.dto;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/28
 */
public class CheckException extends Exception{

    public CheckException() {
    }

    public CheckException(String message) {
        super(message);
    }

    public CheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckException(Throwable cause) {
        super(cause);
    }

    public CheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
