package org.nix.zpbs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.zpbs.model.LoveRolePermissionRelation;
import org.nix.zpbs.model.LoveRolePermissionRelationExample;

public interface LoveRolePermissionRelationMapper {
    int countByExample(LoveRolePermissionRelationExample example);

    int deleteByExample(LoveRolePermissionRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LoveRolePermissionRelation record);

    int insertSelective(LoveRolePermissionRelation record);

    List<LoveRolePermissionRelation> selectByExample(LoveRolePermissionRelationExample example);

    LoveRolePermissionRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LoveRolePermissionRelation record, @Param("example") LoveRolePermissionRelationExample example);

    int updateByExample(@Param("record") LoveRolePermissionRelation record, @Param("example") LoveRolePermissionRelationExample example);

    int updateByPrimaryKeySelective(LoveRolePermissionRelation record);

    int updateByPrimaryKey(LoveRolePermissionRelation record);
}