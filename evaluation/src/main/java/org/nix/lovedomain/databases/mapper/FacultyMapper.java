package org.nix.lovedomain.databases.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.databases.rbac.Faculty;
import org.nix.lovedomain.databases.rbac.FacultyExample;

public interface FacultyMapper {
    int countByExample(FacultyExample example);

    int deleteByExample(FacultyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Faculty record);

    int insertSelective(Faculty record);

    List<Faculty> selectByExample(FacultyExample example);

    Faculty selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Faculty record, @Param("example") FacultyExample example);

    int updateByExample(@Param("record") Faculty record, @Param("example") FacultyExample example);

    int updateByPrimaryKeySelective(Faculty record);

    int updateByPrimaryKey(Faculty record);
}