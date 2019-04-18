package org.nix.lovedomain.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author zhangpei
 * @version 1.0
 * @description 返回信息个客户端
 * @date 2019/4/19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto<D> {

    private String msg;

    private Integer code;

    private D data;

    public void setStatus(HttpStatus httpStatus) {
        code = httpStatus.value();
    }

    public static ResultDto success(String msg) {
        return ResultDto.builder().msg(msg).build();
    }

    public static ResultDto faile(String msg) {
        return ResultDto.builder().msg(msg).code(400).build();
    }
}
