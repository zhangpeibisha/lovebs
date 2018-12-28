package org.nix.zhangpei.love.recording.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.zhangpei.love.recording.RecordingApplication;
import org.nix.zhangpei.love.recording.dao.po.UserPO;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RecordingApplication.class)
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void add() {
        UserPO userPO = new UserPO();
        userPO.setUsername("bisha");
        userPO.setPhone("15334503852");
        userPO.setPassword("zhangpei520");
        userMapper.add(userPO);
    }
}