package org.nix.zpbs.model;

import java.io.Serializable;

public class SecretMessage implements Serializable {
    /**
     * 自增私信ID
     *
     * @mbggenerated
     */
    private Integer secretId;

    /**
     * 发信者ID
     *
     * @mbggenerated
     */
    private Integer sendId;

    /**
     * 收信者ID
     *
     * @mbggenerated
     */
    private Integer receiveId;

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

    public Integer getSecretId() {
        return secretId;
    }

    public void setSecretId(Integer secretId) {
        this.secretId = secretId;
    }

    public Integer getSendId() {
        return sendId;
    }

    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }

    public Integer getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Integer receiveId) {
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
        sb.append(", secretId=").append(secretId);
        sb.append(", sendId=").append(sendId);
        sb.append(", receiveId=").append(receiveId);
        sb.append(", messageTopic=").append(messageTopic);
        sb.append(", messageContent=").append(messageContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}