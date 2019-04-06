package org.nix.lovedomain.model;

import java.io.Serializable;

public class Faculty implements Serializable {
    private Integer id;

    /**
     * 学院在学校的统一编码
     *
     * @mbggenerated
     */
    private String coding;

    /**
     * 学院名字
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 学院领导
     *
     * @mbggenerated
     */
    private Integer dean;

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

    public Integer getDean() {
        return dean;
    }

    public void setDean(Integer dean) {
        this.dean = dean;
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
        sb.append(", dean=").append(dean);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}