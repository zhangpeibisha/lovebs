package org.nix.lovedomain.service;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.lovedomain.EvaluationApplication;
import org.nix.lovedomain.dao.business.json.winding.StatisticsAttachInfor;
import org.nix.lovedomain.dao.model.PublishQuestionnaireModel;
import org.nix.lovedomain.service.vo.StatisticsQuestionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @anthor on 2019/5/26
 * @since jdk8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EvaluationApplication.class)
public class StatisticsScoreServiceTest {

    @Autowired
    StatisticsScoreService statisticsScoreService;

    @Autowired
    PublishQuestionnaireService publishQuestionnaireService;


    /**
     * 测试问卷总分统计
     */
//    @Test
    public void statisticsTotalScoreTest() {
        List<PublishQuestionnaireModel> pqlist = publishQuestionnaireService.batchQuireQuestion(Arrays.asList(107));
        statisticsScoreService.statisticsTotalScore(pqlist.get(0));
        statisticsAvgScoreTest();
        statisticsItemAvgScoreTest();
        itemChoseAccount();

    }

    /**
     * 测试问卷平均分统计
     */
    public void statisticsAvgScoreTest() {
        List<PublishQuestionnaireModel> pqlist = publishQuestionnaireService.batchQuireQuestion(Arrays.asList(107));
        statisticsScoreService.statisticsAvgScore(pqlist.get(0));
    }

    /**
     * 测试问卷每项平均分统计
     */
//    @Test
    public void statisticsItemAvgScoreTest() {
        try {
            List<PublishQuestionnaireModel> pqlist = publishQuestionnaireService.batchQuireQuestion(Arrays.asList(107));
            statisticsScoreService.statisticsItemAvgScore(pqlist.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 每道题的每个选项选择人次
     */
//    @Test
    public void itemChoseAccount() {
        try {
            List<PublishQuestionnaireModel> pqlist = publishQuestionnaireService.batchQuireQuestion(Arrays.asList(107));
            statisticsScoreService.itemChoseAccount(pqlist.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 统计排名
     */
//    @Test
    public void statisticsDegree() {
        statisticsScoreService.statisticsDegree(202, "2019", "第二学期");
    }

    //    @Test
    public void statistics() {
        StatisticsQuestionVo questionVo = statisticsScoreService.findQuestionVo(107);
        System.out.println(JSON.toJSONString(questionVo));
    }

    //    @Test
    public void findTopicInfo() {
//        StatisticsAttachInfor topicAttachInfor = statisticsScoreService.findTopicAttachInfor(106);
//        System.out.println("===============发现评教卷的题目的信息======================");
//        System.err.println(JSON.toJSONString(topicAttachInfor));
//        System.out.println("===============发现评教卷的题目的信息======================");


        // 查看自己的分数
        System.out.println("===============================================");
        StatisticsQuestionVo questionVo = statisticsScoreService.findQuestionVo(106);
        System.err.println(JSON.toJSONString(questionVo));


        // 统计题目分数
//        topicAttachInfor = statisticsScoreService.findOptionAttachInfor(106);
//        System.out.println("==============发现评教卷的题目的选项统计信息=======================");
//        System.err.println(JSON.toJSONString(topicAttachInfor));


    }

    @Test
    @Transactional
    public void statisticsByTeachCourse() throws JsonProcessingException {
        statisticsScoreService.statisticsByTeachCourse("20170809");
        findTopicInfo();
    }
}
