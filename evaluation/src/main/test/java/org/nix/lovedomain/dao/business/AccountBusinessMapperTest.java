package org.nix.lovedomain.dao.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.lovedomain.EvaluationApplication;
import org.nix.lovedomain.dao.model.AccountRoleModel;
import org.nix.lovedomain.service.RoleService;
import org.nix.lovedomain.service.enums.RoleEnum;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EvaluationApplication.class)
public class AccountBusinessMapperTest {

    @Resource
    private AccountBusinessMapper accountBusinessMapper;

    @Resource
    private AccountRoleBusinessMapper accountRoleBusinessMapper;

    @Resource
    private RoleService roleService;

    @Test
    @Transactional
    public void findAccountIdByIdRange(){

        // 导入老师的权限
        List<Integer> accountIdByIdRange = accountBusinessMapper.findAccountIdByIdRange(0, 26602);
        List<AccountRoleModel> teacherRole = new ArrayList<>();
        Integer teacherRoleId = roleService.findRoleByName(RoleEnum.TEACHER.getName()).getId();
        accountIdByIdRange.forEach(integer -> {
            AccountRoleModel accountRoleModel = new AccountRoleModel();
            accountRoleModel.setAccountId(integer);
            accountRoleModel.setRoleId(teacherRoleId);
            accountRoleModel.setCreateTime(new Date());
            accountRoleModel.setUpdateTime(new Date());
            teacherRole.add(accountRoleModel);
        });
        accountRoleBusinessMapper.insertList(teacherRole);
        // 导入学生权限
        List<Integer> student = accountBusinessMapper.findAccountIdByIdRange(26602, 1000000);
        List<AccountRoleModel> studentRoles = new ArrayList<>();
        Integer studentRole = roleService.findRoleByName(RoleEnum.STUDENT.getName()).getId();
        student.forEach(integer -> {
            AccountRoleModel accountRoleModel = new AccountRoleModel();
            accountRoleModel.setAccountId(integer);
            accountRoleModel.setRoleId(studentRole);
            accountRoleModel.setCreateTime(new Date());
            accountRoleModel.setUpdateTime(new Date());
            studentRoles.add(accountRoleModel);
        });
        accountRoleBusinessMapper.insertList(studentRoles);

    }

}