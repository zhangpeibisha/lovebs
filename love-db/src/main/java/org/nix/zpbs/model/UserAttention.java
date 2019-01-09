package org.nix.zpbs.model;

import java.io.Serializable;

public class UserAttention implements Serializable {
    /**
     * 自增ID
     *
     * @mbggenerated
     */
    private Short aId;

    /**
     * 用户ID
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * 关注ID
     *
     * @mbggenerated
     */
    private Long attentionId;

    private static final long serialVersionUID = 1L;

    public Short getaId() {
        return aId;
    }

    public void setaId(Short aId) {
        this.aId = aId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAttentionId() {
        return attentionId;
    }

    public void setAttentionId(Long attentionId) {
        this.attentionId = attentionId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", aId=").append(aId);
        sb.append(", userId=").append(userId);
        sb.append(", attentionId=").append(attentionId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}