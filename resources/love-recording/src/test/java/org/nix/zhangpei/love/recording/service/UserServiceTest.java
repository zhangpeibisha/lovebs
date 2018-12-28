package org.nix.zhangpei.love.recording.service;

import org.junit.Before;
import org.junit.Test;
import org.nix.zhangpei.love.recording.service.vo.UserVO;
import static  org.junit.Assert.*;

public class UserServiceTest {

    private UserServiceMock userService;

    @Before
    public   void before(){
        userService = new UserServiceMock();
    }

    @Test
    public void findUserByUserName() {
        UserVO zhangpei = userService.findUserByUserName("zhangpei");
        assertEquals(zhangpei.getUsername(),"zhangpei");
    }

    @Test
    public void findUserByUserPhone() {
        UserVO zhangpei = userService.findUserByUserPhone("18203085236");
        assertEquals(zhangpei.getUsername(),"18203085236");
    }

    @Test
    public void loginByUserName() {
        Long value = 1L;
        int i = value.compareTo(null);
    }

    @Test
    public void loginByUserPhone() {
    }

    @Test
    public void registerUser() {
    }

    @Test
    public void updatePasswordByUserNameAndPassword() {
    }

    @Test
    public void updatePasswordByUserPhoneAndPassword() {
    }
}