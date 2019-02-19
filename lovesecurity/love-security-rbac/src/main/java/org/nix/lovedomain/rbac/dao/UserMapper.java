package org.nix.lovedomain.rbac.dao;

import org.nix.lovedomain.rbac.bean.po.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    int deleteByPrimaryKey(Integer userId);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    List<User> listUser(User record);

    User selectByUserAccountOrIdOrUserName(User user);
}