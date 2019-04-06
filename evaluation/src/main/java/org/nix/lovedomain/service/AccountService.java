package org.nix.lovedomain.service;

import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.mapper.AccountMapper;
import org.nix.lovedomain.model.Account;
import org.nix.lovedomain.model.AccountExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author zhangpei
 * @version 1.0
 * @description 账户服务
 * @date 2019/3/5
 */
@Service
@Slf4j
public class AccountService {

    @Resource
    private AccountMapper accountMapper;

    public Account findUserByAccount(String username) {
        if (username == null) {
            throw new ServiceException("用户名不能为空");
        }
        AccountExample example = new AccountExample();

        AccountExample.Criteria numbering = example.createCriteria();
        numbering.andNumberingEqualTo(username);

        AccountExample.Criteria phone = example.createCriteria();
        phone.andPhoneEqualTo(username);

        AccountExample.Criteria email = example.createCriteria();
        email.andEmailEqualTo(username);

        example.or(numbering);
        example.or(phone);
        example.or(email);

        List<Account> accounts = accountMapper.selectByExample(example);
        if (accounts.size() == 1) {
            return accounts.get(0);
        }
        throw new ServiceException("通过用户名" + username + "查询用户信息失败");
    }
}
