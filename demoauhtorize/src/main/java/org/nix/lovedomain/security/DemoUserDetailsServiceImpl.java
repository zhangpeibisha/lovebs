package org.nix.lovedomain.security;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.rbac.bean.po.Role;
import org.nix.lovedomain.rbac.bean.po.User;
import org.nix.lovedomain.rbac.dao.RoleMapper;
import org.nix.lovedomain.rbac.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 用户认证服务
 * @date 2019/1/27
 */
@Slf4j
@Component
public class DemoUserDetailsServiceImpl implements UserDetailsService, SocialUserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("表单登录用户名:" + username);
        User user = new User();
        user.setUserAccount(username);
        user.setUserName(username);
        return login(user);
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        log.info("社交登录用户Id:" + userId);
        return buildUser(userId);
    }

    private SocialUserDetails buildUser(String userId) {

        // 根据用户名查找用户信息
        //根据查找到的用户信息判断用户是否被冻结
        String password = passwordEncoder.encode("123456");
        log.info("数据库密码是:" + password);
        return new SocialUser(userId, password,
                true, true, true, true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_USER"));
    }

    private SocialUserDetails login(User user) {
        User user1 = userMapper.selectByUserAccountOrIdOrUserName(user);
        log.info("用户{}查询结果为{}", user, JSONUtil.toJsonStr(user1));
        if (user1 != null) {
            //查询用户的权限
            Integer userId = user1.getUserId();
            List<Role> roles = roleMapper.listRoleByUserId(userId);
            StringBuilder stringBuilder = new StringBuilder();
            roles.forEach(role -> stringBuilder.append(role.getRoleName()).append(","));
            int index = stringBuilder.lastIndexOf(",");
            if (index >= 0) {
                stringBuilder.deleteCharAt(index);
            }
            log.info("用户{}拥有的权限为:{}", user, stringBuilder);
            return new SocialUser(String.valueOf(userId), passwordEncoder.encode("123456"),
                    AuthorityUtils.commaSeparatedStringToAuthorityList(stringBuilder.toString()));

        }
        throw new UnsupportedOperationException("账户无效哦");
    }
}
