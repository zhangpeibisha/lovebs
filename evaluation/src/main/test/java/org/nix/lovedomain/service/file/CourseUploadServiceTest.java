package org.nix.lovedomain.service.file;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.lovedomain.EvaluationApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EvaluationApplication.class)
public class CourseUploadServiceTest {

    @Resource
    private CourseUploadService courseUploadService;

    @Test
    public void insertCourseInfo() {
        String path = "C:\\Users\\Lenovo\\Desktop\\毕业设计\\论文\\评教系统开发设计资料\\系统基本数据excel\\课程信息.xls";
        courseUploadService.insertCourseInfo(path);

    }
}