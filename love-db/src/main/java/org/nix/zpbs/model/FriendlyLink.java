package org.nix.zpbs.model;

import java.io.Serializable;

public class FriendlyLink implements Serializable {
    /**
     * 友情链接自增ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 友情链接名称
     *
     * @mbggenerated
     */
    private String linkName;

    /**
     * 链接地址
     *
     * @mbggenerated
     */
    private String linkUrl;

    /**
     * LOGO图片
     *
     * @mbggenerated
     */
    private String linkLogo;

    /**
     * 在页面显示的顺序
     *
     * @mbggenerated
     */
    private Integer showOrder;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getLinkLogo() {
        return linkLogo;
    }

    public void setLinkLogo(String linkLogo) {
        this.linkLogo = linkLogo;
    }

    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", linkName=").append(linkName);
        sb.append(", linkUrl=").append(linkUrl);
        sb.append(", linkLogo=").append(linkLogo);
        sb.append(", showOrder=").append(showOrder);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}