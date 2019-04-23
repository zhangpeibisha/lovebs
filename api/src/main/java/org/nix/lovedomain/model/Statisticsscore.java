package org.nix.lovedomain.model;

import java.io.Serializable;

public class Statisticsscore implements Serializable {
    private Integer id;

    /**
     * 学生id
     *
     * @mbggenerated
     */
    private Integer teacherid;

    /**
     * 课程id
     *
     * @mbggenerated
     */
    private Integer courseid;

    /**
     * 问卷发布id
     *
     * @mbggenerated
     */
    private Integer publishquestionnaireid;

    /**
     * 授课老师得到的评分总和
     *
     * @mbggenerated
     */
    private Integer fraction;

    /**
     * 统计的一些附加信息
     *
     * @mbggenerated
     */
    private String attachjson;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getPublishquestionnaireid() {
        return publishquestionnaireid;
    }

    public void setPublishquestionnaireid(Integer publishquestionnaireid) {
        this.publishquestionnaireid = publishquestionnaireid;
    }

    public Integer getFraction() {
        return fraction;
    }

    public void setFraction(Integer fraction) {
        this.fraction = fraction;
    }

    public String getAttachjson() {
        return attachjson;
    }

    public void setAttachjson(String attachjson) {
        this.attachjson = attachjson;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", teacherid=").append(teacherid);
        sb.append(", courseid=").append(courseid);
        sb.append(", publishquestionnaireid=").append(publishquestionnaireid);
        sb.append(", fraction=").append(fraction);
        sb.append(", attachjson=").append(attachjson);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}