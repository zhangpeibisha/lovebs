package org.nix.lovedomain.dao.business.json.winding;

import cn.hutool.json.JSONUtil;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @anthor on 2019/5/26
 * @since jdk8
 *
 * 题目统计
 */
@Data
public class StatisticsItem {

    /**
     * 问题id
     */
    private String questionId;

    /**
     * 问题题目
     */
    private String title;

    /**
     * 问题平均分
     */
    private double avg;

    /**
     * 问题选择人次
     */
    private Integer numberOfChose = 0;

    /**
     * 该题目的总分
     */
    private Integer totalScore = 0;

    /**
     * 每个选项的选择次数
     */
    private Map<String,StatisticsItemChose> choseMap = new HashMap<>();

    public StatisticsItem() {
    }

    public StatisticsItem(String questionId, String title) {
        this.questionId = questionId;
        this.title = title;
    }

    public void setAvg(double avg) {
        // 四舍五入到两位小数
        this.avg =  (double) Math.round(avg * 100) / 100;
    }

    /**
     * 字符串转化成 <code>StatisticsItem</code>
     * 实体类
     * @param statisticsAttachInfor
     * @return
     */
    public StatisticsItem toStatisticsItem(StatisticsAttachInfor statisticsAttachInfor){
        return JSONUtil.toBean(statisticsAttachInfor.getStatisticsItem(),StatisticsItem.class);
    }
}
