package org.nix.zpbs.model;

import java.io.Serializable;

public class PhoneMessage implements Serializable {
    /**
     * 自增ID号
     *
     * @mbggenerated
     */
    private Long phoneId;

    /**
     * 用户手机号码
     *
     * @mbggenerated
     */
    private String phoneNum;

    /**
     * 发送内容
     *
     * @mbggenerated
     */
    private String contents;

    /**
     * 发送时间
     *
     * @mbggenerated
     */
    private Long sendTime;

    /**
     * 用户ID
     *
     * @mbggenerated
     */
    private Long userId;

    private static final long serialVersionUID = 1L;

    public Long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Long getSendTime() {
        return sendTime;
    }

    public void setSendTime(Long sendTime) {
        this.sendTime = sendTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", phoneId=").append(phoneId);
        sb.append(", phoneNum=").append(phoneNum);
        sb.append(", contents=").append(contents);
        sb.append(", sendTime=").append(sendTime);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}