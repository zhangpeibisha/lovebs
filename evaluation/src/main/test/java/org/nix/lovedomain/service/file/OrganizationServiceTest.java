package org.nix.lovedomain.service.file;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.lovedomain.EvaluationApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EvaluationApplication.class)
public class OrganizationServiceTest {

    @Resource
    private OrganizationService organizationService;

    @Resource
    private TaskService taskService;

    private String bash = "C:/WorkPace/GIT/lovebs/lovebs/doc/excel/";

    @Test
//    @Transactional
    public void insertFacultyAndProfession() {
        organizationService.insertFaculty(bash + "学院.xlsx");
        organizationService.insertProfession(bash + "专业.xlsx");
        organizationService.insertClass(bash + "班级.xlsx");
        organizationService.insertTeacher(bash + "老师.xlsx");
        taskService.insertCourse(bash+"课程.xlsx");
    }

    @Test
//    @Transactional
    public void fillInfo() {
        String path = bash + "学院、专业、班级添加老师.xlsx";
        organizationService.classInsertTeacher(path);
        organizationService.professionInsertTeacher(path);
    }
}