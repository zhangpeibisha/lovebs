package org.nix.lovedomain.photo.model;

import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;
import java.util.Date;

public class Album implements Serializable {

    public interface DetailAlbumView {
    }

    @JsonView(value = DetailAlbumView.class)
    private Integer id;

    @JsonView(value = DetailAlbumView.class)
    private String name;

    @JsonView(value = DetailAlbumView.class)
    private String description;

    /**
     * 封面url
     *
     * @mbggenerated
     */
    @JsonView(value = DetailAlbumView.class)
    private String coverurl;

    /**
     * 用户id
     *
     * @mbggenerated
     */
    @JsonView(value = DetailAlbumView.class)
    private Integer ownerid;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @JsonView(value = DetailAlbumView.class)
    private Date createtime;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @JsonView(value = DetailAlbumView.class)
    private Date updatetime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverurl() {
        return coverurl;
    }

    public void setCoverurl(String coverurl) {
        this.coverurl = coverurl;
    }

    public Integer getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Integer ownerid) {
        this.ownerid = ownerid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", coverurl=").append(coverurl);
        sb.append(", ownerid=").append(ownerid);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

}