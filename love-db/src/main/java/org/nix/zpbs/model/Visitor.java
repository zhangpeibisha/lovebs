package org.nix.zpbs.model;

import java.io.Serializable;

public class Visitor implements Serializable {
    /**
     * 访客记录ID
     *
     * @mbggenerated
     */
    private Integer vId;

    /**
     * 访客ID
     *
     * @mbggenerated
     */
    private Integer visitorId;

    /**
     * 来访时间
     *
     * @mbggenerated
     */
    private Integer visitorTime;

    /**
     * 被访用户ID
     *
     * @mbggenerated
     */
    private Integer userId;

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
    private Integer whereId;

    private static final long serialVersionUID = 1L;

    public Integer getvId() {
        return vId;
    }

    public void setvId(Integer vId) {
        this.vId = vId;
    }

    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    public Integer getVisitorTime() {
        return visitorTime;
    }

    public void setVisitorTime(Integer visitorTime) {
        this.visitorTime = visitorTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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

    public Integer getWhereId() {
        return whereId;
    }

    public void setWhereId(Integer whereId) {
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