package org.nix.zpbs.model;

import java.io.Serializable;

public class UserGroup implements Serializable {
    /**
     * 自增ID号
     *
     * @mbggenerated
     */
    private Byte gId;

    /**
     * 用户组ID
     *
     * @mbggenerated
     */
    private Byte groupId;

    /**
     * 用户组名
     *
     * @mbggenerated
     */
    private String groupName;

    /**
     * 用户权限
     *
     * @mbggenerated
     */
    private String groupPower;

    private static final long serialVersionUID = 1L;

    public Byte getgId() {
        return gId;
    }

    public void setgId(Byte gId) {
        this.gId = gId;
    }

    public Byte getGroupId() {
        return groupId;
    }

    public void setGroupId(Byte groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupPower() {
        return groupPower;
    }

    public void setGroupPower(String groupPower) {
        this.groupPower = groupPower;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gId=").append(gId);
        sb.append(", groupId=").append(groupId);
        sb.append(", groupName=").append(groupName);
        sb.append(", groupPower=").append(groupPower);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}