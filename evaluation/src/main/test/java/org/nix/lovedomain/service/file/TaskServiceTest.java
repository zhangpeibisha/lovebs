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

    private String basePath = "C:\\Users\\Lenovo\\Desktop\\毕业设计\\论文\\评教系统开发设计资料\\系统基本数据excel\\系统中的规定格式excel\\";


    @Test
    @Transactional
    public void insertCourse() {

        taskService.insertCourse(basePath + "导入课程信息.xlsx");

    }
}