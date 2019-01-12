package org.nix.zpbs.model;

import java.io.Serializable;

public class SecretMessage implements Serializable {
    /**
     * 自增私信ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 发信者ID
     *
     * @mbggenerated
     */
    private Long sendId;

    /**
     * 收信者ID
     *
     * @mbggenerated
     */
    private Long receiveId;

    /**
     * 私信标题
     *
     * @mbggenerated
     */
    private String messageTopic;

    /**
     * 私信内容
     *
     * @mbggenerated
     */
    private String messageContent;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSendId() {
        return sendId;
    }

    public void setSendId(Long sendId) {
        this.sendId = sendId;
    }

    public Long getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Long receiveId) {
        this.receiveId = receiveId;
    }

    public String getMessageTopic() {
        return messageTopic;
    }

    public void setMessageTopic(String messageTopic) {
        this.messageTopic = messageTopic;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sendId=").append(sendId);
        sb.append(", receiveId=").append(receiveId);
        sb.append(", messageTopic=").append(messageTopic);
        sb.append(", messageContent=").append(messageContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}