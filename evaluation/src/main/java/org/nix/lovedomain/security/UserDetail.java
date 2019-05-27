package org.nix.lovedomain.security;

import cn.hutool.core.lang.Validator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.model.AccountModel;
import org.nix.lovedomain.dao.model.ResourcesModel;
import org.nix.lovedomain.dao.model.RoleModel;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.social.security.SocialUserDetails;

import java.io.Serializable;
import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangpei
 */
@Slf4j
@Data
public class UserDetail implements SocialUserDetails, Serializable {

    @JsonIgnore
    private AccountModel account;

    private List<ResourcesModel> resources;

    private final List<UrlGrantedAuthority> grantedAuthorities;

    private final List<RoleModel> roleModels;

    private String userName;

    private String image;

    public UserDetail(AccountModel account,
                      List<ResourcesModel> resources,
                      List<RoleModel> roleModels,
                      String userName,
                      String image) {
        this.account = account;
        this.grantedAuthorities = resources.stream().map(it -> {
            String method = it.getMethod();
            return new UrlGrantedAuthority(method, it.getUrl());
        }).collect(Collectors.toList());
        this.resources = resources;
        this.userName = userName;
        this.roleModels = roleModels;
        this.image = image;
    }

    public UserDetail(List<UrlGrantedAuthority> grantedAuthorities, List<RoleModel> roleModels, String userName) {
        this.grantedAuthorities = grantedAuthorities;
        this.roleModels = roleModels;
        this.userName = userName;
    }

    /**
     * 获取到用户信息
     *
     * @param principal 用户信息
     * @return 用户信息
     */
    public static UserDetail analysisUserDetail(Principal principal) {
        Validator.validateNotNull(principal, "用户未登陆");
        if (principal instanceof UsernamePasswordAuthenticationToken) {
            Object user = ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
            if (user instanceof UserDetail) {
                return (UserDetail) user;
            }
        }
        return new UserDetail(null, null, principal.getName());
    }

    public static Integer analysisUserAccountId(Principal principal) {
        UserDetail userDetail = UserDetail.analysisUserDetail(principal);
        return userDetail.getAccount().getId();
    }

    public static List<RoleModel> analysisUserRoles(Principal principal) {
        UserDetail userDetail = UserDetail.analysisUserDetail(principal);
        List<RoleModel> roleModels = userDetail.getRoleModels();
        Validator.validateNotNull(roleModels, "用户{}权限不足", principal.getName());
        return roleModels;
    }


    @Override
    public String getUserId() {
        return account.getId().toString();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return account != null;
    }
}
