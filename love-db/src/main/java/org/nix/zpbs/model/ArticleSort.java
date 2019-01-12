package org.nix.zpbs.model;

import java.io.Serializable;

public class ArticleSort implements Serializable {
    /**
     * 文章自增ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 该分类所属用户
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * 分类名称
     *
     * @mbggenerated
     */
    private String sortArticleName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", sortArticleName=").append(sortArticleName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}