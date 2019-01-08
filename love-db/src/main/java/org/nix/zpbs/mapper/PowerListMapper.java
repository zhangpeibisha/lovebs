package org.nix.zpbs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.zpbs.model.PowerList;
import org.nix.zpbs.model.PowerListExample;

public interface PowerListMapper {
    int countByExample(PowerListExample example);

    int deleteByExample(PowerListExample example);

    int deleteByPrimaryKey(Integer pId);

    int insert(PowerList record);

    int insertSelective(PowerList record);

    List<PowerList> selectByExample(PowerListExample example);

    PowerList selectByPrimaryKey(Integer pId);

    int updateByExampleSelective(@Param("record") PowerList record, @Param("example") PowerListExample example);

    int updateByExample(@Param("record") PowerList record, @Param("example") PowerListExample example);

    int updateByPrimaryKeySelective(PowerList record);

    int updateByPrimaryKey(PowerList record);
}