package org.nix.zpbs.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.zpbs.LoveBlogApplication;
import org.nix.zpbs.mapper.UserMapper;
import org.nix.zpbs.model.User;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * 测试用户功能dao层
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LoveBlogApplication.class)
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Resource
    private UserMapper userMapper;

    @Test
    public void checkAccountAndPassword() {

    }

    @Test
    public void insert() {
        User record = new User();
        record.setGroupId(1L);
        record.setUserName("zhangpei");
        record.setUserEmail("bisha0312@qq.com");
        record.setUserPwd("bisha520");
        record.setUserPhone(18203085236L);
        record.setUserRegisterTime(System.currentTimeMillis());
        record.setUserRegisterIp("127.0.0.1");
        int insert = userMapper.insert(record);
        assertEquals(1, insert);


    }

    /**
     * 注册使用这个方法
     */
    @Test
    public void inserSelective() {
        User record = new User();
        record.setGroupId(1L);
        record.setUserName("bisha");
        record.setUserEmail("bisha0312@qq.com");
        record.setUserPwd("bisha520");
        record.setUserPhone(18203085236L);
        record.setUserRegisterTime(System.currentTimeMillis());
        record.setUserRegisterIp("127.0.0.1");
        userMapper.insertSelective(record);
    }
}