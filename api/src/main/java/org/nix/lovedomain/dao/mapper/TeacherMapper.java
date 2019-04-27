package org.nix.lovedomain.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.nix.lovedomain.dao.mapper.base.BaseMapper;
import org.nix.lovedomain.model.Teacher;
import org.nix.lovedomain.model.TeacherExample;

import java.util.List;

@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

    List<Teacher> selectByExample(TeacherExample example);

}