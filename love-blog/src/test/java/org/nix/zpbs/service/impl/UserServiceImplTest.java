package org.nix.zpbs.service.impl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.nix.zpbs.LoveBlogApplication;
import org.nix.zpbs.exception.ServiceException;
import org.nix.zpbs.mapper.UserMapper;
import org.nix.zpbs.model.User;
import org.nix.zpbs.model.UserExample;
import org.nix.zpbs.pojo.dto.response.UserResponseDetailDTO;
import org.nix.zpbs.service.UserService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private UserServiceImpl service;

    @Mock
    private UserMapper userMapper;

    private String username = "zhangpei";
    private Long phone = 18203085236L;
    private String email = "zhangpe0312@qq.com";
    private ArrayList<User> t = new ArrayList<>();
    private User user = new User();
    @Before
    public void setUP() {
        userMapper = mock(UserMapper.class);
        service = new UserServiceImpl();
        service.setUserMapper(userMapper);
        // 1. 如果用户存在且用户名唯一则获取到
        user.setUserName(username);
        user.setUserPhone(phone);
        user.setUserEmail(email);
        t.add(user);

        when(userMapper.selectByExample(any(UserExample.class))).thenReturn(t);
    }

    @Test
    public void getUserByAccount() {
        // 2.实际校验
        User userNameAccount = service.getUserByAccount(username);
        assertEquals(userNameAccount.getUserName(), username);

        User phoneAccount = service.getUserByAccount(String.valueOf(phone));
        assertEquals(userNameAccount.getUserName(), username);

        User emailAccount = service.getUserByAccount(String.valueOf(email));
        assertEquals(userNameAccount.getUserName(), username);
    }

    @Test
    public void exceptionInputAccountNull(){
        // 期望后续的值是抛出异常的输入
        exception.expect(ServiceException.class);
        exception.expectMessage("无效的用户名或者密码");
        User nullAccount = service.getUserByAccount(null);
        fail("执行异常，该出不应当出现运行结果,因为账户为空必须抛出异常");
    }

    @Test
    public void exceptionInputAccountNoExit(){
        // 期望后续的值是抛出异常的输入
        exception.expect(ServiceException.class);
        exception.expectMessage("无效的用户名或者密码");
        // 不存在的账号
        when(userMapper.selectByExample(any(UserExample.class))).thenReturn(null);
        User bisha = service.getUserByAccount("bisha");
        fail("执行异常，该出不应当出现运行结果，账户不存在必须抛出异常");
    }

    @Test
    public void exceptionInputAccountHasMultiple(){
        // 期望后续的值是抛出异常的输入
        exception.expect(ServiceException.class);
        exception.expectMessage("无效的用户名或者密码");
        // 账号名重复
        t.add(user);
        when(userMapper.selectByExample(any(UserExample.class))).thenReturn(t);
        User bisha = service.getUserByAccount(username);
        fail("执行异常，该出不应当出现运行结果，账户不存在必须抛出异常");
    }

    @Test
    public void getUserDetailDtoByAccount() {
        UserResponseDetailDTO userDto = service.getUserDetailDtoByAccount(username);
        System.out.println(userDto);
        assertEquals(username, userDto.getUserName());
    }

    @Test
    public void getPowersByUserId() {

    }
}