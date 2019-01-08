package org.nix.zpbs.model;

import java.io.Serializable;

public class ArticleSort implements Serializable {
    /**
     * 文章自增ID
     *
     * @mbggenerated
     */
    private Integer sortArticleId;

    /**
     * 该分类所属用户
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * 分类名称
     *
     * @mbggenerated
     */
    private String sortArticleName;

    private static final long serialVersionUID = 1L;

    public Integer getSortArticleId() {
        return sortArticleId;
    }

    public void setSortArticleId(Integer sortArticleId) {
        this.sortArticleId = sortArticleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSortArticleName() {
        return sortArticleName;
    }

    public void setSortArticleName(String sortArticleName) {
        this.sortArticleName = sortArticleName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sortArticleId=").append(sortArticleId);
        sb.append(", userId=").append(userId);
        sb.append(", sortArticleName=").append(sortArticleName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}