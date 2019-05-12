package org.nix.lovedomain.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

public class Evaluationquestionnaire implements Serializable {
    private Integer id;

    /**
     * 评教题目
     *
     * @mbggenerated
     */
    private String title;

    /**
     * 评教描述
     *
     * @mbggenerated
     */
    private String descritption;

    private Date createtime;

    private Date updatetime;

    /**
     * 作者id-也就是teacher表中的老师id(可能老师的账号、手机或者邮箱)
     *
     * @mbggenerated
     */
    private String authorid;

    /**
     * 评教内容信息，里面包含了评教内容的所有信息
     *
     * @mbggenerated
     */
    private String content;


    public JSONObject getContentJson() {
        if (content == null || "".equals(content)) {
            return new JSONObject();
        }
        return JSON.parseObject(content);
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescritption() {
        return descritption;
    }

    public void setDescritption(String descritption) {
        this.descritption = descritption;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getAuthorid() {
        return authorid;
    }

    public void setAuthorid(String authorid) {
        this.authorid = authorid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", descritption=").append(descritption);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", authorid=").append(authorid);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}