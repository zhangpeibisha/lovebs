package org.nix.zhangpei.love.recording.controller.controller.exception.handler;

import cn.hutool.json.JSONUtil;
import org.nix.zhangpei.love.recording.controller.dto.ErrorDTO;
import org.nix.zhangpei.love.recording.controller.dto.result.BaseResultDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.exceptions.TemplateInputException;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/1
 */
@ControllerAdvice
@RestController
public class ExceptionControllerAdvice {
    /**
     * 参数校验失败
     *
     * @param e 异常信息
     * @return 异常详细信息
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public BaseResultDTO bindExceptionHandler(BindException e) {
        ErrorDTO resultError = new ErrorDTO("参数校验失败", HttpStatus.BAD_REQUEST.value());
        List<FieldError> fieldErrors = e.getFieldErrors();
        for (FieldError error : fieldErrors) {
            System.out.println(JSONUtil.toJsonStr(error));
            resultError.putError(error.getField(),error.getDefaultMessage());
        }
        return resultError;
    }
}
