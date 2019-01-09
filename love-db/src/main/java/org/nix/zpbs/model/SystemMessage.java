package org.nix.zpbs.model;

import java.io.Serializable;

public class SystemMessage implements Serializable {
    /**
     * 系统通知ID
     *
     * @mbggenerated
     */
    private Long systemId;

    /**
     * 接受者ID
     *
     * @mbggenerated
     */
    private Long sendId;

    /**
     * 用户组ID
     *
     * @mbggenerated
     */
    private Byte groupId;

    /**
     * 1时发送所有用户，0时则不采用
     *
     * @mbggenerated
     */
    private Long sendDefault;

    /**
     * 通知内容
     *
     * @mbggenerated
     */
    private String systemTopic;

    /**
     * 通知内容
     *
     * @mbggenerated
     */
    private String systemContent;

    private static final long serialVersionUID = 1L;

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public Long getSendId() {
        return sendId;
    }

    public void setSendId(Long sendId) {
        this.sendId = sendId;
    }

    public Byte getGroupId() {
        return groupId;
    }

    public void setGroupId(Byte groupId) {
        this.groupId = groupId;
    }

    public Long getSendDefault() {
        return sendDefault;
    }

    public void setSendDefault(Long sendDefault) {
        this.sendDefault = sendDefault;
    }

    public String getSystemTopic() {
        return systemTopic;
    }

    public void setSystemTopic(String systemTopic) {
        this.systemTopic = systemTopic;
    }

    public String getSystemContent() {
        return systemContent;
    }

    public void setSystemContent(String systemContent) {
        this.systemContent = systemContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", systemId=").append(systemId);
        sb.append(", sendId=").append(sendId);
        sb.append(", groupId=").append(groupId);
        sb.append(", sendDefault=").append(sendDefault);
        sb.append(", systemTopic=").append(systemTopic);
        sb.append(", systemContent=").append(systemContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}