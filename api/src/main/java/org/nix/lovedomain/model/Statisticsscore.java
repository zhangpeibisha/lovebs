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

    /**
     * 专业信息
     */
    private Profession profession;


    /**
     * 学院信息
     */
    private Faculty faculty;

    private static final long serialVersionUID = 1L;

    public Statisticsscore() {
        faculty = new Faculty();
        profession = new Profession();
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

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Statisticsscore{" +
                "id=" + id +
                ", teacherid=" + teacherid +
                ", courseid=" + courseid +
                ", publishquestionnaireid=" + publishquestionnaireid +
                ", fraction=" + fraction +
                ", attachjson='" + attachjson + '\'' +
                ", classCoding='" + classCoding + '\'' +
                ", courseCoding='" + courseCoding + '\'' +
                ", professionCoding='" + professionCoding + '\'' +
                ", facultyCoding='" + facultyCoding + '\'' +
                ", avg=" + avg +
                ", profession=" + profession +
                ", faculty=" + faculty +
                '}';
    }
}