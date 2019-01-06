package org.nix.zpbs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.zpbs.model.LoveRole;
import org.nix.zpbs.model.LoveRoleExample;

public interface LoveRoleMapper {
    int countByExample(LoveRoleExample example);

    int deleteByExample(LoveRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LoveRole record);

    int insertSelective(LoveRole record);

    List<LoveRole> selectByExample(LoveRoleExample example);

    LoveRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LoveRole record, @Param("example") LoveRoleExample example);

    int updateByExample(@Param("record") LoveRole record, @Param("example") LoveRoleExample example);

    int updateByPrimaryKeySelective(LoveRole record);

    int updateByPrimaryKey(LoveRole record);
}