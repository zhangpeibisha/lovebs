package org.nix.lovedomain.component;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.lovedomain.EvaluationApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @anthor on 2019/4/24
 * @since jdk8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EvaluationApplication.class)
public class ScheduledTaskTest {

    @Resource
    ScheduledTask scheduledTask;
    @Test
    public void test(){
       scheduledTask.excuteTask();
    }
}
