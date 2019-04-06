package org.nix.lovedomain.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.model.Profession;
import org.nix.lovedomain.model.ProfessionExample;

public interface ProfessionMapper {
    int countByExample(ProfessionExample example);

    int deleteByExample(ProfessionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Profession record);

    int insertSelective(Profession record);

    List<Profession> selectByExample(ProfessionExample example);

    Profession selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Profession record, @Param("example") ProfessionExample example);

    int updateByExample(@Param("record") Profession record, @Param("example") ProfessionExample example);

    int updateByPrimaryKeySelective(Profession record);

    int updateByPrimaryKey(Profession record);
}