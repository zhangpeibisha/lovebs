package org.nix.zhangpei.love.recording.service.vo;

import org.nix.zhangpei.love.recording.dao.po.MessageBoardPO;
import org.nix.zhangpei.love.recording.dao.po.UserPO;
import org.nix.zhangpei.love.recording.dao.po.base.BasePO;
import org.nix.zhangpei.love.recording.service.vo.base.BaseVo;

/**
 * 留言板
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/27
 */
public class MessageBoardVO extends BaseVo {

    private String message;

    /**
     * 谁写的
     */
    private UserVO writer;
    /**
     * 给谁读
     */
    private UserVO reader;

    public MessageBoardVO(MessageBoardPO messageBoard) {
        message = messageBoard.getMessage();
        writer = new UserVO(messageBoard.getWriter());
        reader = new UserVO(messageBoard.getReader());
        setBaseVO(messageBoard.getBasePO());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserVO getWriter() {
        return writer;
    }

    public void setWriter(UserVO writer) {
        this.writer = writer;
    }

    public UserVO getReader() {
        return reader;
    }

    public void setReader(UserVO reader) {
        this.reader = reader;
    }

    @Override
    public String toString() {
        return "MessageBoardVO{" +
                "message='" + message + '\'' +
                ", writer=" + writer +
                ", reader=" + reader +
                ", id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
