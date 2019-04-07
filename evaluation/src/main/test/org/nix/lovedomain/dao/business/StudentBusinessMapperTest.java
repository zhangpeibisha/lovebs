package org.nix.lovedomain.dao.business;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.lovedomain.EvaluationApplication;
import org.nix.lovedomain.dao.business.page.StudentPageInquire;
import org.nix.lovedomain.model.Student;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

@Slf4j
@SpringBootTest(classes = EvaluationApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentBusinessMapperTest {

    @Resource
    private StudentBusinessMapper studentBusinessMapper;

    @Test
    public void findStudentPage() {
        StudentPageInquire pageInquire = new StudentPageInquire();
        pageInquire.setQuireField("studentid");
        pageInquire.setQuireValue("11503");
        pageInquire.setPage(1, 10);
        pageInquire.setBlurry(true);
        List<Student> studentPage = studentBusinessMapper.findStudentPage(pageInquire);
        log.info("获取到的数据为:" + JSONUtil.toJsonStr(studentPage));
        assertEquals(studentPage.size(), 1);
        assertEquals("11503090207", studentPage.get(0).getStudentid());

        pageInquire.setBlurry(false);
        studentPage = studentBusinessMapper.findStudentPage(pageInquire);
        assertEquals(0, studentPage.size());

        pageInquire.setQuireValue("11503090207");
        studentPage = studentBusinessMapper.findStudentPage(pageInquire);
        assertEquals(studentPage.size(), 1);
        assertEquals("11503090207", studentPage.get(0).getStudentid());
    }
}