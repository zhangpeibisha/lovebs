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

    /**
     * 班级编号
     */
    private String classCoding;

    /**
     * 课程编号
     */
    private String courseCoding;

    /**
     * 专业编号
     */
    private String professionCoding;

    /**
     * 学院编号
     */
    private String facultyCoding;

    /**
     * 平均分
     */
    private double avg;




    private static final long serialVersionUID = 1L;

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getClassCoding() {
        return classCoding;
    }

    public void setClassCoding(String classCoding) {
        this.classCoding = classCoding;
    }

    public String getCourseCoding() {
        return courseCoding;
    }

    public void setCourseCoding(String courseCoding) {
        this.courseCoding = courseCoding;
    }

    public String getProfessionCoding() {
        return professionCoding;
    }

    public void setProfessionCoding(String professionCoding) {
        this.professionCoding = professionCoding;
    }

    public String getFacultyCoding() {
        return facultyCoding;
    }

    public void setFacultyCoding(String facultyCoding) {
        this.facultyCoding = facultyCoding;
    }

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
        sb.append(", classCoding=").append(classCoding);
        sb.append(", courseCoding=").append(courseCoding);
        sb.append(", professionCoding=").append(professionCoding);
        sb.append(", facultyCoding=").append(facultyCoding);
        sb.append(", avg=").append(avg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}