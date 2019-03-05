package org.nix.lovedomain.databases.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.databases.model.RoleResource;
import org.nix.lovedomain.databases.model.RoleResourceExample;

public interface RoleResourceMapper {
    int countByExample(RoleResourceExample example);

    int deleteByExample(RoleResourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleResource record);

    int insertSelective(RoleResource record);

    List<RoleResource> selectByExample(RoleResourceExample example);

    RoleResource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleResource record, @Param("example") RoleResourceExample example);

    int updateByExample(@Param("record") RoleResource record, @Param("example") RoleResourceExample example);

    int updateByPrimaryKeySelective(RoleResource record);

    int updateByPrimaryKey(RoleResource record);
}