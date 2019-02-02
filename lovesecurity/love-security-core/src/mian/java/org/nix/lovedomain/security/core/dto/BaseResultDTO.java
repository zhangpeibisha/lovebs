package org.nix.lovedomain.security.core.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author zhangpei
 * @version 1.0
 * @description 系统返回给用户的基本类信息
 * @date 2019/1/27
 */
@Data
public class BaseResultDTO {

    private Integer code;

    private String message;

    private HttpStatus httpStatus;

    public BaseResultDTO(String message, HttpStatus httpStatus) {
        this(httpStatus);
        this.message = message;
    }

    public BaseResultDTO(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.code = httpStatus.value();
    }
}
