package org.nix.lovedomain.security;

import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.RoleBusinessMapper;
import org.nix.lovedomain.dao.model.AccountModel;
import org.nix.lovedomain.dao.model.ResourcesModel;
import org.nix.lovedomain.dao.model.RoleModel;
import org.nix.lovedomain.service.AccountService;
import org.nix.lovedomain.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description security框架验证用户信息的地方
 * @date 2019/3/5
 */
@Slf4j
@Component
public class UserDetailServiceImpl implements UserDetailsService, SocialUserDetailsService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ResourcesService resourcesService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Resource
    private RoleBusinessMapper roleBusinessMapper;
    /**
     * 为了简单，直接赋值
     */
    private String image = "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=616624,269991790&fm=26&gp=0.jpg";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("用户{}表单登陆", username);
        return builderUser(username);
    }

    @Override
    public SocialUserDetails loadUserByUserId(String username) throws UsernameNotFoundException {
        return builderUser(username);
    }

    private SocialUserDetails builderUser(String username) {
        AccountModel userByAccount = accountService.findUserByAccount(username);
        // 测试的时候不加密,使用默认加密方式
        userByAccount.setPassword(passwordEncoder.encode(userByAccount.getPassword()));
        List<ResourcesModel> resourcesByAccount = resourcesService.findResourcesByAccount(username);
        List<RoleModel> roleModels = roleBusinessMapper.findRoleModelsByLoginName(username);
        return new UserDetail(userByAccount, resourcesByAccount, roleModels, username, image);
    }

}
