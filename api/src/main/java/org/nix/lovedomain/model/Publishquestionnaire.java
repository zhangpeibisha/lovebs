package org.nix.lovedomain.model;

import java.io.Serializable;
import java.util.Date;

public class Publishquestionnaire implements Serializable {
    private Integer id;

    /**
     * 是谁发布这个问卷的-在teachear表的老师，且拥有发布权限的老师
     *
     * @mbggenerated
     */
    private Integer releaseid;

    /**
     * 这个问卷是发布给哪个课程的
     *
     * @mbggenerated
     */
    private Integer courseid;

    /**
     * 这个是授课老师id
     *
     * @mbggenerated
     */
    private Integer teacherid;

    /**
     * 问卷id-对应问卷表中的信息
     *
     * @mbggenerated
     */
    private Integer questionnaireid;

    /**
     * 对这次发布的解释
     *
     * @mbggenerated
     */
    private String description;

    /**
     * 什么时候发布的
     *
     * @mbggenerated
     */
    private Date releasetime;

    /**
     * ‘学生什么时候开始回答这个问卷’
     *
     * @mbggenerated
     */
    private Date startrespondtime;

    /**
     * ‘学生什么时候禁止回答该问卷’
     *
     * @mbggenerated
     */
    private Date endrespondtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReleaseid() {
        return releaseid;
    }

    public void setReleaseid(Integer releaseid) {
        this.releaseid = releaseid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getQuestionnaireid() {
        return questionnaireid;
    }

    public void setQuestionnaireid(Integer questionnaireid) {
        this.questionnaireid = questionnaireid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public Date getStartrespondtime() {
        return startrespondtime;
    }

    public void setStartrespondtime(Date startrespondtime) {
        this.startrespondtime = startrespondtime;
    }

    public Date getEndrespondtime() {
        return endrespondtime;
    }

    public void setEndrespondtime(Date endrespondtime) {
        this.endrespondtime = endrespondtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", releaseid=").append(releaseid);
        sb.append(", courseid=").append(courseid);
        sb.append(", teacherid=").append(teacherid);
        sb.append(", questionnaireid=").append(questionnaireid);
        sb.append(", description=").append(description);
        sb.append(", releasetime=").append(releasetime);
        sb.append(", startrespondtime=").append(startrespondtime);
        sb.append(", endrespondtime=").append(endrespondtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}