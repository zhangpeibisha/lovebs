package org.nix.zpbs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.zpbs.model.LoveMember;
import org.nix.zpbs.model.LoveMemberExample;

public interface LoveMemberMapper {
    int countByExample(LoveMemberExample example);

    int deleteByExample(LoveMemberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LoveMember record);

    int insertSelective(LoveMember record);

    List<LoveMember> selectByExample(LoveMemberExample example);

    LoveMember selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LoveMember record, @Param("example") LoveMemberExample example);

    int updateByExample(@Param("record") LoveMember record, @Param("example") LoveMemberExample example);

    int updateByPrimaryKeySelective(LoveMember record);

    int updateByPrimaryKey(LoveMember record);
}