package org.nix.zhangpei.love.recording.controller.dto.message;


import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

/**
 * 前端传过来写留言的封装尸实体
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/31
 */
public class MessageBoardDTO {

    @NotNull(message = "留言信息不能为空")
    @NotEmpty(message = "留言信息不能为空")
    private String message;
    @NotNull(message = "作者用户id不能为空")
    @Range(message = "作者用户id不能为空且不能小于1",min = 1)
    private Long writerId;
    @NotNull(message = "目标用户id不能为空")
    @Range(message = "目标用户id不能为空且不能小于1",min = 1)
    private Long readerId;

    /**
     * 接入前端信息必须设置空的构造函数
     * 框架通过反射生成对象时需要调用
     */
    public MessageBoardDTO() {
    }

    public MessageBoardDTO(String message, Long writerId, Long readerId) {
        this.message = message;
        this.writerId = writerId;
        this.readerId = readerId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getWriterId() {
        return writerId;
    }

    public void setWriterId(Long writerId) {
        this.writerId = writerId;
    }

    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }

    @Override
    public String toString() {
        return "MessageBoardDTO{" +
                "message='" + message + '\'' +
                ", writerId=" + writerId +
                ", readerId=" + readerId +
                '}';
    }
}
