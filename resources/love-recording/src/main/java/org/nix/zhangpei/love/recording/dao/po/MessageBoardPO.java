package org.nix.zhangpei.love.recording.dao.po;

import org.nix.zhangpei.love.recording.dao.po.base.BasePO;

/**
 * 留言板
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/27
 */
public class MessageBoardPO extends BasePO {

    private String message;

    /**
     * 谁写的
     */
    private UserPO writer;
    /**
     * 给谁读
     */
    private UserPO reader;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserPO getWriter() {
        return writer;
    }

    public void setWriter(UserPO writer) {
        this.writer = writer;
    }

    public UserPO getReader() {
        return reader;
    }

    public void setReader(UserPO reader) {
        this.reader = reader;
    }

    @Override
    public String toString() {
        return "MessageBoardPO{" +
                "message='" + message + '\'' +
                ", writer=" + writer +
                ", reader=" + reader +
                ", id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
