package org.nix.zpbs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.zpbs.model.StayMessage;
import org.nix.zpbs.model.StayMessageExample;

public interface StayMessageMapper {
    int countByExample(StayMessageExample example);

    int deleteByExample(StayMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StayMessage record);

    int insertSelective(StayMessage record);

    List<StayMessage> selectByExample(StayMessageExample example);

    StayMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StayMessage record, @Param("example") StayMessageExample example);

    int updateByExample(@Param("record") StayMessage record, @Param("example") StayMessageExample example);

    int updateByPrimaryKeySelective(StayMessage record);

    int updateByPrimaryKey(StayMessage record);
}