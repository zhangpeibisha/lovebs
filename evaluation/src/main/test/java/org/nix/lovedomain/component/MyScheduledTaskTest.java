
//package org.nix.lovedomain.component;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.nix.lovedomain.EvaluationApplication;
//import org.nix.lovedomain.dao.mapper.PublishquestionnaireMapper;
//import org.nix.lovedomain.model.Publishquestionnaire;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import javax.annotation.Resource;
//
//@SpringBootTest(classes = EvaluationApplication.class)
//@RunWith(SpringJUnit4ClassRunner.class)
//public class MyScheduledTaskTest {
//
//    @Autowired
//    private PublishQuestionScheduledTask scheduledTask;
//
//    @Resource
//    private PublishquestionnaireMapper publishquestionnaireMapper;
//
//    @Test
//    public void runDistributionTask() throws Exception {
//        Publishquestionnaire publishquestionnaire
//                = publishquestionnaireMapper.selectByPrimaryKey(5);
//        scheduledTask.runDistributionTask(publishquestionnaire);
//    }
//}

package org.nix.lovedomain.component;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.lovedomain.EvaluationApplication;
import org.nix.lovedomain.dao.mapper.PublishquestionnaireMapper;
import org.nix.lovedomain.model.Publishquestionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = EvaluationApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MyScheduledTaskTest {

    @Autowired
    private PublishQuestionScheduledTask scheduledTask;

    @Resource
    private PublishquestionnaireMapper publishquestionnaireMapper;

    @Test
    public void runDistributionTask() throws Exception {
        Publishquestionnaire publishquestionnaire
                = publishquestionnaireMapper.selectByPrimaryKey(5);
        scheduledTask.runDistributionTask(publishquestionnaire);
    }

    /**
     * 回收问卷并按不同的维度统计问卷
     * @throws Exception
     */
    @Test
    public void statistcisTask() throws Exception {

        Publishquestionnaire publishquestionnaire
                = publishquestionnaireMapper.selectByPrimaryKey(215);
        scheduledTask.runRecoverTask(publishquestionnaire);
    }
}
