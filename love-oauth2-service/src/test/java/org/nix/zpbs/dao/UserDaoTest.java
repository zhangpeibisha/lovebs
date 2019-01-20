package org.nix.zpbs.dao;

import cn.hutool.json.JSONUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.zpbs.LoveOAuth2Application;
import org.nix.zpbs.mapper.UserMapper;
import org.nix.zpbs.model.User;
import org.nix.zpbs.model.UserExample;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/20
 */
@SpringBootTest(classes = LoveOAuth2Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void getUserDetail() {
        String username = "zhangpei";
        Assert.assertNotNull(getUserDetailBy(username));
        String phone = "18203085236";
        Assert.assertNotNull(getUserDetailBy(phone));
        String email = "zhangpe0312@qq.com";
        Assert.assertNotNull(getUserDetailBy(email));
    }

    public User getUserDetailBy(String account) {
        UserExample example = new UserExample();
        example.or().andUserNameEqualTo(account);
        try {
            // 如果抛异常则不会加入条件判断
            long value = Long.parseLong(account);
            example.or().andUserPhoneEqualTo(value);
        } catch (NumberFormatException e) {
            // 不是数字抛异常，忽略处理
        }
        example.or().andUserEmailEqualTo(account);
        List<User> users = userMapper.selectByExample(example);
        System.out.println(JSONUtil.toJsonStr(users));
        if (users == null)
            return null;
        return users.get(0);
    }

}
