package org.nix.zhangpei.account.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.zhangpei.account.AccountApplication;
import org.nix.zhangpei.account.model.RolePO;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AccountApplication.class)
public class RoleMapperTest {

    @Resource
    private RoleMapper roleMapper;

    @Test
    public void add() {
        RolePO rolePO = new RolePO();
        rolePO.setName("老婆大人");
        rolePO.setDescription("最高级领导");
        roleMapper.add(rolePO);
    }
}