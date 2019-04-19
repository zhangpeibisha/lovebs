package org.nix.lovedomain.model;

import java.io.Serializable;

public class Scoreblacklist implements Serializable {
    private Integer id;

    private Integer courseid;

    /**
     * 授课老师id
     *
     * @mbggenerated
     */
    private Integer teacherid;

    /**
     * 学生id集合，如果有学生id在这里面，则表示在给老师统计评教评分时不加入该学生的评教信息。学生id以逗号分隔
     *
     * @mbggenerated
     */
    private String studentids;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getStudentids() {
        return studentids;
    }

    public void setStudentids(String studentids) {
        this.studentids = studentids;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", courseid=").append(courseid);
        sb.append(", teacherid=").append(teacherid);
        sb.append(", studentids=").append(studentids);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}