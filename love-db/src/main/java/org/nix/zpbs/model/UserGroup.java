package org.nix.zpbs.model;

import java.io.Serializable;

public class UserGroup implements Serializable {
    /**
     * 自增ID号
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 用户组描述
     *
     * @mbggenerated
     */
    private String groupDescription;

    /**
     * 用户组名
     *
     * @mbggenerated
     */
    private String groupName;

    /**
     * 用户组的上一级，该级包含了上级的所有权限，如果为最低级则为空
     *
     * @mbggenerated
     */
    private Long groupPrent;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getGroupPrent() {
        return groupPrent;
    }

    public void setGroupPrent(Long groupPrent) {
        this.groupPrent = groupPrent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", groupDescription=").append(groupDescription);
        sb.append(", groupName=").append(groupName);
        sb.append(", groupPrent=").append(groupPrent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}