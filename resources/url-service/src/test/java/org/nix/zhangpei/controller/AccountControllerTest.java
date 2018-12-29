package org.nix.zhangpei.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;

public class AccountControllerTest {

    private AccountDao accountDao;

    private HttpServletRequest request;

    @Before
    public void setUp(){
        accountDao = Mockito.mock(AccountDao.class);
        request = Mockito.mock(HttpServletRequest.class);
    }

    @Test
    public void testLogin() throws Exception {
        // 设置mockito参数，定义输入什么输出什么
        Mockito.when(request.getParameter("username")).thenReturn("zhangpei");
        Mockito.when(request.getParameter("password")).thenReturn("bisha520");
        Mockito.when(accountDao.login("zhangpei","bisha520")).thenReturn(Boolean.TRUE);
        // 生成自己负责的类，然后导入mock的代理对象，检测自己的方法是否按照自己的想法执行
        AccountController controller = new AccountController(accountDao);
        String login = controller.login(request);
        assertEquals(login,"成功");

    }

}