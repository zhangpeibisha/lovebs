package org.nix.lovedomain.service.vo.base;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangpei
 * @version 1.0
 * @description 基础展示层信息
 * @date 2019/4/7
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseVo {

    public static final Integer SUCCESS_CODE = 200;

    public static final Integer CLIENT_ERROR = 400;
    public static final Integer SERVER_ERROR = 500;

    /**
     * 基础展示视图
     */
    public interface BaseView {}

    @JsonView(value = BaseView.class)
    private Integer code;

    @JsonView(value = BaseView.class)
    private String msg;

    public static BaseVo success(String msg) {
        return new BaseVo(SUCCESS_CODE, msg);
    }

    public static BaseVo failure(Integer code, String msg) {
        return new BaseVo(code, msg);
    }

    public static BaseVo clientError(String msg) {
        return failure(CLIENT_ERROR, msg);
    }

    public static BaseVo serverError(String msg) {
        return failure(SERVER_ERROR, msg);
    }

}
