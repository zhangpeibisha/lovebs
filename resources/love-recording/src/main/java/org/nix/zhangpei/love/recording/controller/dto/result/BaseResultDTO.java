package org.nix.zhangpei.love.recording.controller.dto.result;

/**
 * 最基本的返回信息
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/28
 */
public class BaseResultDTO {

    protected String msg;

    protected Integer code;

    public BaseResultDTO(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BaseResultDTO{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                '}';
    }
}
