package org.nix.lovedomain.service;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.lovedomain.EvaluationApplication;
import org.nix.lovedomain.model.Statisticsscore;
import org.nix.lovedomain.service.PublishquestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @version 1.0
 * @anthor on 2019/5/14
 * @since jdk8
 */
@SpringBootTest(classes = EvaluationApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PublishquestionnaireServiceTest {

    @Autowired
    PublishquestionnaireService publishquestionnaireService;


    /**
     * 测试学院维度的统计
     */
    @Test
    public void testFactoryScoreStatistics(){
        Statisticsscore statisticsscore = publishquestionnaireService.factoryScoreStatistics(17);
        System.out.println(statisticsscore.toString());
    }

    /**
     * 专业维度的统计
     */
    @After
    public void testProfesssionScoreStatistics(){
        Statisticsscore statisticsscore = publishquestionnaireService.professionScoreStatistics(11);
        System.out.println(statisticsscore.toString());
    }
}
