package org.nix.zpbs.model;

import java.io.Serializable;

public class PowerList implements Serializable {
    /**
     * 自增ID
     *
     * @mbggenerated
     */
    private Integer pId;

    /**
     * 权限ID
     *
     * @mbggenerated
     */
    private Integer powerId;

    /**
     * 权限描述
     *
     * @mbggenerated
     */
    private String powerName;

    private static final long serialVersionUID = 1L;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getPowerId() {
        return powerId;
    }

    public void setPowerId(Integer powerId) {
        this.powerId = powerId;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pId=").append(pId);
        sb.append(", powerId=").append(powerId);
        sb.append(", powerName=").append(powerName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}