package org.nix.lovedomain.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.lovedomain.EvaluationApplication;
import org.nix.lovedomain.dao.business.AccountBusinessMapper;
import org.nix.lovedomain.dao.business.TeacherBusinessMapper;
import org.nix.lovedomain.dao.model.AccountModel;
import org.nix.lovedomain.dao.model.TeacherModel;
import org.nix.lovedomain.web.controller.dto.CreateTeacherDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EvaluationApplication.class)
public class TeacherServiceTest {

    @Resource
    private TeacherService teacherService;
    @Resource
    private TeacherBusinessMapper teacherBusinessMapper;
    @Resource
    private AccountBusinessMapper accountBusinessMapper;

    @Test
    @Transactional
    public void createTeacher() {

        CreateTeacherDto dto = new CreateTeacherDto();
        dto.setEmail("zhangpe0312@qq.com");
        dto.setJobNumber("11503090207");
        dto.setName("张沛");
        dto.setPhone("18203085236");
        TeacherModel teacher = teacherService.createTeacher(dto);
        List<TeacherModel> teacherModels = teacherBusinessMapper.selectAll();
        List<AccountModel> accountModels = accountBusinessMapper.selectAll();
        System.out.println(teacherModels);
        System.out.println(accountModels);
        System.out.println(teacher);
    }
}