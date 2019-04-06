package org.nix.lovedomain.model;

import java.io.Serializable;

public class Class implements Serializable {
    private Integer id;

    /**
     * 课程在学校的统一编码
     *
     * @mbggenerated
     */
    private Integer classid;

    /**
     * 辅导老师id
     *
     * @mbggenerated
     */
    private Integer teacherid;

    /**
     * 专业id
     *
     * @mbggenerated
     */
    private Integer professionid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getProfessionid() {
        return professionid;
    }

    public void setProfessionid(Integer professionid) {
        this.professionid = professionid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", classid=").append(classid);
        sb.append(", teacherid=").append(teacherid);
        sb.append(", professionid=").append(professionid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}