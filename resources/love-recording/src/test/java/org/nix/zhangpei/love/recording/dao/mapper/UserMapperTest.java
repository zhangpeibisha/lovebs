package org.nix.zhangpei.love.recording.dao.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.zhangpei.love.recording.RecordingApplication;
import org.nix.zhangpei.love.recording.dao.po.UserPO;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RecordingApplication.class)
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    private UserPO user;

    @Before
    public void setUp() throws Exception {
        user = new UserPO();
        user.setPassword("123456");
        user.setUsername("wifi");
        user.setPhone("18084040317");
        user.baseCreate();
    }

    @Test
    public void insert(){
        int insert = userMapper.insert(user);
        assertEquals(1,insert);
    }

    @Test
    public void update(){
        UserPO userPO = userMapper.selectByPrimaryKey(1);
        assertEquals( 1L,(long)userPO.getId());
        userPO.setPhone("zhangpeipei");
        userPO.baseUpdate();
        int i = userMapper.updateByPrimaryKey(userPO);
        assertEquals(1,i);
    }
}