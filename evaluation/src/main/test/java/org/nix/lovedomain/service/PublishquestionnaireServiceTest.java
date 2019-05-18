package org.nix.lovedomain.service;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.lovedomain.EvaluationApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

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
        Map<String,Object> map = publishquestionnaireService.factoryScoreStatistics(17);
        switch ((Integer) map.get("status")){
            case 1:
                System.out.println("该专业未发布问卷");
                break;
            case 2:
                System.out.println("问卷还未完全回收");
                break;
            case 3:
                System.out.println("获取统计结果完成:"+map.get("data").toString());
                break;
        }
    }

    /**
     * 专业维度的统计
     */
    @After
    public void testProfesssionScoreStatistics(){
        Map<String,Object> map = publishquestionnaireService.professionScoreStatistics(17);
        switch ((Integer) map.get("status")){
            case 1:
                System.out.println("该专业未发布问卷");
                break;
            case 2:
                System.out.println("问卷还未完全回收");
                break;
            case 3:
                System.out.println("获取统计结果完成:"+map.get("data").toString());
                break;
        }
    }
}
