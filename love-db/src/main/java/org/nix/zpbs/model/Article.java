package org.nix.zpbs.model;

import java.io.Serializable;

public class Article implements Serializable {
    /**
     * 日志自增ID号
     *
     * @mbggenerated
     */
    private Short articleId;

    /**
     * 文章名称
     *
     * @mbggenerated
     */
    private String articleName;

    /**
     * 发布时间
     *
     * @mbggenerated
     */
    private Long articleTime;

    /**
     * 发布IP
     *
     * @mbggenerated
     */
    private String articleIp;

    /**
     * 查看人数
     *
     * @mbggenerated
     */
    private Integer articleClick;

    /**
     * 所属分类
     *
     * @mbggenerated
     */
    private Long sortArticleId;

    /**
     * 所属用户ID
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * 栏目ID
     *
     * @mbggenerated
     */
    private Byte typeId;

    /**
     * 文章的模式:0为私有，1为公开，2为仅好友查看
     *
     * @mbggenerated
     */
    private Integer articleType;

    /**
     * 是否置顶:0为否，1为是
     *
     * @mbggenerated
     */
    private Byte articleUp;

    /**
     * 是否博主推荐:0为否，1为是
     *
     * @mbggenerated
     */
    private Byte articleSupport;

    /**
     * 文章内容
     *
     * @mbggenerated
     */
    private String articleContent;

    private static final long serialVersionUID = 1L;

    public Short getArticleId() {
        return articleId;
    }

    public void setArticleId(Short articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public Long getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Long articleTime) {
        this.articleTime = articleTime;
    }

    public String getArticleIp() {
        return articleIp;
    }

    public void setArticleIp(String articleIp) {
        this.articleIp = articleIp;
    }

    public Integer getArticleClick() {
        return articleClick;
    }

    public void setArticleClick(Integer articleClick) {
        this.articleClick = articleClick;
    }

    public Long getSortArticleId() {
        return sortArticleId;
    }

    public void setSortArticleId(Long sortArticleId) {
        this.sortArticleId = sortArticleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getTypeId() {
        return typeId;
    }

    public void setTypeId(Byte typeId) {
        this.typeId = typeId;
    }

    public Integer getArticleType() {
        return articleType;
    }

    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }

    public Byte getArticleUp() {
        return articleUp;
    }

    public void setArticleUp(Byte articleUp) {
        this.articleUp = articleUp;
    }

    public Byte getArticleSupport() {
        return articleSupport;
    }

    public void setArticleSupport(Byte articleSupport) {
        this.articleSupport = articleSupport;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", articleId=").append(articleId);
        sb.append(", articleName=").append(articleName);
        sb.append(", articleTime=").append(articleTime);
        sb.append(", articleIp=").append(articleIp);
        sb.append(", articleClick=").append(articleClick);
        sb.append(", sortArticleId=").append(sortArticleId);
        sb.append(", userId=").append(userId);
        sb.append(", typeId=").append(typeId);
        sb.append(", articleType=").append(articleType);
        sb.append(", articleUp=").append(articleUp);
        sb.append(", articleSupport=").append(articleSupport);
        sb.append(", articleContent=").append(articleContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}