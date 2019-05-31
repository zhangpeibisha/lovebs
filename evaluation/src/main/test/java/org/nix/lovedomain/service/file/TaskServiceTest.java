package org.nix.lovedomain.service.file;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.lovedomain.EvaluationApplication;
import org.nix.lovedomain.dao.business.AccountBusinessMapper;
import org.nix.lovedomain.dao.business.StudentCourseBusinessMapper;
import org.nix.lovedomain.dao.model.AccountModel;
import org.nix.lovedomain.dao.model.StudentCourseModel;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EvaluationApplication.class)
public class TaskServiceTest {

    @Resource
    private TaskService taskService;

    @Resource
    private AccountBusinessMapper accountBusinessMapper;

    @Resource
    private StudentCourseBusinessMapper studentCourseBusinessMapper;

    private String bash = "C:/WorkPace/GIT/lovebs/lovebs/doc/excel/";

    @Test
    @Transactional
    public void insertTeachTask() {
        String path = bash + "18-19(2)任务书1205.xls";
//        taskService.insertTeachTask(path);
//        taskService.insertStudentTask(path);
//        List<AccountModel> accountModels = accountBusinessMapper.selectAll();
//        taskService.insertPublishQuestionnaire(path,accountModels.get(0).getId());
    }

    @Test
    @Transactional
    public void updateStudentCourseScore(){
        String path = bash + "给学生的课程上分.xlsx";
//        taskService.updateStudentCourseScore(path);
//        StudentCourseModel studentCourseModel = studentCourseBusinessMapper.selectByPrimaryKey(3793);
//        System.out.println(studentCourseModel);
    }
}