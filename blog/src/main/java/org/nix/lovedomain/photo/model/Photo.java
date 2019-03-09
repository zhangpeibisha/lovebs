package org.nix.lovedomain.photo.model;

import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;
import java.util.Date;

public class Photo implements Serializable {

    @JsonView(value = SimplePhotoView.class)
    private Integer id;

    @JsonView(value = SimplePhotoView.class)
    private String name;

    @JsonView(value = DetailPhotoView.class)
    private String description;

    @JsonView(value = SimplePhotoView.class)
    private String url;

    @JsonView(value = SimplePhotoView.class)
    private Integer albumid;

    @JsonView(value = DetailPhotoView.class)
    private Date createtime;

    @JsonView(value = DetailPhotoView.class)
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Integer albumid) {
        this.albumid = albumid;
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
        sb.append(", url=").append(url);
        sb.append(", albumid=").append(albumid);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public interface DetailPhotoView extends SimplePhotoView{
    }

    public interface SimplePhotoView {
    }
}