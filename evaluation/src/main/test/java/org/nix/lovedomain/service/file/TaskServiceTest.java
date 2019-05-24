package org.nix.lovedomain.service.file;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.lovedomain.EvaluationApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EvaluationApplication.class)
public class TaskServiceTest {

    @Resource
    private TaskService taskService;

    private String bash = "C:/WorkPace/GIT/lovebs/lovebs/doc/excel/";

    @Test
    @Transactional
    public void insertTeachTask() {
        taskService.insertTeachTask(bash+"18-19(2)任务书1205.xls");
    }
}