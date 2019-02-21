package org.nix.lovedomain.rbac.util.auth.utils.scan;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/2/14
 */
public class ScannerClassException extends RuntimeException {

    public ScannerClassException(String message, ClassNotFoundException e) {
        super(message,e);
    }

    public ScannerClassException(String message, Exception e) {
        super(message,e);
    }
}
