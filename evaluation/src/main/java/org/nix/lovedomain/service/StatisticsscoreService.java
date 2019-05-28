package org.nix.lovedomain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.nix.lovedomain.dao.business.EvaluationQuestionnaireBusinessMapper;
import org.nix.lovedomain.dao.business.PublishQuestionBusinessMapper;
import org.nix.lovedomain.dao.business.RankBusinessMapper;
import org.nix.lovedomain.dao.business.StatisticsScoreBusinessMapper;
import org.nix.lovedomain.dao.business.json.question.EvaluationQuestionnaireContent;
import org.nix.lovedomain.dao.business.json.winding.PublishAttachInfo;
import org.nix.lovedomain.dao.business.json.winding.QuestionList;
import org.nix.lovedomain.dao.model.EvaluationQuestionnaireModel;
import org.nix.lovedomain.dao.model.PublishQuestionnaireModel;
import org.nix.lovedomain.dao.model.RankModel;
import org.nix.lovedomain.dao.model.StatisticsScoreModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version 1.0
 * @anthor  on 2019/4/19
 * @since jdk8
 *
 *总分  平均分  每项平均分  每个选项被多少人选了
 *
 */
@Service
@Transactional
public class StatisticsScoreService {

    @Resource
    StatisticsScoreBusinessMapper statisticsScoreBusinessMapper;

    @Resource
    EvaluationQuestionnaireBusinessMapper evaluationQuestionnaireBusinessMapper;

    @Resource
    PublishQuestionBusinessMapper publishQuestionBusinessMapper;

    @Resource
    RankBusinessMapper rankBusinessMapper;

    /**
     *统计一份问卷的总分
     * @param publishQuestionnaireModel
     * @return
     */
    public Integer statisticsTotalScore(PublishQuestionnaireModel publishQuestionnaireModel){
        PublishAttachInfo publishAttachInfo = PublishAttachInfo.getBean(publishQuestionnaireModel);
        StatisticsScoreModel statisticsScoreModel =  publishAttachInfo.statisticalAnswer(publishQuestionnaireModel);
        return statisticsScoreBusinessMapper.insert(statisticsScoreModel);

    }

    /**
     * 问卷的平均分
     * @param publishQuestionnaireModel
     * @return
     */
    public Integer statisticsAvgScore(PublishQuestionnaireModel publishQuestionnaireModel){
        PublishAttachInfo publishAttachInfo = PublishAttachInfo.getBean(publishQuestionnaireModel);
        StatisticsScoreModel statisticsScoreModel =  publishAttachInfo.statisticsAvgScore(publishQuestionnaireModel);
        return statisticsScoreBusinessMapper.insert(statisticsScoreModel);
    }

    /**
     * 问卷每一项的平均分
     * @param publishQuestionnaireModel
     * @return
     */
    public Integer statisticsItemAvgScore(PublishQuestionnaireModel publishQuestionnaireModel) throws JsonProcessingException {
        PublishAttachInfo publishAttachInfo = PublishAttachInfo.getBean(publishQuestionnaireModel);
        EvaluationQuestionnaireModel evaluationQuestionnaireModel = evaluationQuestionnaireBusinessMapper.selectByPrimaryKey(publishQuestionnaireModel.getQuestionnaireId());
        EvaluationQuestionnaireContent contentBean = EvaluationQuestionnaireContent.getContentBean(evaluationQuestionnaireModel);
        QuestionList questionList = QuestionList.toQuestionList(contentBean);
        StatisticsScoreModel statisticsScoreModel =  publishAttachInfo.statisticsItemScore(publishQuestionnaireModel,questionList);
        return statisticsScoreBusinessMapper.insert(statisticsScoreModel);
    }

    /**
     * 每一项选择的人数
     * @param publishQuestionnaireModel
     * @return
     */
    public Integer itemChoseAccount(PublishQuestionnaireModel publishQuestionnaireModel) throws JsonProcessingException {
        PublishAttachInfo publishAttachInfo = PublishAttachInfo.getBean(publishQuestionnaireModel);
        EvaluationQuestionnaireModel evaluationQuestionnaireModel = evaluationQuestionnaireBusinessMapper.selectByPrimaryKey(publishQuestionnaireModel.getQuestionnaireId());
        EvaluationQuestionnaireContent contentBean = EvaluationQuestionnaireContent.getContentBean(evaluationQuestionnaireModel);
        QuestionList questionList = QuestionList.toQuestionList(contentBean);
        StatisticsScoreModel statisticsScoreModel =  publishAttachInfo.statisticsItemChose(publishQuestionnaireModel,questionList);
        return statisticsScoreBusinessMapper.insert(statisticsScoreModel);
    }

    /**
     * 统计一个学院的排名
     * @param facutyId   学院id
     * @param year 年份
     * @param semester 学期
     * @return
     */
    public Integer statisticsDegree(Integer facutyId,String year,String semester){
        // 获取指定学院指定年份指定学期下发布的问卷
        List<Integer> ids = publishQuestionBusinessMapper.selectIdsByCondition(facutyId,year,semester);
        List<StatisticsScoreModel> list = statisticsScoreBusinessMapper.selectByCollection(ids);
        list.sort((StatisticsScoreModel s1,StatisticsScoreModel s2) -> s2.getScore().compareTo(s1.getScore()));
        RankModel rankModel = new RankModel();
        rankModel.setFacultyId(facutyId);
        rankModel.setYear(year);
        rankModel.setSemester(semester);
        rankModel.changeList(list);
        rankModel.toContent();
        return  rankBusinessMapper.insert(rankModel);
    }

    /**
     * 获取统计信息
     * @param id  发布问卷的id
     * @param type 统计类型
     * @return
     */
    public StatisticsScoreModel getPQNa(Integer id,Integer type){
        return statisticsScoreBusinessMapper.getPQNa(id,type);
    }


}
