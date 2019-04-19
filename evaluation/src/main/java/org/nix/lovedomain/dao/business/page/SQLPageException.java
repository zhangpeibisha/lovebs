package org.nix.lovedomain.dao.business.page;

/**
 * @author zhangpei
 * @version 1.0
 * @description sql分页异常
 * @date 2019/4/7
 */
public class SQLPageException extends RuntimeException{

    public SQLPageException() {
    }

    public SQLPageException(String message) {
        super(message);
    }

    public SQLPageException(String message, Throwable cause) {
        super(message, cause);
    }

    public SQLPageException(Throwable cause) {
        super(cause);
    }

    public SQLPageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
