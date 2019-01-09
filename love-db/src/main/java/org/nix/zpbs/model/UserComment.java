package org.nix.zpbs.model;

import java.io.Serializable;

public class UserComment implements Serializable {
    /**
     * 评论自增ID号
     *
     * @mbggenerated
     */
    private Long cId;

    /**
     * 收到评论的用户ID
     *
     * @mbggenerated
     */
    private Long userId;

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
    private Long commitId;

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
    private Long commitUserId;

    /**
     * 评论时间
     *
     * @mbggenerated
     */
    private Long commitTime;

    /**
     * 评论时的IP地址
     *
     * @mbggenerated
     */
    private String commitIp;

    private static final long serialVersionUID = 1L;

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getTypeId() {
        return typeId;
    }

    public void setTypeId(Byte typeId) {
        this.typeId = typeId;
    }

    public Long getCommitId() {
        return commitId;
    }

    public void setCommitId(Long commitId) {
        this.commitId = commitId;
    }

    public String getCommitContent() {
        return commitContent;
    }

    public void setCommitContent(String commitContent) {
        this.commitContent = commitContent;
    }

    public Long getCommitUserId() {
        return commitUserId;
    }

    public void setCommitUserId(Long commitUserId) {
        this.commitUserId = commitUserId;
    }

    public Long getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Long commitTime) {
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