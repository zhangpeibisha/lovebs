package org.nix.lovedomain.service;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.mapper.AccountMapper;
import org.nix.lovedomain.dao.mapper.AccountRoleMapper;
import org.nix.lovedomain.dao.mapper.RoleMapper;
import org.nix.lovedomain.model.Account;
import org.nix.lovedomain.model.AccountRole;
import org.nix.lovedomain.model.AccountRoleExample;
import org.nix.lovedomain.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RoleService {

    @Resource
    private AccountRoleMapper accountRoleMapper;

    @Resource
    private AccountMapper accountMapper;

    @Autowired
    private AccountService accountService;

    @Resource
    private RoleMapper roleMapper;

    public List<Role> findRolesByAccount(String account) {
        Account userByAccount = accountService.findUserByAccount(account);
        AccountRoleExample accountRoleExample = new AccountRoleExample();
        Integer id = userByAccount.getId();
        accountRoleExample.createCriteria().andAccountidEqualTo(id);
        List<AccountRole> accountRoles = accountRoleMapper.selectByExample(accountRoleExample);
        if (accountRoles.size() == 0) {
            log.info("用户{}没有角色", account);
            return new ArrayList<>();
        }
        List<Role> roles;
        roles = new ArrayList<>(accountRoles.size());
        accountRoles.forEach(accountRole -> {
            Integer roleid = accountRole.getRoleid();
            roles.add(roleMapper.selectByPrimaryKey(roleid));
        });
        log.info("用户{}的角色信息为：{}", account, JSONUtil.toJsonStr(roles));
        return roles;
    }


}
