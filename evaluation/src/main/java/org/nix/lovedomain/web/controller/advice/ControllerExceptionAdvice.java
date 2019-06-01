package org.nix.lovedomain.web.controller.advice;

import cn.hutool.core.exceptions.ValidateException;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangpei
 * @version 1.0
 * @description 统一处理
 * @date 2019/6/1
 */
@Slf4j
@RestController
@ControllerAdvice
public class ControllerExceptionAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidateException.class)
    public String handleValidateException(ValidateException e) {
        String message = e.getMessage();
        log.info("用户使用错误", message);
        e.printStackTrace();
        return message;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        String message = e.getMessage();
        log.warn("系统未知错误", message);
        e.printStackTrace();
        return message;
    }

}
