package org.nix.zpbs.model;

import java.io.Serializable;

public class UserRank implements Serializable {
    /**
     * 自增ID
     *
     * @mbggenerated
     */
    private Long rankId;

    /**
     * 等级ID
     *
     * @mbggenerated
     */
    private Short userRankId;

    /**
     * 等级积分
     *
     * @mbggenerated
     */
    private Long rankMark;

    /**
     * 等级名称
     *
     * @mbggenerated
     */
    private String rankName;

    private static final long serialVersionUID = 1L;

    public Long getRankId() {
        return rankId;
    }

    public void setRankId(Long rankId) {
        this.rankId = rankId;
    }

    public Short getUserRankId() {
        return userRankId;
    }

    public void setUserRankId(Short userRankId) {
        this.userRankId = userRankId;
    }

    public Long getRankMark() {
        return rankMark;
    }

    public void setRankMark(Long rankMark) {
        this.rankMark = rankMark;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rankId=").append(rankId);
        sb.append(", userRankId=").append(userRankId);
        sb.append(", rankMark=").append(rankMark);
        sb.append(", rankName=").append(rankName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}