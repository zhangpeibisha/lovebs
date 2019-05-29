package org.nix.lovedomain.dao.business.json.winding;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Filter;
import cn.hutool.core.lang.Validator;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.UnhandledException;
import org.nix.lovedomain.dao.business.json.question.QuestionnaireEnum;
import org.nix.lovedomain.dao.model.PublishQuestionnaireModel;
import org.nix.lovedomain.dao.model.StatisticsScoreModel;
import org.nix.lovedomain.service.ServiceException;
import org.nix.lovedomain.utils.LogUtil;

import java.util.*;

/**
 * @author zhangpei
 * @version 1.0
 * @description 发布评教卷中的附加信息
 * @date 2019/4/22
 */
@Slf4j
@Data
public class PublishAttachInfo {

    /**
     * 应该参与评教卷的学生:根据实际情况系统填写
     * 存储参与学生的账户id信息
     */
    private List<Integer> students;

    /**
     * 填写了评教卷的学生的答案信息:根据实际情况系统填写
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
    private List<Advice> advice;

    public static PublishAttachInfo getBean(PublishQuestionnaireModel publishQuestionnaireModel) {
        if (publishQuestionnaireModel == null || publishQuestionnaireModel.getStatistics() == null) {
            return new PublishAttachInfo();
        }
        String statistics = publishQuestionnaireModel.getStatistics();
        return JSONUtil.toBean(statistics, PublishAttachInfo.class);
    }

    /**
     * 添加一个黑名单
     *
     * @param studentAccountIds 学生的账户id
     */
    public void addBlackStudent(List<Integer> studentAccountIds) {
        black = new HashSet<>();
        int currSize = black.size();
        studentAccountIds = CollUtil.filter(studentAccountIds, Objects::nonNull);
        int needSize = studentAccountIds.size();
        if (canFilters - needSize >= 0) {
            for (Integer blackId : studentAccountIds) {
                try {
                    Validator.validateTrue(students.contains(blackId),
                            "准备设置学生{}的评卷不计入总分，但是该学生并不参与该评教卷的回答:参与学生->{}", blackId, students);
                } catch (Exception e) {
                    log.warn("参与评教卷发生异常：{}", e.getMessage(), e);
                }
            }
            black.addAll(studentAccountIds);
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
                || completesQuestion.getStudentAccountId() == null) {
            throw new ServiceException(LogUtil.logInfo(log, "填写的评教卷没有提交状态或者学生id"));
        }
        /**
         * 状态类型是否标准
         */
        boolean haveStatus = (status.equals(CompletesQuestion.STATUS_COMMIT)
                || status.equals(CompletesQuestion.STATUS_KEEP));

        if (!haveStatus) {
            throw new ServiceException(LogUtil.logInfo(log, "评教卷状态值不符合要求：{}", status));
        }

        if (completesQuestions == null) {
            completesQuestions = new ArrayList<>();
        }

        // 如果已经答卷则不允许答卷了
        for (CompletesQuestion question : completesQuestions) {
            if (question.getStudentAccountId().equals(completesQuestion.getStudentAccountId())) {
                return;
            }
        }
        completesQuestions.add(completesQuestion);
    }


    /**
     * 得到整体的得分
     *
     * @return
     */
    public StatisticsScoreModel statisticalAnswer(PublishQuestionnaireModel publishQuestionnaireModel) {
        // 计算总体分数
        statistical();
        StatisticsScoreModel statisticsScoreModel = new StatisticsScoreModel();
        StatisticsAttachInfor statisticsAttachInfor = new StatisticsAttachInfor();
        /*统计信息*/
        statisticsScoreModel.setScore(Double.valueOf(this.score + ""));
        statisticsScoreModel.setType(1);
        /*统计的相关信息*/
        statisticsAttachInfor.setAdviseList(advice);
        addScoreInfor(publishQuestionnaireModel, statisticsScoreModel, statisticsAttachInfor);
        return statisticsScoreModel;
    }


    /**
     * 当评教卷到达终结时间的时候
     * 开始统计总共的分数
     */
    public void statistical() {
        score = 0;
        attend = 0;
        if (CollUtil.isEmpty(completesQuestions)) {
            return;
        }
        // 统计的时候不管提交和保存，都计入统计中
        for (CompletesQuestion completesQuestion : completesQuestions) {

            Integer studentId = completesQuestion.getStudentAccountId();
            addAttend(studentId);

            List<QuestionReply> questionReplies = JSON.parseArray
                    (JSON.toJSONString(completesQuestion.getQuestionReplies()), QuestionReply.class);

            if (CollUtil.isEmpty(questionReplies)) {
                continue;
            }
            for (QuestionReply questionReply : questionReplies) {
                if (questionReply.getScore() == 0) {
                    if (advice == null) {
                        advice = new ArrayList<>();
                    }
                    String suggest = questionReply.suggest;
                    if (suggest != null) {
                        advice.add(new Advice(questionReply.getTitle(), suggest, studentId));
                    }
                } else {
                    Integer score = questionReply.getScore();
                    //不计入总分的情况：1）分数字段为空，2）分数小于0,3）该学生被列入黑名单
                    if (score == null || score <= 0 || isBlackStudent(studentId)) {
                        continue;
                    }
                    this.score += score;
                }

            }
        }
    }


    /**
     * 统一问卷的平均分
     * 公式：总分数/填写的人数（出席人数）
     *
     * @return
     */
    public StatisticsScoreModel statisticsAvgScore(PublishQuestionnaireModel publishQuestionnaireModel) {
        //计算总分
        statistical();
        StatisticsScoreModel statisticsScoreModel = new StatisticsScoreModel();
        StatisticsAttachInfor statisticsAttachInfor = new StatisticsAttachInfor();
        /*统计信息*/
        double avgScore = (double) (this.score) / this.attend;
        statisticsScoreModel.setScore(avgScore);
        statisticsScoreModel.setType(2);
        /*统计的相关信息*/
        addScoreInfor(publishQuestionnaireModel, statisticsScoreModel, statisticsAttachInfor);
        return statisticsScoreModel;
    }

    /**
     * 计算每个选项的平均分
     * 公式：选项的总分/填写该项的人数
     *
     * @param publishQuestionnaireModel
     * @return
     */
    public StatisticsScoreModel statisticsItemScore(PublishQuestionnaireModel publishQuestionnaireModel, QuestionList questionList) throws UnhandledException, JsonProcessingException {
        StatisticsScoreModel statisticsScoreModel = new StatisticsScoreModel();
        StatisticsAttachInfor statisticsAttachInfor = new StatisticsAttachInfor();
        // 每道题的统计信息，包含平均分、总分、选择人次
        Map<String, StatisticsItem> statisticsItemMap = calculateEachItemAvScore(questionList);
        statisticsAttachInfor.setStatisticsItem(JSON.toJSONString(statisticsItemMap));
        statisticsScoreModel.setType(3);
        /*统计的相关信息*/
        addScoreInfor(publishQuestionnaireModel, statisticsScoreModel, statisticsAttachInfor);
        return statisticsScoreModel;
    }

    /**
     * 计算每个选项的平均分
     * <p>
     * 统计单选和多选的分数
     *
     * @return
     */
    public Map<String, StatisticsItem> calculateEachItemAvScore(QuestionList questionList) {

        //每个选项的统计信息   问题id--->问题的统计信息
        Map<String, StatisticsItem> statisticsItemHashMap = new HashMap<>();
        int attend = 0;
        if (CollUtil.isEmpty(completesQuestions)) {
            return null;
        }
        // 统计的时候不管提交和保存，都计入统计中,得到每个学生的回答
        for (CompletesQuestion completesQuestion : completesQuestions) {
            Integer studentId = completesQuestion.getStudentAccountId();

            List<QuestionReply> questionReplies = JSON.parseArray
                    (JSON.toJSONString(completesQuestion.getQuestionReplies()), QuestionReply.class);

            if (CollUtil.isEmpty(questionReplies)) {
                continue;
            }
            // 遍历每个学生的回答，回答中有问题id和选择id，咦问题id为标准进行扫描学生回答
            for (QuestionReply questionReply : questionReplies) {
                // 获取题目统计实体
                StatisticsItem statisticsItem = statisticsItemHashMap.get(questionReply.getQuestionId());
                if (statisticsItem == null) {
                    // 初始化统计实体，注入问题id和问题的题目
                    statisticsItem = new StatisticsItem(questionReply.getQuestionId(),
                            questionList.getQuestionTitleMap().get(questionReply.getQuestionId()));
                }

                // 开始得到回答信息
                if (questionReply.getScore() > 0) {
                    statisticsItem.setNumberOfChose(statisticsItem.getNumberOfChose() + 1);
                    Integer score = questionReply.getScore();
                    //不计入总分的情况：1）分数字段为空，2）分数小于0,3）该学生被列入黑名单
                    if (score == null || score <= 0 || isBlackStudent(studentId)) {
                        continue;
                    }
                    attend++;
                    // 每次都进行总分和平均分计算
                    statisticsItem.setTotalScore(statisticsItem.getTotalScore() + score);
                }
                // 更新数据
                statisticsItemHashMap.put(questionReply.getQuestionId(), statisticsItem);
            }
        }

        /*求选项的平均分*/
        for (StatisticsItem s :
                statisticsItemHashMap.values()) {
            s.setAvg((double) (s.getTotalScore()) / s.getNumberOfChose());
        }
        // 返回这个统计的数据
        return statisticsItemHashMap;
    }

    /**
     * 添加统计的相关信息
     *
     * @param statisticsScoreModel
     */
    public void addScoreInfor(PublishQuestionnaireModel publishQuestionnaireModel,
                              StatisticsScoreModel statisticsScoreModel,
                              StatisticsAttachInfor statisticsAttachInfor) {
        /*主要信息*/
        statisticsScoreModel.setCourseId(publishQuestionnaireModel.getCourseId());
        statisticsScoreModel.setPublishQuestionnaireId(publishQuestionnaireModel.getId());
        statisticsScoreModel.setTeacherAccountId(publishQuestionnaireModel.getTeacherAccountId());
        /*附加信息*/
        statisticsAttachInfor.setShouldAnswer(this.plan);
        statisticsAttachInfor.setRealityAnswer(this.attend);
        statisticsAttachInfor.setBlack(this.canFilters);
        statisticsScoreModel.setAttachJson(JSONUtil.toJsonStr(statisticsAttachInfor));
    }

    /**
     * 统计每个题目的每个选项的人数
     *
     * @param publishQuestionnaireModel
     * @return
     */
    public StatisticsScoreModel statisticsItemChose(PublishQuestionnaireModel publishQuestionnaireModel,
                                                    QuestionList questionList) {

        //每个选项的统计信息
        Map<String, StatisticsItem> statisticsItemHashMap = new HashMap<>();
        if (CollUtil.isEmpty(completesQuestions)) {
            return null;
        }
        // 统计的时候不管提交和保存，都计入统计中，获取到所有回答
        for (CompletesQuestion completesQuestion : completesQuestions) {
            Integer studentId = completesQuestion.getStudentAccountId();
            List<QuestionReply> questionReplies = JSON.parseArray
                    (JSON.toJSONString(completesQuestion.getQuestionReplies()), QuestionReply.class);
            if (CollUtil.isEmpty(questionReplies)) {
                continue;
            }
            // 得到每个用户的所有
            for (QuestionReply questionReply : questionReplies) {
                // 获取问题id
                String questionId = questionReply.getQuestionId();
                // 获取题目统计实体
                StatisticsItem statisticsItem = statisticsItemHashMap.get(questionId);
                if (statisticsItem == null) {
                    // 初始化信息,
                    Map<String, String> questionTitleMap = questionList.getQuestionTitleMap();
                    statisticsItem = new StatisticsItem(questionId,
                            questionTitleMap.get(questionId));
                }
                int score = questionReply.getScore();
                if (score > 0) {
                    // 获取选项统计实体
                    String chooseId = questionReply.getChooseId();
                    // 获取这个问题的选择id，若有人选了，则直接获取，若无选，则创建一个统计对象
                    StatisticsItemChose statisticsItemChose = statisticsItem.getChoseMap().get(chooseId);
                    if (statisticsItemChose == null) {
                        statisticsItemChose = new StatisticsItemChose(chooseId,
                                questionList.getOptionDescrpMap().get(chooseId),questionReply.getScore());
                    }
                    // 记录这个题目被选了好多次
                    statisticsItem.setNumberOfChose(statisticsItem.getNumberOfChose() + 1);

                    //不计入总分的情况：1）分数字段为空，2）分数小于0,3）该学生被列入黑名单
                    if (isBlackStudent(studentId)) {
                        continue;
                    }
                    // 记录选项次数
                    statisticsItemChose.setCount(statisticsItemChose.getCount() + 1);

                    statisticsItem.getChoseMap().put(chooseId, statisticsItemChose);
                    statisticsItemHashMap.put(questionId, statisticsItem);
                }
            }
        }

        // 录入信息
        StatisticsScoreModel statisticsScoreModel = new StatisticsScoreModel();
        StatisticsAttachInfor statisticsAttachInfor = new StatisticsAttachInfor();
        statisticsAttachInfor.setStatisticsItem(JSON.toJSONString(statisticsItemHashMap));
        statisticsScoreModel.setType(4);
        /*统计的相关信息*/
        addScoreInfor(publishQuestionnaireModel, statisticsScoreModel, statisticsAttachInfor);
        return statisticsScoreModel;

    }


    /**
     * 判断是否记录学生出席
     * 如果是黑名单中的学生将不计入出勤人数中
     */
    public boolean addAttend(Integer studentAccountId) {
        if (!isBlackStudent(studentAccountId)) {
            attend++;
            return false;
        }
        return true;
    }

    /**
     * 判断学生是否再黑名单中
     *
     * @param studentId
     * @return
     */
    public boolean isBlackStudent(Integer studentId) {
        return black != null && black.contains(studentId);
    }

    /**
     * 存放建议信息
     */
    @Data
    @AllArgsConstructor
    public static class Advice {
        private String title;
        private String advice;
        /**
         * 学生账号id
         */
        private Integer studentAccountId;
    }

    /**
     * 完成评教卷信息
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
        private Integer studentAccountId;
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
