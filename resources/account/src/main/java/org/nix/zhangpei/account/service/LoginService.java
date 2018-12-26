package org.nix.zhangpei.account.service;

import org.nix.zhangpei.account.dao.LoginMapper;
import org.nix.zhangpei.account.model.LoginPO;
import org.nix.zhangpei.account.service.vo.LoginVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/23
 */
@Service
public class LoginService {

    /**
     * 判断用户输入是否是手机号码
     */
    private static final String IS_PHONE = "^1\\d{10}$";
    /**
     * 判断用户输入是否是邮箱
     */
    private static final String IS_EMAIL = "^^(\\w-*\\.*)+@(\\w-?)+(\\.\\w{2,})+$";
    /**
     * 判断用户输入是否是用户名
     */
    private static final String IS_ACCOUNT_NAME = "^[a-zA-Z]\\w{6,15}$";

    @Resource
    private LoginMapper loginMapping;

    public static void main(String[] args) {
        String phone = "18203085236";
        String email = "zhangpe0312@qq.com";
        String accountName = "zhangpei";
        System.out.println(phone.matches(IS_PHONE));
        System.out.println(phone.matches(IS_EMAIL));
        System.out.println(phone.matches(IS_ACCOUNT_NAME));

        System.out.println(email.matches(IS_PHONE));
        System.out.println(email.matches(IS_EMAIL));
        System.out.println(email.matches(IS_ACCOUNT_NAME));

        System.out.println(accountName.matches(IS_PHONE));
        System.out.println(accountName.matches(IS_EMAIL));
        System.out.println(accountName.matches(IS_ACCOUNT_NAME));

    }

    /**
     * 处理用户账号和密码验证
     *
     * @param input    用户的账号输入
     * @param password 用户的密码输入
     * @return 用户的详细信息
     * @throws ServiceException 处理过程遇到的服务异常
     */
    public LoginVO login(String input, String password) throws ServiceException {
        LoginPO login = findLogin(input);
        if (login == null) {
            throw new ServiceException(String.format("%s暂未注册", input));
        }
        if (password.equals(login.getPassword())) {
            return new LoginVO(login);
        }
        throw new ServiceException(String.format("%s密码错误", password));
    }

    /**
     * 用户注册
     * @param input 用户输入
     * @param password 用户密码
     */
    public void register(String input, String password) {
        LoginPO login = findLogin(input);
        if (login != null) {
            throw new ServiceException(String.format("%s已经被注册", input));
        }
        LoginPO loginPO = new LoginPO();
        String inputType = getInputType(input);
        if (inputType == null) {
            throw new ServiceException(String.format("%s输入不符合要求", input));
        }
        switch (inputType) {
            case "accountName":
                loginPO.setAccountName(input);
                break;
            case "phone":
                loginPO.setPhone(input);
                break;
            case "email":
                loginPO.setEmail(input);
                break;
            default:
                throw new ServiceException(String.format("%s输入不符合要求", input));
        }


    }

    /**
     * 通过用户登陆信息发现用户详细信息
     *
     * @param input 用户输入信息
     * @return 用户详细信息
     */
    private LoginPO findLogin(String input) {
        LoginPO loginPO = null;
        String inputType = getInputType(input);
        if (inputType == null) {
            return null;
        }
        switch (inputType) {
            case "accountName":
                loginPO = loginMapping.findLoginByAccountName(input);
                break;
            case "phone":
                loginPO = loginMapping.findLoginByPhone(input);
                break;
            case "email":
                loginPO = loginMapping.findLoginByEmail(input);
                break;
            default:
                return null;
        }
        return loginPO;
    }

    private String getInputType(String input) {
        if (input.matches(IS_PHONE)) {
            return "phone";
        }
        if (input.matches(IS_EMAIL)) {
            return "email";
        }
        if (input.matches(IS_ACCOUNT_NAME)) {
            return "accountName";
        }
        return null;
    }

}
