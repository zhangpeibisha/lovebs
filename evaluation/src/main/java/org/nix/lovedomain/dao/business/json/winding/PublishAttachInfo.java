package org.nix.lovedomain.dao.business.json.winding;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Filter;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.json.question.QuestionnaireEnum;
import org.nix.lovedomain.model.Publishquestionnaire;
import org.nix.lovedomain.service.PublishquestionnaireService;
import org.nix.lovedomain.service.ServiceException;
import org.nix.lovedomain.service.vo.StudentVo;
import org.nix.lovedomain.utils.LogUtil;

import java.util.*;

/**
 * @author zhangpei
 * @version 1.0
 * @description 发布问卷中的附加信息
 * @date 2019/4/22
 */
@Slf4j
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
     * 老师能够配置多少人的答卷不计入分数:发布老师填写
     */
    private Integer canFilters;

    /**
     * 不计入分数的黑名单:任课老师填写
     */
    private Set<Integer> black;

    /**
     * 评卷得分
     */
    private Integer score;
    /**
     * 所有的意见
     */
    private List<String> advice;

    public static PublishAttachInfo getBean(Publishquestionnaire publishquestionnaire) {
        if (publishquestionnaire == null || publishquestionnaire.getStatistics() == null) {
            return new PublishAttachInfo();
        }
        String statistics = publishquestionnaire.getStatistics();
        return JSONUtil.toBean(statistics, PublishAttachInfo.class);
    }

    /**
     * 添加一个黑名单
     *
     * @param studentIds 学生id集合，在学生表中的id集合
     */
    public void addBlackStudent(List<Integer> studentIds) {
        black = new HashSet<>();
        int currSize = black.size();
        studentIds = CollUtil.filter(studentIds, Objects::nonNull);
        int needSize = studentIds.size();
        if (canFilters - needSize >= 0) {
//            for (Integer s : studentIds) {
//                try {
//                    PublishquestionnaireService.checkStudentHavePermissionUse(this, s);
//                } catch (Exception e) {
//                    throw new ServiceException(LogUtil.logInfo(log, "学生{}在本问卷中没有访问权限，不用添加黑名单", s));
//                }
//            }
            black.addAll(studentIds);
            return;
        }
        throw new ServiceException(LogUtil.logInfo(log, "添加黑名单人数超出限制 max={} currSize={} joinSize={}",
                canFilters, currSize, needSize));
    }

    /**
     * 删除黑名单中的学生,并把黑名单的
     * 许可数量恢复到=当前空余+删除学生数量（有效值）
     *
     * @param studentIds 学生id集合
     */
    public void deleteBlackStudent(List<Integer> studentIds) {
        if (CollUtil.isEmpty(black)) {
            return;
        }
        Collection<Integer> filter = CollUtil.filter(studentIds,
                (Filter<Integer>) integer -> !black.contains(integer));
        black = CollUtil.newHashSet(filter);
    }

    /**
     * 学生交卷，可保存，可提交
     * 如果答案中没有状态
     *
     * @param completesQuestion
     */
    public void writeQuestion(CompletesQuestion completesQuestion) {
        if (completesQuestion == null) {
            return;
        }
        String status;
        if ((status = completesQuestion.getStatus()) == null
                || completesQuestion.getStudentId() == null) {
            throw new ServiceException(LogUtil.logInfo(log, "填写的问卷没有提交状态或者学生id"));
        }
        /**
         * 状态类型是否标准
         */
        boolean haveStatus = (status.equals(CompletesQuestion.STATUS_COMMIT)
                || status.equals(CompletesQuestion.STATUS_KEEP));

        if (!haveStatus) {
            throw new ServiceException(LogUtil.logInfo(log, "问卷状态值不符合要求：{}", status));
        }

        if (completesQuestions == null) {
            return;
        }

        // 如果已经答卷则不允许答卷了
        for (CompletesQuestion question : completesQuestions) {
            if (question.getStudentId().equals(completesQuestion.getStudentId())) {
                return;
            }
        }

        completesQuestions.add(completesQuestion);

    }

    /**
     * 更新回答，如果已经提交则抛出异常
     *
     * @param completesQuestion
     */
    public void updateQuestion(CompletesQuestion completesQuestion) {
        if (completesQuestion == null) {
            return;
        }
        String status = completesQuestion.getStatus();
        // 可能操作不当，默认保存为keep
        if (status == null) {
            throw new ServiceException(LogUtil.logInfo(log, "该问卷状态为空，视为异常答案，删除:{}"
                    , JSONUtil.toJsonStr(completesQuestion)));
        }
        if (CompletesQuestion.STATUS_COMMIT.equals(status)) {
            throw new ServiceException(LogUtil.logInfo(log, "问卷已经提交，不可修改"));
        }
        Integer studentId = completesQuestion.getStudentId();
        if (studentId == null) {
            return;
        }
        int i = 0;
        for (CompletesQuestion temp : completesQuestions) {
            if (temp.getStudentId().equals(studentId)) {
                break;
            }
            i++;
        }
        completesQuestions.remove(i);
        completesQuestions.add(completesQuestion);
    }

    /**
     * 当问卷到达终结时间的时候
     * 开始统计分数
     */
    public void statistical() {
        score = 0;
        attend = 0;
        if (CollUtil.isEmpty(completesQuestions)) {
            return;
        }
        // 统计的时候不管提交和保存，都计入统计中
        for (CompletesQuestion completesQuestion : completesQuestions) {
            // 不管是否是黑名单，都要计入出勤人数中
            attend++;
            Integer studentId = completesQuestion.getStudentId();
            // 黑名单不计入统计
//            if (black.contains(studentId)) {
//                continue;
//            }
            List<QuestionReply> questionReplies = JSON.parseArray
                    (JSON.toJSONString(completesQuestion.getQuestionReplies()),QuestionReply.class);


            if (CollUtil.isEmpty(questionReplies)) {
                continue;
            }
            for (QuestionReply questionReply : questionReplies) {
                if (questionReply.questionnaireEnum.equals(QuestionnaireEnum.text)) {
                    if (advice == null){
                        advice = new ArrayList<>();
                    }
                    advice.add(questionReply.suggest);
                } else {
                    Integer score = questionReply.getScore();
                    //不计入总分的情况：1）分数字段为空，2）分数小于0,3）该学生被列入黑名单
                    if (score == null || score <= 0 ||(black!=null && black.contains(studentId)) ) {
                        continue;
                    }
                    this.score += score;
                }

            }
        }
    }

    /**
     * 得到整体的得分
     *
     * @return
     */
    public StatisticalAnswer statisticalAnswer() {
        statistical();
        return StatisticalAnswer.builder()
                .score(score)
                .attend(attend)
                .plan(plan)
                .black(black == null ? 0 : black.size())
                .canFilters(canFilters)
                .advice(advice)
                .build();
    }


    @Data
    @Builder
    public static class StatisticalAnswer {

        /**
         * 应该出席多少人:根据实际情况系统填写
         */
        private Integer plan;

        /**
         * 实际填写的人数:根据实际情况系统填写
         */
        private Integer attend;

        /**
         * 老师能够配置多少人的答卷不计入分数:发布老师填写
         */
        private Integer canFilters;

        /**
         * 不计入分数的黑名单数量
         */
        private Integer black;

        /**
         * 评卷得分
         */
        private Integer score;

        private List<String> advice;

    }

    /**
     * 完成问卷信息
     */
    @Data
    public static class CompletesQuestion {
        public static final String STATUS_COMMIT = "commit";
        public static final String STATUS_KEEP = "keep";
        /**
         * 提交状态，分为保存和提交
         * 保存可以修改，暂不计入统计
         * 提交则不可以修改，计入统计
         */
        private String status;
        private Integer studentId;
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
        private String chooseId;
        private Integer score = 0;
        /**
         * 用于填空题，给老师的建议
         */
        private String suggest;
    }
}
