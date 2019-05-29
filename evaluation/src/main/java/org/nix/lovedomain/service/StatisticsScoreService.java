package org.nix.lovedomain.service;import cn.hutool.core.collection.CollUtil;import cn.hutool.core.lang.Validator;import com.alibaba.fastjson.JSON;import com.fasterxml.jackson.core.JsonProcessingException;import org.nix.lovedomain.dao.business.*;import org.nix.lovedomain.dao.business.json.question.EvaluationQuestionnaireContent;import org.nix.lovedomain.dao.business.json.winding.PublishAttachInfo;import org.nix.lovedomain.dao.business.json.winding.QuestionList;import org.nix.lovedomain.dao.business.json.winding.StatisticsAttachInfor;import org.nix.lovedomain.dao.business.json.winding.StatisticsItem;import org.nix.lovedomain.dao.model.*;import org.nix.lovedomain.service.vo.StatisticsQuestionVo;import org.nix.lovedomain.utils.ListUtils;import org.springframework.security.access.method.P;import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;import javax.annotation.Resource;import java.util.ArrayList;import java.util.Date;import java.util.List;import java.util.Set;/** * @author zhangpei * @version 1.0 * @since jdk8 * <p> * 总分  平均分  每项平均分  每个选项被多少人选了 */@Servicepublic class StatisticsScoreService {    @Resource    private StatisticsScoreBusinessMapper statisticsScoreBusinessMapper;    @Resource    private EvaluationQuestionnaireBusinessMapper evaluationQuestionnaireBusinessMapper;    @Resource    private PublishQuestionBusinessMapper publishQuestionBusinessMapper;    @Resource    private RankBusinessMapper rankBusinessMapper;    @Resource    private StudentBusinessMapper studentBusinessMapper;    /**     * 通过教学任务id统计该任务的评教信息     *     * @param teachCourseId 教学任务id     */    @Transactional(rollbackFor = Exception.class)    public void statisticsByTeachCourse(String teachCourseId) throws JsonProcessingException {        PublishQuestionnaireModel selectParam = new PublishQuestionnaireModel();        selectParam.setTeachCourseId(teachCourseId);        PublishQuestionnaireModel questionnaireModel = publishQuestionBusinessMapper.selectOne(selectParam);        statistics(questionnaireModel.getId());    }    /**     * 统计一个发布的评教卷信息     *     * @param id 评教卷id     */    @Transactional(rollbackFor = Exception.class)    public void statistics(Integer id) throws JsonProcessingException {        PublishQuestionnaireModel model = publishQuestionBusinessMapper.selectByPrimaryKey(id);        statisticsAvgScore(model);        statisticsTotalScore(model);        statisticsItemAvgScore(model);        itemChoseAccount(model);    }    /**     * 统计一份问卷的总分     *     * @param publishQuestionnaireModel     * @return     */    public Integer statisticsTotalScore(PublishQuestionnaireModel publishQuestionnaireModel) {        PublishAttachInfo publishAttachInfo = PublishAttachInfo.getBean(publishQuestionnaireModel);        StatisticsScoreModel statisticsScoreModel = publishAttachInfo.statisticalAnswer(publishQuestionnaireModel);        return statisticsScoreBusinessMapper.insert(statisticsScoreModel);    }    /**     * 问卷的平均分     *     * @param publishQuestionnaireModel     * @return     */    public Integer statisticsAvgScore(PublishQuestionnaireModel publishQuestionnaireModel) {        PublishAttachInfo publishAttachInfo = PublishAttachInfo.getBean(publishQuestionnaireModel);        StatisticsScoreModel statisticsScoreModel = publishAttachInfo.statisticsAvgScore(publishQuestionnaireModel);        return statisticsScoreBusinessMapper.insert(statisticsScoreModel);    }    /**     * 问卷每一项的平均分     *     * @param publishQuestionnaireModel     * @return     */    public Integer statisticsItemAvgScore(PublishQuestionnaireModel publishQuestionnaireModel) throws JsonProcessingException {        PublishAttachInfo publishAttachInfo = PublishAttachInfo.getBean(publishQuestionnaireModel);        EvaluationQuestionnaireModel evaluationQuestionnaireModel = evaluationQuestionnaireBusinessMapper.selectByPrimaryKey(publishQuestionnaireModel.getQuestionnaireId());        EvaluationQuestionnaireContent contentBean = EvaluationQuestionnaireContent.getContentBean(evaluationQuestionnaireModel);        QuestionList questionList = QuestionList.toQuestionList(contentBean);        StatisticsScoreModel statisticsScoreModel = publishAttachInfo.statisticsItemScore(publishQuestionnaireModel, questionList);        return statisticsScoreBusinessMapper.insert(statisticsScoreModel);    }    /**     * 每一项选择的人数     *     * @param publishQuestionnaireModel     * @return     */    public Integer itemChoseAccount(PublishQuestionnaireModel publishQuestionnaireModel) throws JsonProcessingException {        PublishAttachInfo publishAttachInfo = PublishAttachInfo.getBean(publishQuestionnaireModel);        EvaluationQuestionnaireModel evaluationQuestionnaireModel = evaluationQuestionnaireBusinessMapper.selectByPrimaryKey(publishQuestionnaireModel.getQuestionnaireId());        EvaluationQuestionnaireContent contentBean = EvaluationQuestionnaireContent.getContentBean(evaluationQuestionnaireModel);        QuestionList questionList = QuestionList.toQuestionList(contentBean);        StatisticsScoreModel statisticsScoreModel = publishAttachInfo.statisticsItemChose(publishQuestionnaireModel, questionList);        return statisticsScoreBusinessMapper.insert(statisticsScoreModel);    }    /**     * 统计一个学院的排名     *     * @param facutyId 学院id     * @param year     年份     * @param semester 学期     * @return     */    public Integer statisticsDegree(Integer facutyId, String year, String semester) {        // 获取指定学院指定年份指定学期下发布的问卷        List<Integer> ids = publishQuestionBusinessMapper.selectIdsByCondition(facutyId, year, semester);        List<StatisticsScoreModel> list = statisticsScoreBusinessMapper.selectByCollection(ids);        list.sort((StatisticsScoreModel s1, StatisticsScoreModel s2) -> s2.getScore().compareTo(s1.getScore()));        RankModel rankModel = new RankModel();        rankModel.setFacultyId(facutyId);        rankModel.setYear(year);        rankModel.setSemester(semester);        rankModel.changeList(list);        rankModel.toContent();        return rankBusinessMapper.insert(rankModel);    }    /**     * 获取统计信息     *     * @param id   发布问卷的id     * @param type 统计类型     * @return     */    public StatisticsScoreModel getPQNa(Integer id, Integer type) {        return statisticsScoreBusinessMapper.getPQNa(id, type);    }    /**     * 发现评教卷的总分     *     * @param id 发布问卷的id     * @return 总分     */    public Double findPQNaTotalScore(Integer id) {        StatisticsScoreModel pqNa = getPQNa(id, 1);        Validator.validateNotNull(pqNa, "发布评教卷{}的统计总分不存在", id);        return pqNa.getScore();    }    /**     * 发现评教卷的平均分     *     * @param id 发布问卷的id     * @return 总分     */    public Double findPQNaAvgScore(Integer id) {        StatisticsScoreModel pqNa = getPQNa(id, 2);        Validator.validateNotNull(pqNa, "发布评教卷{}的统计的平均分不存在", id);        return pqNa.getScore();    }    /**     * 发现评教卷的题目的信息     *     * @param id 发布的评教卷自增id     * @return 统计信息     */    public StatisticsAttachInfor findTopicAttachInfor(Integer id) {        StatisticsScoreModel pqNa = getPQNa(id, 3);        Validator.validateNotNull(pqNa, "发布评教卷{}的统计的题目统计不存在", id);        return StatisticsAttachInfor.toStatisticsAttachInfor(pqNa);    }    /**     * 发现评教卷的题目的选项统计信息     *     * @param id 发布的评教卷自增id     * @return 统计信息     */    public StatisticsAttachInfor findOptionAttachInfor(Integer id) {        StatisticsScoreModel pqNa = getPQNa(id, 4);        Validator.validateNotNull(pqNa, "发布评教卷{}的统计的题目统计不存在", id);        return StatisticsAttachInfor.toStatisticsAttachInfor(pqNa);    }    public StatisticsQuestionVo findQuestionVo(Integer id) {        PublishQuestionnaireModel model = publishQuestionBusinessMapper.selectByPrimaryKey(id);        Validator.validateNotNull(model, "发布评教卷{}不存在", id);        Integer questionnaireId = model.getQuestionnaireId();        EvaluationQuestionnaireModel questionnaireModel = evaluationQuestionnaireBusinessMapper.selectByPrimaryKey(questionnaireId);        Validator.validateNotNull(questionnaireModel, "评教卷{}不存在", questionnaireId);        // 获取发布评教卷的统计信息        PublishAttachInfo attachInfo = PublishAttachInfo.getBean(model);        if (attachInfo.getAttend() == null) {            attachInfo.statistical();            model.setStatistics(JSON.toJSONString(attachInfo));            publishQuestionBusinessMapper.updateByPrimaryKeySelective(model);            attachInfo = PublishAttachInfo.getBean(model);        }        StatisticsQuestionVo statisticsQuestionVo = new StatisticsQuestionVo();        // 设置基础属性        statisticsQuestionVo.setTitle(questionnaireModel.getTitle());        Set<Integer> black = attachInfo.getBlack();        statisticsQuestionVo.setBlack(findStudentInfo(CollUtil.newArrayList(black)));        statisticsQuestionVo.setBlackNumber(black == null ? 0 : black.size());        // 设置平均分和总分        Double pqNaAvgScore = findPQNaAvgScore(id);        Double pqNaTotalScore = findPQNaTotalScore(id);        statisticsQuestionVo.setTotalScore(pqNaTotalScore);        statisticsQuestionVo.setAvgScore(pqNaAvgScore);        // 设置建议信息        statisticsQuestionVo.setAdviseList(attachInfo.getAdvice());        // 设置出席人数和计划人数        statisticsQuestionVo.setRealityAnswer(attachInfo.getAttend());        statisticsQuestionVo.setShouldAnswer(attachInfo.getPlan());        // 设置题目统计信息        StatisticsAttachInfor topicAttachInfor = findTopicAttachInfor(id);        StatisticsAttachInfor optionAttachInfor = findOptionAttachInfor(id);        List<StatisticsQuestionVo.TopicStatistics> topicStatisticsList                = StatisticsQuestionVo.createTopicStatisticsList(topicAttachInfor, optionAttachInfor);        statisticsQuestionVo.setTopicStatistics(topicStatisticsList);        return statisticsQuestionVo;    }    /**     * 填充学生信息     *     * @param accountIds 账号id信息     * @return 学生信息     */    public List<StatisticsQuestionVo.StudentInfo> findStudentInfo(List<Integer> accountIds) {        if (CollUtil.isEmpty(accountIds)) {            return new ArrayList<>();        }        List<StudentModel> studentModels = studentBusinessMapper.findStudentModelByAccountIds(ListUtils.lsitIdsToString(accountIds));        if (CollUtil.isEmpty(studentModels)) {            return new ArrayList<>();        }        List<StatisticsQuestionVo.StudentInfo> studentInfos = new ArrayList<>(studentModels.size());        studentModels.forEach(studentModel -> {            Integer accountId = studentModel.getAccountId();            String studentId = studentModel.getStudentId();            String name = studentModel.getName();            StatisticsQuestionVo.StudentInfo studentInfo = new StatisticsQuestionVo.StudentInfo();            studentInfo.setAccountId(accountId);            studentInfo.setName(name);            studentInfo.setStudentId(studentId);            studentInfos.add(studentInfo);        });        return studentInfos;    }    /**     * 填充一个题目的信息     *     * @param statisticsItem 题目信息     * @return 填充完毕的信息     */    public StatisticsQuestionVo.TopicStatistics createTopicStatistics(StatisticsItem statisticsItem) {        return null;    }}