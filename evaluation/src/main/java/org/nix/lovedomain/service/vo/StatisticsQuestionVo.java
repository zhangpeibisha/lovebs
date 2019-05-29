package org.nix.lovedomain.service.vo;

import lombok.Data;
import org.nix.lovedomain.dao.business.json.winding.PublishAttachInfo;

import java.util.List;

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

}
