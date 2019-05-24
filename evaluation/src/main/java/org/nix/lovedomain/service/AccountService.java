package org.nix.lovedomain.service;

import cn.hutool.core.lang.Validator;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.AccountBusinessMapper;
import org.nix.lovedomain.dao.business.StudentBusinessMapper;
import org.nix.lovedomain.dao.business.TeacherBusinessMapper;
import org.nix.lovedomain.dao.model.AccountModel;
import org.nix.lovedomain.dao.model.StudentModel;
import org.nix.lovedomain.dao.model.TeacherModel;
import org.nix.lovedomain.service.vo.StudentVo;
import org.nix.lovedomain.service.vo.TeacherVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


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
    private AccountBusinessMapper accountBusinessMapper;

    @Resource
    private StudentBusinessMapper studentBusinessMapper;

    @Resource
    private TeacherBusinessMapper teacherBusinessMapper;

    /**
     * 通过登陆名找到账户信息
     *
     * @param loginName 登陆名（账号、电话、邮箱）
     * @return 账号信息
     */
    public AccountModel findUserByAccount(String loginName) {
        return accountBusinessMapper.findAccountByNumberOrPhoneOrEmail(loginName);
    }

    /**
     * 通过账户信息查找到学生信息
     *
     * @param userName 登陆名（账号、电话、邮箱）
     * @return 学生信息
     */
    public StudentVo findStudentByAccountName(String userName) {
        AccountModel studentAccount = findUserByAccount(userName);
        Validator.validateNotNull(studentAccount, "账号{}不存在", userName);
        StudentModel studentModel = new StudentModel();
        studentModel.setAccountId(studentAccount.getId());
        return StudentVo.studentToSimpleStudentVo(studentBusinessMapper.selectOne(studentModel));
    }

    /**
     * 通过账号信息查询老师信息
     *
     * @param userName 登陆名（账号、电话、邮箱）
     * @return 老师信息
     */
    public TeacherVo findTeacherByAccountName(String userName) {
        AccountModel teacherAccount = findUserByAccount(userName);
        Validator.validateNotNull(teacherAccount, "账号{}不存在", userName);
        TeacherModel teacherModel = new TeacherModel();
        teacherModel.setAccountId(teacherAccount.getId());
        return TeacherVo.teacherToSimpleTeacherVo(teacherBusinessMapper.selectOne(teacherModel));
    }
}
