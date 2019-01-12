package org.nix.zpbs.model;

import java.io.Serializable;

public class Photos implements Serializable {
    /**
     * 相片ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 相片名称
     *
     * @mbggenerated
     */
    private String photoName;

    /**
     * 图片路径
     *
     * @mbggenerated
     */
    private String photoSrc;

    /**
     * 图片描述
     *
     * @mbggenerated
     */
    private String photoDescription;

    /**
     * 所属用户ID
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * 所属相册ID
     *
     * @mbggenerated
     */
    private Long sortId;

    /**
     * 图片上传时间
     *
     * @mbggenerated
     */
    private Long uploadTime;

    /**
     * 图片操作上传IP地址
     *
     * @mbggenerated
     */
    private String uploadIp;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoSrc() {
        return photoSrc;
    }

    public void setPhotoSrc(String photoSrc) {
        this.photoSrc = photoSrc;
    }

    public String getPhotoDescription() {
        return photoDescription;
    }

    public void setPhotoDescription(String photoDescription) {
        this.photoDescription = photoDescription;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSortId() {
        return sortId;
    }

    public void setSortId(Long sortId) {
        this.sortId = sortId;
    }

    public Long getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Long uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUploadIp() {
        return uploadIp;
    }

    public void setUploadIp(String uploadIp) {
        this.uploadIp = uploadIp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", photoName=").append(photoName);
        sb.append(", photoSrc=").append(photoSrc);
        sb.append(", photoDescription=").append(photoDescription);
        sb.append(", userId=").append(userId);
        sb.append(", sortId=").append(sortId);
        sb.append(", uploadTime=").append(uploadTime);
        sb.append(", uploadIp=").append(uploadIp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}