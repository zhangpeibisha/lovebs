package org.nix.zpbs.model;

import java.io.Serializable;

public class AboutBlog implements Serializable {
    /**
     * 用户ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 博客关键字
     *
     * @mbggenerated
     */
    private String blogKeyword;

    /**
     * 博客描述
     *
     * @mbggenerated
     */
    private String blogDescription;

    /**
     * 博客名称
     *
     * @mbggenerated
     */
    private String blogName;

    /**
     * 博客标题
     *
     * @mbggenerated
     */
    private String blogTitle;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlogKeyword() {
        return blogKeyword;
    }

    public void setBlogKeyword(String blogKeyword) {
        this.blogKeyword = blogKeyword;
    }

    public String getBlogDescription() {
        return blogDescription;
    }

    public void setBlogDescription(String blogDescription) {
        this.blogDescription = blogDescription;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", blogKeyword=").append(blogKeyword);
        sb.append(", blogDescription=").append(blogDescription);
        sb.append(", blogName=").append(blogName);
        sb.append(", blogTitle=").append(blogTitle);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}