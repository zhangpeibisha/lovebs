package org.nix.lovedomain.dao.business.json.winding;

import lombok.Data;
import org.nix.lovedomain.dao.business.json.question.QuestionnaireEnum;
import org.nix.lovedomain.service.vo.StudentVo;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 发布问卷中的附加信息
 * @date 2019/4/22
 */
@Data
public class PublishAttachInfo {

    /**
     * 应该参与问卷的学生:根据实际情况系统填写
     */
    private List<StudentVo> students;

    /**
     * 填写了问卷的学生的答案信息:根据实际情况系统填写
     */
    private List<CompletesQuestion> completesQuestions;

    /**
     * 应该出席多少人:根据实际情况系统填写
     */
    private Integer plan;

    /**
     * 实际填写的人数:根据实际情况系统填写
     */
    private Integer attend;

    /**
     * 老师能够配置多少人的答卷不计入分数:任课老师填写
     */
    private Integer canFilters;

    /**
     * 不计入分数的黑名单:任课老师填写
     */
    private List<Integer> black;

    /**
     * 评卷得分
     */
    private Integer score;

    /**
     * 完成问卷信息
     */
    @Data
    public static class CompletesQuestion {
        private String studentId;
        private List<QuestionReply> questionReplies;
    }

    /**
     * 问题回答信息
     */
    @Data
    public static class QuestionReply {
        /**
         * 选择题，填空题通用
         */
        private QuestionnaireEnum questionnaireEnum;
        private String questionId;
        private String title;
        /**
         * 选择id和分数，用于选择题
         */
        private String choseId;
        private Integer score;
        /**
         * 用于填空题，给老师的建议
         */
        private String suggest;
    }
}
