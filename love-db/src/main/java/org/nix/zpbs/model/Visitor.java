package org.nix.zpbs.model;

import java.io.Serializable;

public class Visitor implements Serializable {
    /**
     * 访客记录ID
     *
     * @mbggenerated
     */
    private Long vId;

    /**
     * 访客ID
     *
     * @mbggenerated
     */
    private Long visitorId;

    /**
     * 来访时间
     *
     * @mbggenerated
     */
    private Long visitorTime;

    /**
     * 被访用户ID
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * 访客IP地址
     *
     * @mbggenerated
     */
    private String visitorIp;

    /**
     * 访问板块ID
     *
     * @mbggenerated
     */
    private Integer typeId;

    /**
     * 查看某板块的某个子项目，如查看相册板块的第3个相册，该ID对应该相册的ID号
     *
     * @mbggenerated
     */
    private Long whereId;

    private static final long serialVersionUID = 1L;

    public Long getvId() {
        return vId;
    }

    public void setvId(Long vId) {
        this.vId = vId;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public Long getVisitorTime() {
        return visitorTime;
    }

    public void setVisitorTime(Long visitorTime) {
        this.visitorTime = visitorTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getVisitorIp() {
        return visitorIp;
    }

    public void setVisitorIp(String visitorIp) {
        this.visitorIp = visitorIp;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Long getWhereId() {
        return whereId;
    }

    public void setWhereId(Long whereId) {
        this.whereId = whereId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", vId=").append(vId);
        sb.append(", visitorId=").append(visitorId);
        sb.append(", visitorTime=").append(visitorTime);
        sb.append(", userId=").append(userId);
        sb.append(", visitorIp=").append(visitorIp);
        sb.append(", typeId=").append(typeId);
        sb.append(", whereId=").append(whereId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}