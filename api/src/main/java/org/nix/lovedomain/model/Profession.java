package org.nix.lovedomain.model;

import java.io.Serializable;

public class Profession implements Serializable {
    private Integer id;

    /**
     * 在学校的统一编码
     *
     * @mbggenerated
     */
    private String coding;

    /**
     * 专业名字
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 所属学院
     *
     * @mbggenerated
     */
    private Integer facultyid;

    /**
     * 专业领导老师Id
     *
     * @mbggenerated
     */
    private Integer departmentid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFacultyid() {
        return facultyid;
    }

    public void setFacultyid(Integer facultyid) {
        this.facultyid = facultyid;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", coding=").append(coding);
        sb.append(", name=").append(name);
        sb.append(", facultyid=").append(facultyid);
        sb.append(", departmentid=").append(departmentid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}