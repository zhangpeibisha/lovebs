package org.nix.lovedomain.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.nix.lovedomain.dao.mapper.base.BaseMapper;
import org.nix.lovedomain.model.Class;
import org.nix.lovedomain.model.ClassExample;

import java.util.List;

@Mapper
public interface ClassMapper extends BaseMapper<Class> {
    List<org.nix.lovedomain.model.Class> selectByExample(ClassExample example);

    List<org.nix.lovedomain.model.Class> selectAllclasIds();
}