package org.nix.zpbs.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.zpbs.LoveOAuth2Application;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = LoveOAuth2Application.class)
public class TestControllerTest {

    @Resource
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void helloSuccess() throws Exception {
        mockMvc.perform(get("/test/hello/zhangpei")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Test
    public void helloFail() throws Exception {
        mockMvc.perform(get("/test/hello/12jkljf")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(status().is4xxClientError());
    }

    @Test
    public void havePower() {
    }

    @Test
    public void haveNotPower() {
    }

    /**
     * @return 测试JsonView是否有用
     * @author zhangpe0312@qq.com
     * @description
     * @date 15:58 2019/1/15
     */
    @Test
    public void findUserSimpleInfoSuccess() throws Exception {
        // 测试访问接口，id为1，但是用户地址应该不能存在
        mockMvc.perform(get("/test/simple/user/1"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.userAddress").doesNotExist());
    }

    @Test
    public void findUserSimpleInfoFail() throws Exception {
        // 测试访问接口，id为1，但是用户地址应该不能存在
        mockMvc.perform(get("/test/simple/user/a"))
                .andExpect(status().is4xxClientError());
    }
}