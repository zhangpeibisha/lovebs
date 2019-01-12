package org.nix.zpbs.model;

import java.io.Serializable;

public class UserRank implements Serializable {
    /**
     * 自增ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 等级
     *
     * @mbggenerated
     */
    private Long userRank;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserRank() {
        return userRank;
    }

    public void setUserRank(Long userRank) {
        this.userRank = userRank;
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
        sb.append(", id=").append(id);
        sb.append(", userRank=").append(userRank);
        sb.append(", rankMark=").append(rankMark);
        sb.append(", rankName=").append(rankName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}