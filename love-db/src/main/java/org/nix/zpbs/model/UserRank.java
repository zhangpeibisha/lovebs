package org.nix.zpbs.model;

import java.io.Serializable;

public class UserRank implements Serializable {
    /**
     * 自增ID
     *
     * @mbggenerated
     */
    private Integer rankId;

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
    private Integer rankMark;

    /**
     * 等级名称
     *
     * @mbggenerated
     */
    private String rankName;

    private static final long serialVersionUID = 1L;

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    public Short getUserRankId() {
        return userRankId;
    }

    public void setUserRankId(Short userRankId) {
        this.userRankId = userRankId;
    }

    public Integer getRankMark() {
        return rankMark;
    }

    public void setRankMark(Integer rankMark) {
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