package org.nix.zpbs.model;

import java.io.Serializable;

public class UserComment implements Serializable {
    /**
     * 评论自增ID号
     *
     * @mbggenerated
     */
    private Integer cId;

    /**
     * 收到评论的用户ID
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * 评论栏目ID
     *
     * @mbggenerated
     */
    private Byte typeId;

    /**
     * 评论内容的ID
     *
     * @mbggenerated
     */
    private Integer commitId;

    /**
     * 评论内容
     *
     * @mbggenerated
     */
    private String commitContent;

    /**
     * 评论者ID
     *
     * @mbggenerated
     */
    private Integer commitUserId;

    /**
     * 评论时间
     *
     * @mbggenerated
     */
    private Integer commitTime;

    /**
     * 评论时的IP地址
     *
     * @mbggenerated
     */
    private String commitIp;

    private static final long serialVersionUID = 1L;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Byte getTypeId() {
        return typeId;
    }

    public void setTypeId(Byte typeId) {
        this.typeId = typeId;
    }

    public Integer getCommitId() {
        return commitId;
    }

    public void setCommitId(Integer commitId) {
        this.commitId = commitId;
    }

    public String getCommitContent() {
        return commitContent;
    }

    public void setCommitContent(String commitContent) {
        this.commitContent = commitContent;
    }

    public Integer getCommitUserId() {
        return commitUserId;
    }

    public void setCommitUserId(Integer commitUserId) {
        this.commitUserId = commitUserId;
    }

    public Integer getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Integer commitTime) {
        this.commitTime = commitTime;
    }

    public String getCommitIp() {
        return commitIp;
    }

    public void setCommitIp(String commitIp) {
        this.commitIp = commitIp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cId=").append(cId);
        sb.append(", userId=").append(userId);
        sb.append(", typeId=").append(typeId);
        sb.append(", commitId=").append(commitId);
        sb.append(", commitContent=").append(commitContent);
        sb.append(", commitUserId=").append(commitUserId);
        sb.append(", commitTime=").append(commitTime);
        sb.append(", commitIp=").append(commitIp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}