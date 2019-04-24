package org.nix.lovedomain.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.lovedomain.EvaluationApplication;
import org.nix.lovedomain.dao.business.page.StudentPageInquire;
import org.nix.lovedomain.model.Student;
import org.nix.lovedomain.service.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EvaluationApplication.class)
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void studentSimpleList() {
        StudentPageInquire pageInquire = new StudentPageInquire();
        PageVo<Student> studentPageVo = studentService.studentSimpleList(pageInquire);
        System.out.println(studentPageVo);

        pageInquire.setBlurry(true);
        pageInquire.setQuireField("studentid");
        pageInquire.setQuireValue("1150309");
        studentPageVo = studentService.studentSimpleList(pageInquire);
        System.out.println(studentPageVo);


        pageInquire.setBlurry(false);
        pageInquire.setQuireField("studentid");
        pageInquire.setQuireValue("1150309");
        studentPageVo = studentService.studentSimpleList(pageInquire);
        System.out.println(studentPageVo);

        pageInquire.setBlurry(false);
        pageInquire.setQuireField("studentid");
        pageInquire.setQuireValue("11503090207");
        studentPageVo = studentService.studentSimpleList(pageInquire);
        System.out.println(studentPageVo);

    }

    @Test
    public void studentVoSimpleList() {
    }
}