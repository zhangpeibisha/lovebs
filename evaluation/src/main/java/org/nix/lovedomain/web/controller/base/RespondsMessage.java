package org.nix.lovedomain.web.controller.base;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangpei
 * @version 1.0
 * @description 响应客户端的信息
 * @date 2019/4/20
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RespondsMessage<D> {
    public static final Integer SUCCESS_CODE = 200;

    public static final Integer CLIENT_ERROR = 400;
    public static final Integer SERVER_ERROR = 500;

    private D data;

    /**
     * 基础展示视图
     */
    public interface BaseView {
    }

    @JsonView(value = BaseView.class)
    private Integer code;

    @JsonView(value = BaseView.class)
    private String msg;

    public RespondsMessage(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static RespondsMessage success(String msg) {
        return new RespondsMessage(SUCCESS_CODE, msg);
    }

    public static RespondsMessage failure(Integer code, String msg) {
        return new RespondsMessage(code, msg);
    }

    public static RespondsMessage clientError(String msg) {
        return failure(CLIENT_ERROR, msg);
    }

    public static RespondsMessage serverError(String msg) {
        return failure(SERVER_ERROR, msg);
    }
}
