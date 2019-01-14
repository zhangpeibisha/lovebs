package org.nix.zpbs.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.nix.zpbs.pojo.base.BaseResult;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/13
 */
@Slf4j
@ControllerAdvice
public class ErrorController {


    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exception(final Throwable throwable, final Model model) {
        log.error("Exception during execution of SpringSecurity application", throwable);
        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }

    /**
     * @param exception 校验失败
     * @return MVC控制器校验失败的返回信息
     * @author zhangpe0312@qq.com
     * @description
     * @date 23:06 2019/1/13
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public BaseResult handleException(BindException exception) {
        StringBuilder msg = new StringBuilder();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        log.info("用户请求参数错误");
        for (FieldError error : fieldErrors) {
            log.info("name:{} - message:{}",error.getField() , error.getDefaultMessage());
            msg.append(error.getDefaultMessage()).append(",");
        }
        return new BaseResult().fail(400, msg.toString());
    }

}
