package org.nix.lovedomain.photo.controller;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/3/9
 */
public class ControllerException extends RuntimeException {
    public ControllerException() {
    }

    public ControllerException(String message) {
        super(message);
    }
}
