package org.nix.zhangpei.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/29
 */
public class AccountController {

    private AccountDao accountDao;

    public AccountController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public String login(HttpServletRequest request) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean login = accountDao.login(username, password);
        return login?"成功":"失败";
    }
}
