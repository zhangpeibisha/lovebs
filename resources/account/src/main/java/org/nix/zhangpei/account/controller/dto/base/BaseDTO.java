package org.nix.zhangpei.account.controller.dto.base;

import java.util.Objects;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/23
 */
public class BaseDTO {

    /**
     * 是否成功
     */
    protected Boolean success;
    /**
     * 服务返回消息
     */
    protected String msg;
    /**
     * 服务处理后的返回状态码
     */
    protected Integer code;

    public BaseDTO(Boolean success, String msg, Integer code) {
        this.success = success;
        this.msg = msg;
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseDTO baseDTO = (BaseDTO) o;
        return Objects.equals(success, baseDTO.success) &&
                Objects.equals(msg, baseDTO.msg) &&
                Objects.equals(code, baseDTO.code);
    }

    @Override
    public int hashCode() {

        return Objects.hash(success, msg, code);
    }

    @Override
    public String toString() {
        return "BaseDTO{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", code=" + code +
                '}';
    }
}
