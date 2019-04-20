package org.nix.lovedomain.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.nix.lovedomain.dao.mapper.base.BaseMapper;
import org.nix.lovedomain.model.Faculty;
import org.nix.lovedomain.model.FacultyExample;

import java.util.List;

@Mapper
public interface FacultyMapper extends BaseMapper<Faculty> {
    List<Faculty> selectByExample(FacultyExample example);
}