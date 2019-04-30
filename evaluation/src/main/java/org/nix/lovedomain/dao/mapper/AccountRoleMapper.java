package org.nix.lovedomain.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.nix.lovedomain.dao.mapper.base.BaseMapper;
import org.nix.lovedomain.model.AccountRole;
import org.nix.lovedomain.model.AccountRoleExample;

import java.util.List;

@Mapper
public interface AccountRoleMapper extends BaseMapper<AccountRole> {

    List<AccountRole> selectByExample(AccountRoleExample example);

}