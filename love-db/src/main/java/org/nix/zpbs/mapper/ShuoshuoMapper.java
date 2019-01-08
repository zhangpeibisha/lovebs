package org.nix.zpbs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.zpbs.model.Shuoshuo;
import org.nix.zpbs.model.ShuoshuoExample;

public interface ShuoshuoMapper {
    int countByExample(ShuoshuoExample example);

    int deleteByExample(ShuoshuoExample example);

    int deleteByPrimaryKey(Integer shuoId);

    int insert(Shuoshuo record);

    int insertSelective(Shuoshuo record);

    List<Shuoshuo> selectByExample(ShuoshuoExample example);

    Shuoshuo selectByPrimaryKey(Integer shuoId);

    int updateByExampleSelective(@Param("record") Shuoshuo record, @Param("example") ShuoshuoExample example);

    int updateByExample(@Param("record") Shuoshuo record, @Param("example") ShuoshuoExample example);

    int updateByPrimaryKeySelective(Shuoshuo record);

    int updateByPrimaryKey(Shuoshuo record);
}