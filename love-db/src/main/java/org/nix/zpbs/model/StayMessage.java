package org.nix.zpbs.model;

import java.io.Serializable;

public class StayMessage implements Serializable {
    /**
     * 留言表自增ID
     *
     * @mbggenerated
     */
    private Short stayId;

    /**
     * 用户ID
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * 留言者ID
     *
     * @mbggenerated
     */
    private Integer stayUserId;

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
    private Integer messageStayTime;

    /**
     * 地区
     *
     * @mbggenerated
     */
    private String place;

    private static final long serialVersionUID = 1L;

    public Short getStayId() {
        return stayId;
    }

    public void setStayId(Short stayId) {
        this.stayId = stayId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStayUserId() {
        return stayUserId;
    }

    public void setStayUserId(Integer stayUserId) {
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

    public Integer getMessageStayTime() {
        return messageStayTime;
    }

    public void setMessageStayTime(Integer messageStayTime) {
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
        sb.append(", stayId=").append(stayId);
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