package org.nix.zhangpei.account.dao;

import com.alibaba.fastjson.JSON;
import org.nix.zhangpei.account.model.LoginPO;
import org.springframework.stereotype.Repository;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/22
 */
@Repository
public class LoginMapping {
    private static LoginPO login;

    private LoginMapping() {
    }

    public static LoginPO getLogin(){
        if (login == null){
            login = new LoginPO();
            login.setAccountName("zhagnpei");
            login.setEmail("zhangpe0312@qq.com");
            login.setPhone("18203085236");
            login.setPassword("bisha520");
            login.setGroup(LoginGroupMapping.getGroup());
            login.setCreateTime(System.currentTimeMillis());
            login.setId(1L);
            login.setUpdateTIme(System.currentTimeMillis());
        }
        return login;
    }

    public LoginPO findLoginByPhone(String input) {
        return getLogin();
    }

    public LoginPO findLoginByEmail(String input) {
        return getLogin();
    }

    public LoginPO findLoginByAccountName(String input) {
        return getLogin();
    }

    public void insertLogin(LoginPO loginPO) {
        System.out.println("注册成功:" + JSON.toJSONString(loginPO));
    }
}
