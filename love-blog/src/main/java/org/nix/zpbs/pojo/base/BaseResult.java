package org.nix.zpbs.pojo.base;

import lombok.Data;

/**
 * 最基础的返回结果类
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/8
 */
@Data
public class BaseResult {

    private Integer code;

    private String msg;

    public BaseResult() {
    }

    public BaseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 默认成功返回
     * @return 返回结果对象
     */
    public BaseResult success() {
        code = 200;
        msg = "处理成功";
        return this;
    }

    /**
     * 带成功信息参数的成功返回
     * @param msg 成功的信息
     * @return 返回结果对象
     */
    public BaseResult success(String msg) {
        code = 200;
        this.msg = msg;
        return this;
    }

    /**
     * 带成功信息参数的成功返回
     * @param code 处理成功的返回代码
     * @param msg 成功的信息
     * @return 返回结果对象
     */
    public BaseResult success(Integer code,String msg) {
        code = 200;
        this.msg = msg;
        return this;
    }

    /**
     * 处理失败
     * @param msg 失败信息
     * @return 返回结果对象
     */
    public BaseResult fail(String msg) {
        code = 400;
        this.msg = msg;
        return this;
    }

    /**
     * 处理失败
     * @param code 失败代码
     * @param msg 失败信息
     * @return 返回结果对象
     */
    public BaseResult fail(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }
}
