package org.nix.lovedomain.model;

import java.io.Serializable;

public class Questionnaireanswer implements Serializable {
    private Integer id;

    /**
     * 学生id
     *
     * @mbggenerated
     */
    private Integer studentid;

    /**
     * 学生在第几学期回答的问卷
     *
     * @mbggenerated
     */
    private Integer semester;

    /**
     * 问卷调查结果，该结果以json格式存储
     *
     * @mbggenerated
     */
    private String questionnaireresults;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getQuestionnaireresults() {
        return questionnaireresults;
    }

    public void setQuestionnaireresults(String questionnaireresults) {
        this.questionnaireresults = questionnaireresults;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", studentid=").append(studentid);
        sb.append(", semester=").append(semester);
        sb.append(", questionnaireresults=").append(questionnaireresults);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}