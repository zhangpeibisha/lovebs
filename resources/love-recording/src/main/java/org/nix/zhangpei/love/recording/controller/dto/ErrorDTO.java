package org.nix.zhangpei.love.recording.controller.dto;

import org.nix.zhangpei.love.recording.controller.dto.result.BaseResultDTO;

import java.util.HashMap;
import java.util.Map;

/**
 * 异常返回
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/1
 */
public class ErrorDTO extends BaseResultDTO {

    private Map<String,Object> errors;

    public ErrorDTO(String msg, Integer code) {
        super(msg, code);
        errors = new HashMap<>();
    }

    public ErrorDTO putError(String key,Object errorValue){
        errors.put(key,errorValue);
        return this;
    }

    public Map<String, Object> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, Object> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ErrorDTO{" +
                "errors=" + errors +
                ", msg='" + msg + '\'' +
                ", code=" + code +
                '}';
    }
}
