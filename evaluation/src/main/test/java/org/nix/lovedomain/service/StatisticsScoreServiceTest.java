package org.nix.lovedomain.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.lovedomain.EvaluationApplication;
import org.nix.lovedomain.dao.model.PublishQuestionnaireModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
    StatisticsScoreService2 statisticsScoreService;

    @Autowired
    PublishQuestionnaireService publishQuestionnaireService;


    /**
     * 测试问卷总分统计
     */
//    @Test
    public void statisticsTotalScoreTest(){
        List<PublishQuestionnaireModel> pqlist = publishQuestionnaireService.batchQuireQuestion(Arrays.asList(107));
        statisticsScoreService.statisticsTotalScore(pqlist.get(0));
        statisticsAvgScoreTest();
        statisticsItemAvgScoreTest();
        itemChoseAccount();

    }

    /**
     * 测试问卷平均分统计
     */
    public void statisticsAvgScoreTest(){
        List<PublishQuestionnaireModel> pqlist = publishQuestionnaireService.batchQuireQuestion(Arrays.asList(107));
        statisticsScoreService.statisticsAvgScore(pqlist.get(0));
    }

    /**
     * 测试问卷每项平均分统计
     */
//    @Test
    public void statisticsItemAvgScoreTest(){
        try {
            List<PublishQuestionnaireModel> pqlist = publishQuestionnaireService.batchQuireQuestion(Arrays.asList(107));
            statisticsScoreService.statisticsItemAvgScore(pqlist.get(0));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 每道题的每个选项选择人次
     */
//    @Test
    public void itemChoseAccount(){
        try {
            List<PublishQuestionnaireModel> pqlist = publishQuestionnaireService.batchQuireQuestion(Arrays.asList(107));
            statisticsScoreService.itemChoseAccount(pqlist.get(0));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 统计排名
     */
    @Test
    public void statisticsDegree(){
           statisticsScoreService.statisticsDegree(202,"2019","第二学期");
    }
}
