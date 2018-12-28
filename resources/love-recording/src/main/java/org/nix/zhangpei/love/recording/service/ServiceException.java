package org.nix.zhangpei.love.recording.service;

/**
 * 服务异常
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/27
 */
public class ServiceException extends RuntimeException{

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
