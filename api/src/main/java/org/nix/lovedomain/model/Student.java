package org.nix.lovedomain.model;

import javax.persistence.Id;
import java.io.Serializable;

public class Student implements Serializable {

    @Id
    private Integer id;

    /**
     * 学生在学校的唯一id
     *
     * @mbggenerated
     */
    private String studentid;

    /**
     * 学生名字
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 手机号码
     *
     * @mbggenerated
     */
    private String phone;

    /**
     * 邮箱地址
     *
     * @mbggenerated
     */
    private String email;

    /**
     * 用户头像
     *
     * @mbggenerated
     */
    private String imageurl;

    /**
     * 用户所在班级
     *
     * @mbggenerated
     */
    private Integer classid;

    /**
     * 账户id
     *
     * @mbggenerated
     */
    private Integer accountid;

    /**
     * 学生的任务信息，为一个json字符串
     *
     * @mbggenerated
     */
    private String task;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", studentid=").append(studentid);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", imageurl=").append(imageurl);
        sb.append(", classid=").append(classid);
        sb.append(", accountid=").append(accountid);
        sb.append(", task=").append(task);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}