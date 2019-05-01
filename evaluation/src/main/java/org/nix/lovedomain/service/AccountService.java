package org.nix.lovedomain.service;

import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.mapper.AccountMapper;
import org.nix.lovedomain.dao.mapper.StudentMapper;
import org.nix.lovedomain.dao.mapper.TeacherMapper;
import org.nix.lovedomain.model.*;
import org.nix.lovedomain.service.vo.StudentVo;
import org.nix.lovedomain.service.vo.TeacherVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author zhangpei
 * @version 1.0
 * @description 账户服务
 * @date 2019/3/5
 */
@Service
@Slf4j
public class AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private TeacherMapper teacherMapper;

    public Account findUserByAccount(String username) {
        if (username == null) {
            throw new ServiceException("用户名不能为空");
        }
        AccountExample example = new AccountExample();

        AccountExample.Criteria numbering = example.createCriteria();
        numbering.andNumberingEqualTo(username);

        AccountExample.Criteria phone = example.createCriteria();
        phone.andPhoneEqualTo(username);

        AccountExample.Criteria email = example.createCriteria();
        email.andEmailEqualTo(username);

        example.or(numbering);
        example.or(phone);
        example.or(email);

        List<Account> accounts = accountMapper.selectByExample(example);
        if (accounts.size() == 1) {
            return accounts.get(0);
        }
        throw new ServiceException("通过用户名" + username + "查询用户信息失败");
    }

    /**
     * 通过账户信息查找到学生信息
     *
     * @param userName
     * @return
     */
    public StudentVo findStudentByAccountName(String userName) {
        Account userByAccount = findUserByAccount(userName);
        if (userByAccount == null) {
            return null;
        }
        Integer accountId = userByAccount.getId();
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andAccountidEqualTo(accountId);
        List<Student> students = studentMapper.selectByExample(studentExample);
        if (CollUtil.isEmpty(students) || students.size() != 1) {
            return null;
        }
        Student student = students.get(0);
        return StudentVo.studentToSimpleStudentVo(student);
    }

    /**
     * 通过账号信息查询老师信息
     *
     * @param userName
     * @return
     */
    public TeacherVo findTeacherByAccountName(String userName) {
        Account userByAccount = findUserByAccount(userName);
        if (userByAccount == null) {
            return null;
        }
        Integer accountId = userByAccount.getId();
        TeacherExample studentExample = new TeacherExample();
        studentExample.createCriteria().andAccountidEqualTo(accountId);
        List<Teacher> teachers = teacherMapper.selectByExample(studentExample);
        if (CollUtil.isEmpty(teachers) || teachers.size() != 1) {
            return null;
        }
        return TeacherVo.teacherToSimpleTeacherVo(teachers.get(0));
    }
}
