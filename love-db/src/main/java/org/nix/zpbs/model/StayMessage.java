package org.nix.zpbs.model;

import java.io.Serializable;

public class StayMessage implements Serializable {
    /**
     * 留言表自增ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 用户ID
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * 留言者ID
     *
     * @mbggenerated
     */
    private Long stayUserId;

    /**
     * 留言内容
     *
     * @mbggenerated
     */
    private String messageContent;

    /**
     * 留言用户的IP地址
     *
     * @mbggenerated
     */
    private String stayUserIp;

    /**
     * 留言时间
     *
     * @mbggenerated
     */
    private Long messageStayTime;

    /**
     * 地区
     *
     * @mbggenerated
     */
    private String place;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getStayUserId() {
        return stayUserId;
    }

    public void setStayUserId(Long stayUserId) {
        this.stayUserId = stayUserId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getStayUserIp() {
        return stayUserIp;
    }

    public void setStayUserIp(String stayUserIp) {
        this.stayUserIp = stayUserIp;
    }

    public Long getMessageStayTime() {
        return messageStayTime;
    }

    public void setMessageStayTime(Long messageStayTime) {
        this.messageStayTime = messageStayTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", stayUserId=").append(stayUserId);
        sb.append(", messageContent=").append(messageContent);
        sb.append(", stayUserIp=").append(stayUserIp);
        sb.append(", messageStayTime=").append(messageStayTime);
        sb.append(", place=").append(place);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}