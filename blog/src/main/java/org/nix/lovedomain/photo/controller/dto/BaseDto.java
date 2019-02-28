package org.nix.lovedomain.photo.controller.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @description 基础返回信息
 * @date 2019/2/28
 */
@Data
public class BaseDto {

    public interface BaseResult {
    }

    @JsonView(value = BaseResult.class)
    Integer code;

    @JsonView(value = BaseResult.class)
    String msg;

    public BaseDto(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
