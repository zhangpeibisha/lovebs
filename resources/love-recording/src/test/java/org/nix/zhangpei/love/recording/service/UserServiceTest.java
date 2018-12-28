package org.nix.zhangpei.love.recording.service;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.zhangpei.love.recording.RecordingApplication;
import org.nix.zhangpei.love.recording.controller.dto.user.UserLoginDTO;
import org.nix.zhangpei.love.recording.controller.dto.user.UserRegisterDTO;
import org.nix.zhangpei.love.recording.controller.dto.user.UserSelectDTO;
import org.nix.zhangpei.love.recording.controller.dto.user.UserUpdateDTO;
import org.nix.zhangpei.love.recording.dao.mapper.UserMapper;
import org.nix.zhangpei.love.recording.service.vo.UserVO;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RecordingApplication.class)
public class UserServiceTest {

    private static Digester digester = new Digester(DigestAlgorithm.MD5);

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Before
    public void setUp(){

    }

    public static void main(String[] args) {
        String password = digester.digestHex("bisha520");
        System.out.println(password);
    }

    @Test
    public void register() {
        String password = digester.digestHex("bisha520");
        System.err.println(password);
        UserRegisterDTO registerDTO = new UserRegisterDTO();
        // 1.用户不能是已经注册过的
        registerDTO.setPassword(password);
        registerDTO.setPhone("18203085236");
        registerDTO.setUsername("zhangpeibisha");
        // 2.执行注册
        // 3.检测注册结果
        userService.register(registerDTO);
    }

    @Test
    public void findUserOne() {
        UserSelectDTO userSelectDTO = new UserSelectDTO();
        System.err.println(JSON.toJSONString(userSelectDTO));
        // 1.用户不能使用空数据来请求查询,将抛出检查异常
        userSelectDTO.setPhone("18203085236");
        // 2.由于是查询一个人的信息，所以查询出来不允许有多个信息
        UserVO userOne = userService.findUserOne(userSelectDTO);
        assertEquals("18203085236",userOne.getPhone());
    }

    @Test
    public void updateUser() {
        String password = digester.digestHex("bisha520");
        UserLoginDTO loginDTO = new UserLoginDTO();
        loginDTO.setPassword(password);
        loginDTO.setPhone("18203085236");

        UserUpdateDTO userUpdate = new UserUpdateDTO();
        userUpdate.setLogin(loginDTO);
        userUpdate.setNewUsername("bisha520");
        UserVO userVO = userService.updateUser(userUpdate);
        assertEquals("bisha520",userVO.getUsername());
    }

    @Test
    public void deleteUser() {
    }
}