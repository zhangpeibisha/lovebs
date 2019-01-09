package org.nix.zpbs.model;

import java.io.Serializable;

public class Shuoshuo implements Serializable {
    /**
     * 说说记录ID
     *
     * @mbggenerated
     */
    private Long shuoId;

    /**
     * 用户ID
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * 发布时间
     *
     * @mbggenerated
     */
    private Long shuoTime;

    /**
     * 说说发布时的IP地址
     *
     * @mbggenerated
     */
    private String shuoIp;

    /**
     * 说说内容
     *
     * @mbggenerated
     */
    private String shuoshuo;

    /**
     * 栏目ID,默认为3
     *
     * @mbggenerated
     */
    private Byte typeId;

    private static final long serialVersionUID = 1L;

    public Long getShuoId() {
        return shuoId;
    }

    public void setShuoId(Long shuoId) {
        this.shuoId = shuoId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShuoTime() {
        return shuoTime;
    }

    public void setShuoTime(Long shuoTime) {
        this.shuoTime = shuoTime;
    }

    public String getShuoIp() {
        return shuoIp;
    }

    public void setShuoIp(String shuoIp) {
        this.shuoIp = shuoIp;
    }

    public String getShuoshuo() {
        return shuoshuo;
    }

    public void setShuoshuo(String shuoshuo) {
        this.shuoshuo = shuoshuo;
    }

    public Byte getTypeId() {
        return typeId;
    }

    public void setTypeId(Byte typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", shuoId=").append(shuoId);
        sb.append(", userId=").append(userId);
        sb.append(", shuoTime=").append(shuoTime);
        sb.append(", shuoIp=").append(shuoIp);
        sb.append(", shuoshuo=").append(shuoshuo);
        sb.append(", typeId=").append(typeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}