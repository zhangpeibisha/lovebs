package org.nix.lovedomain.model;

import java.io.Serializable;

public class Teacher implements Serializable {
    private Integer id;

    /**
     * 老师工号
     *
     * @mbggenerated
     */
    private String jobnumber;

    /**
     * 老师名字
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 账号id
     *
     * @mbggenerated
     */
    private Integer accountid;

    /**
     * 老师头像
     *
     * @mbggenerated
     */
    private String imagerurl;

    /**
     * 老师工作需要使用的json字段，该字段可方便后续动态配置老师的工作需要的配置字段
     *
     * @mbggenerated
     */
    private String workjson;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobnumber() {
        return jobnumber;
    }

    public void setJobnumber(String jobnumber) {
        this.jobnumber = jobnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public String getImagerurl() {
        return imagerurl;
    }

    public void setImagerurl(String imagerurl) {
        this.imagerurl = imagerurl;
    }

    public String getWorkjson() {
        return workjson;
    }

    public void setWorkjson(String workjson) {
        this.workjson = workjson;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", jobnumber=").append(jobnumber);
        sb.append(", name=").append(name);
        sb.append(", accountid=").append(accountid);
        sb.append(", imagerurl=").append(imagerurl);
        sb.append(", workjson=").append(workjson);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}