package org.nix.zpbs.model;

import java.io.Serializable;

public class Ad implements Serializable {
    /**
     * 自增ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 0,站外广告;从1开始代表的是该广告所处的广告位,同表AD_POSTITION中的字段POSITION_ID的值
     *
     * @mbggenerated
     */
    private Long positionId;

    /**
     * 广告类型,0图片;1FLASH;2代码3文字
     *
     * @mbggenerated
     */
    private Integer mediaType;

    /**
     * 该条广告记录的广告名称
     *
     * @mbggenerated
     */
    private String adName;

    /**
     * 广告链接地址
     *
     * @mbggenerated
     */
    private String adLink;

    /**
     * 广告开始时间
     *
     * @mbggenerated
     */
    private Long startTime;

    /**
     * 广告结束时间
     *
     * @mbggenerated
     */
    private Long endTime;

    /**
     * 广告联系人
     *
     * @mbggenerated
     */
    private String linkMan;

    /**
     * 广告联系人的邮箱
     *
     * @mbggenerated
     */
    private String linkEmail;

    /**
     * 广告联系人得电话
     *
     * @mbggenerated
     */
    private String linkPhone;

    /**
     * 广告点击次数
     *
     * @mbggenerated
     */
    private Long clickCount;

    /**
     * 该广告是否关闭;1开启; 0关闭; 关闭后广告将不再有效
     *
     * @mbggenerated
     */
    private Integer enabled;

    /**
     * 广告链接的表现,文字广告就是文字或图片和FLASH就是它们的地址
     *
     * @mbggenerated
     */
    private String adCode;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Integer getMediaType() {
        return mediaType;
    }

    public void setMediaType(Integer mediaType) {
        this.mediaType = mediaType;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAdLink() {
        return adLink;
    }

    public void setAdLink(String adLink) {
        this.adLink = adLink;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getLinkEmail() {
        return linkEmail;
    }

    public void setLinkEmail(String linkEmail) {
        this.linkEmail = linkEmail;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public Long getClickCount() {
        return clickCount;
    }

    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", positionId=").append(positionId);
        sb.append(", mediaType=").append(mediaType);
        sb.append(", adName=").append(adName);
        sb.append(", adLink=").append(adLink);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", linkMan=").append(linkMan);
        sb.append(", linkEmail=").append(linkEmail);
        sb.append(", linkPhone=").append(linkPhone);
        sb.append(", clickCount=").append(clickCount);
        sb.append(", enabled=").append(enabled);
        sb.append(", adCode=").append(adCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}