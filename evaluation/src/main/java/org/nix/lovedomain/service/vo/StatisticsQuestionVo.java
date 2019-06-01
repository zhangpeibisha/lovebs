package org.nix.lovedomain.service.vo;

import lombok.Data;
import org.nix.lovedomain.dao.business.json.winding.PublishAttachInfo;
import org.nix.lovedomain.dao.business.json.winding.StatisticsAttachInfor;
import org.nix.lovedomain.dao.business.json.winding.StatisticsItem;
import org.nix.lovedomain.dao.business.json.winding.StatisticsItemChose;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author zhangpei
 * @version 1.0
 * @description 统计一个发布评教卷的详细信息
 * @date 2019/5/29
 */
@Data
public class StatisticsQuestionVo {
    /**
     * 评教表的标题
     */
    private String title;
    /**
     * 总分
     */
    private Double totalScore;

    /**
     * 平均分
     */
    private Double avgScore;
    /**
     * 存放建议
     */
    private List<PublishAttachInfo.Advice> adviseList;

    /**
     * 应该回多少人回答
     */
    private Integer shouldAnswer;

    /**
     * 实际多人回答
     */
    private Integer realityAnswer;

    /**
     * 黑名单学生
     */
    private List<StudentInfo> black;
    /**
     * 黑名单人数
     */
    private Integer blackNumber;

    /**
     * 该评卷的题目详细信息
     */
    private List<TopicStatistics> topicStatistics;

    /**
     * 选项统计
     */
    @Data
    public static class OptionStatistics {
        /**
         * 选项题目
         */
        private String title;
        /**
         * 选项分数
         */
        private Integer score;
        /**
         * 选择次数
         */
        private Integer chooseOfNumber;
    }

    /**
     * 题目统计
     */
    @Data
    public static class TopicStatistics {
        /**
         * 选项标题
         */
        private String title;

        /**
         * 总分
         */
        private Double totalScore;

        /**
         * 平均分
         */
        private Double avgScore;

        /**
         * 选择次数
         */
        private Integer chooseOfNumber;
        /**
         * 选项统计
         */
        private List<OptionStatistics> optionStatistics;
    }

    /**
     * 学生的简约信息
     */
    @Data
    public static class StudentInfo {
        private Integer accountId;
        private String studentId;
        private String name;
    }

    /**
     * 创建一个评教卷的所有题目的统计信息
     *
     * @param topic  题目统计集合
     * @param option 选项统计集合
     * @return 一个评教卷的所有题目的统计信息
     */
    public static List<TopicStatistics> createTopicStatisticsList(StatisticsAttachInfor topic, StatisticsAttachInfor option) {
        if (topic != null) {
            // 这个信息为  StatisticsItem 为有效数据 ===== 题目统计信息
            Map<String, StatisticsItem> topicItemMap = topic.toItemStatsiticsMap();
            // 这个信息为 StatisticsItem->choseMap 为有效数据 ===== 题目选项统计信息
            if (option != null) {
                Map<String, StatisticsItem> optionMap = option.toItemStatsiticsMap();
                List<TopicStatistics> topicStatistics = new ArrayList<>(topicItemMap.size());
                topicItemMap.forEach((topicId, statisticsItem) -> {
                    StatisticsItem optionInfo = optionMap.get(topicId);
                    if (optionInfo != null) {
                        topicStatistics.add(createTopicStatistics(statisticsItem, optionInfo));
                    }
                });
                return topicStatistics;
            }
        }
        return null;
    }

    /**
     * 创建一个题目的展示信息
     *
     * @param topic  题目的有效统计信息
     * @param option 选项的有效统计信息
     * @return 题目的整体有效展示信息
     */
    public static TopicStatistics createTopicStatistics(StatisticsItem topic, StatisticsItem option) {
        TopicStatistics topicStatistics = new TopicStatistics();
        // 处理题目的信息
        topicStatistics.setAvgScore(topic.getAvg());
        topicStatistics.setChooseOfNumber(topic.getNumberOfChose());
        topicStatistics.setTitle(topic.getTitle());
        topicStatistics.setTotalScore(topic.getTotalScore().doubleValue());

        // 处理该题目的信息
        topicStatistics.setOptionStatistics(createOptionStatisticsList(option));
        return topicStatistics;
    }

    /**
     * 创建一个题目的所有选项信息
     *
     * @param option 一个题目的选项集合
     * @return 选项的统计集合
     */
    public static List<OptionStatistics> createOptionStatisticsList(StatisticsItem option) {
        if (option == null) {
            return new ArrayList<>();
        }
        Map<String, StatisticsItemChose> choseMap = option.getChoseMap();
        List<OptionStatistics> optionStatistics = new ArrayList<>(choseMap.size());
        choseMap.forEach((choseId, statisticsItemChose) -> optionStatistics.add(createOptionStatistics(statisticsItemChose)));
        return optionStatistics;
    }

    /**
     * 创建一个选项数据
     *
     * @param option
     * @return
     */
    public static OptionStatistics createOptionStatistics(StatisticsItemChose option) {
        OptionStatistics optionStatistics = new OptionStatistics();
        optionStatistics.setChooseOfNumber(option.getCount());
        optionStatistics.setScore(option.getScore());
        optionStatistics.setTitle(option.getDescription());
        return optionStatistics;
    }


}
