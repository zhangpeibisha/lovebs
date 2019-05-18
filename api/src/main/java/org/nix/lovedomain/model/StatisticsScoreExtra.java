package org.nix.lovedomain.model;

/**
 * @version 1.0
 * @anthor on 2019/5/14
 * @since jdk8
 *
 *用于统计专业、学院的分数统计
 */
public class StatisticsScoreExtra {

    private Integer id;

    private String coding;

    private String name;

    private String statistics;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatistics() {
        return statistics;
    }

    public void setStatistics(String statistics) {
        this.statistics = statistics;
    }
}
