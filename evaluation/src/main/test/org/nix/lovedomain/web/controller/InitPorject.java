package org.nix.lovedomain.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.lovedomain.EvaluationApplication;
import org.nix.lovedomain.dao.mapper.*;
import org.nix.lovedomain.model.*;
import org.nix.lovedomain.model.Class;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author zhangpei
 * @version 1.0
 * @description 初始化项目
 * @date 2019/4/7
 */
@SpringBootTest(classes = EvaluationApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class InitPorject {

    @Resource
    private A a;

    @Test
    public void studentTest() {
//        Student student = a.createStudent();
//        System.out.println(student);
        System.out.println("hello world");
//        a.createStudentOne();
    }


}

@Component
class A {

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private FacultyMapper facultyMapper;

    @Resource
    private ProfessionMapper professionMapper;

    @Resource
    private ClassMapper classMapper;

    @Resource
    private StudentMapper studentMapper;

    @Transactional(rollbackFor = Exception.class)
    public Student createStudent() {

        Student student = new Student();
        student.setAccountid(createAccount().getId());
        student.setEmail("zhangpe0312@qq.com");
        student.setPhone("18203085236");
        student.setStudentid("11503090207");
        student.setClassid(createClass().getId());
        student.setName("张沛");
        studentMapper.insertSelective(student);

        return student;
    }

    @Transactional(rollbackFor = Exception.class)
    public Student createStudentOne() {

        Student student = new Student();
        student.setAccountid(8);
        student.setEmail("bisha@qq.com");
        student.setPhone("15334503852");
        student.setStudentid("11503090209");
        student.setClassid(1);
        student.setName("毕沙");
        studentMapper.insertSelective(student);

        return student;
    }

    @Transactional(rollbackFor = Exception.class)
    public Class createClass() {
        Class classzz = new Class();
        Integer id = createProfession().getId();
        classzz.setProfessionid(id);
        classMapper.insertSelective(classzz);
        ClassExample example = new ClassExample();
        example.createCriteria().andProfessionidEqualTo(id);
        return (org.nix.lovedomain.model.Class)classMapper.selectByExample(example).get(0);
    }

    @Transactional(rollbackFor = Exception.class)
    public Profession createProfession() {
        // 专业
        Profession profession = new Profession();
        profession.setCoding("66666");
        profession.setFacultyid(createFaculty().getId());
        profession.setName("网络工程");
        professionMapper.insertSelective(profession);
        ProfessionExample example = new ProfessionExample();
        example.createCriteria().andNameEqualTo("网络工程");
        return professionMapper.selectByExample(example).get(0);
    }

    @Transactional(rollbackFor = Exception.class)
    public Faculty createFaculty() {
        // 学院
        Faculty faculty = new Faculty();
        faculty.setCoding("jsj666");
        faculty.setName("计算机科学与工程学院");
        facultyMapper.insertSelective(faculty);
        FacultyExample example = new FacultyExample();
        example.createCriteria().andNameEqualTo("计算机科学与工程学院");
        return facultyMapper.selectByExample(example).get(0);
    }


    @Transactional(rollbackFor = Exception.class)
    public Account createAccount() {
        Account account = new Account();
        account.setPassword("123456");
        account.setCreatetime(new Date());
        account.setNumbering("11503090207");
        account.setPhone("18203085236");
        accountMapper.insertSelective(account);
        AccountExample example = new AccountExample();
        example.createCriteria().andNumberingEqualTo("11503090207");
        return accountMapper.selectByExample(example).get(0);
    }
}
