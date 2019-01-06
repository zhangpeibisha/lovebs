package org.nix.zpbs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.zpbs.model.LoveMemberLoginLog;
import org.nix.zpbs.model.LoveMemberLoginLogExample;

public interface LoveMemberLoginLogMapper {
    int countByExample(LoveMemberLoginLogExample example);

    int deleteByExample(LoveMemberLoginLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LoveMemberLoginLog record);

    int insertSelective(LoveMemberLoginLog record);

    List<LoveMemberLoginLog> selectByExample(LoveMemberLoginLogExample example);

    LoveMemberLoginLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LoveMemberLoginLog record, @Param("example") LoveMemberLoginLogExample example);

    int updateByExample(@Param("record") LoveMemberLoginLog record, @Param("example") LoveMemberLoginLogExample example);

    int updateByPrimaryKeySelective(LoveMemberLoginLog record);

    int updateByPrimaryKey(LoveMemberLoginLog record);
}