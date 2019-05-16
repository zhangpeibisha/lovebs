package org.nix.lovedomain.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.nix.lovedomain.dao.mapper.base.BaseMapper;
import org.nix.lovedomain.model.Account;
import org.nix.lovedomain.model.AccountExample;
import org.nix.lovedomain.model.StudentExample;

import java.util.List;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    List<Account> selectByExample(AccountExample example);

    int deleteByExample(AccountExample example);
}