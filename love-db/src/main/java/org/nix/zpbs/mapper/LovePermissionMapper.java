package org.nix.zpbs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.zpbs.model.LovePermission;
import org.nix.zpbs.model.LovePermissionExample;

public interface LovePermissionMapper {
    int countByExample(LovePermissionExample example);

    int deleteByExample(LovePermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LovePermission record);

    int insertSelective(LovePermission record);

    List<LovePermission> selectByExample(LovePermissionExample example);

    LovePermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LovePermission record, @Param("example") LovePermissionExample example);

    int updateByExample(@Param("record") LovePermission record, @Param("example") LovePermissionExample example);

    int updateByPrimaryKeySelective(LovePermission record);

    int updateByPrimaryKey(LovePermission record);
}