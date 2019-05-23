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
    @Transactional
    public void init() {
        commonService.insertFacultyAndProfession(basePath + "学院-专业-班级信息表.xls");
        commonService.fillInfo(basePath + "老师-专业-班级的信息表.xls");
    }
}