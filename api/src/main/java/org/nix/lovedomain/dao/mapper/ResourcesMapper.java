package org.nix.lovedomain.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.nix.lovedomain.dao.mapper.base.BaseMapper;
import org.nix.lovedomain.model.Resources;
import org.nix.lovedomain.model.ResourcesExample;

import java.util.List;

@Mapper
public interface ResourcesMapper extends BaseMapper<Resources> {

    List<Resources> selectByExample(ResourcesExample example);
}