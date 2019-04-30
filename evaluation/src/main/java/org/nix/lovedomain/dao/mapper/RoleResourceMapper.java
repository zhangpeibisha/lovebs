package org.nix.lovedomain.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.nix.lovedomain.dao.mapper.base.BaseMapper;
import org.nix.lovedomain.model.RoleResource;
import org.nix.lovedomain.model.RoleResourceExample;

import java.util.List;

@Mapper
public interface RoleResourceMapper extends BaseMapper<RoleResource> {

    List<RoleResource> selectByExample(RoleResourceExample example);

    int deleteByExample(RoleResourceExample example);

}