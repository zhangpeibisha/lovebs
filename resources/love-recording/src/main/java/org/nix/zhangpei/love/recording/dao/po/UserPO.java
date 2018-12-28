package org.nix.zhangpei.love.recording.dao.po;

import org.nix.zhangpei.love.recording.dao.po.base.BasePO;

import javax.persistence.Table;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/27
 */
@Table(name = "user")
public class UserPO extends BasePO {

    private String username;

    private String password;

    private String phone;

    /**自己写的留言*/
    private List<MessageBoardPO> writerMessage;
    /**别人写的留言*/
    private List<MessageBoardPO> readMessage;
    /**自己写的时间轴*/
    private List<TimePumpingNodePO> timePumpingNodes;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<MessageBoardPO> getWriterMessage() {
        return writerMessage;
    }

    public void setWriterMessage(List<MessageBoardPO> writerMessage) {
        this.writerMessage = writerMessage;
    }

    public List<MessageBoardPO> getReadMessage() {
        return readMessage;
    }

    public void setReadMessage(List<MessageBoardPO> readMessage) {
        this.readMessage = readMessage;
    }

    public List<TimePumpingNodePO> getTimePumpingNodes() {
        return timePumpingNodes;
    }

    public void setTimePumpingNodes(List<TimePumpingNodePO> timePumpingNodes) {
        this.timePumpingNodes = timePumpingNodes;
    }

    @Override
    public String toString() {
        return "UserPO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", writerMessage=" + writerMessage +
                ", readMessage=" + readMessage +
                ", timePumpingNodes=" + timePumpingNodes +
                ", id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
