package org.nix.zpbs.service.impl;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.nix.zpbs.LoveBlogApplication;
import org.nix.zpbs.dto.response.UserResponseDetailDTO;
import org.nix.zpbs.service.UserService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.rmi.server.ExportException;

import static org.junit.Assert.*;

@SpringBootTest(classes = LoveBlogApplication.class)
@RunWith(value = SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

    private ExpectedException exception = ExpectedException.none();

    @Resource
    private UserService service;

    @Test
    public void getUserByAccount() {
        UserResponseDetailDTO username = service.getUserByAccount("zhangpei");
        System.out.println(username);
        UserResponseDetailDTO phone = service.getUserByAccount("18203085236");
        exception.expect(ServiceException.class);
        exception.expectMessage("无效的用户名或者密码");
        UserResponseDetailDTO nullValue = service.getUserByAccount(null);
        exception.expect(ServiceException.class);
        exception.expectMessage("无效的用户名或者密码");
    }
}