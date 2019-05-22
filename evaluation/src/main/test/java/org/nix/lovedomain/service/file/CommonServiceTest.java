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
public class CommonServiceTest {

    @Resource
    private CommonService commonService;

    private String basePath = "C:\\Users\\Lenovo\\Desktop\\毕业设计\\论文\\评教系统开发设计资料\\系统基本数据excel\\";

    @Test
    public void insertTeacher() {
        commonService.insertTeacher(basePath+"老师信息.xls");
    }

    @Test
    public void insertProfession(){
        commonService.insertProfession(basePath+"专业信息.xls");
    }

    @Test
    public void insertClass(){
        commonService.insertClass(basePath+"班级信息.xls");
    }

    @Test
//    @Transactional
    public void init(){
        commonService.insertProfession(basePath+"专业信息.xls");
        commonService.insertTeacher(basePath+"老师信息.xls");
        commonService.insertClass(basePath+"班级信息.xls");
    }
}