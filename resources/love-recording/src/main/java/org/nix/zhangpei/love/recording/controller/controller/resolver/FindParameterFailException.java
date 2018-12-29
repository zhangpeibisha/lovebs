package org.nix.zhangpei.love.recording.controller.controller.resolver;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/29
 */
public class FindParameterFailException extends RuntimeException {

    public FindParameterFailException() {
    }

    public FindParameterFailException(String message) {
        super(message);
    }

    public FindParameterFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public FindParameterFailException(Throwable cause) {
        super(cause);
    }

    public FindParameterFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
