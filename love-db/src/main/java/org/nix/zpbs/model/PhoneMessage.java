package org.nix.zpbs.model;

import java.io.Serializable;

public class PhoneMessage implements Serializable {
    /**
     * 自增ID号
     *
     * @mbggenerated
     */
    private Integer phoneId;

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
    private Integer sendTime;

    /**
     * 用户ID
     *
     * @mbggenerated
     */
    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
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

    public Integer getSendTime() {
        return sendTime;
    }

    public void setSendTime(Integer sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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