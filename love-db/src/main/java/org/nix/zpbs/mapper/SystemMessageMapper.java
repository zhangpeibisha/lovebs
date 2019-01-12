package org.nix.zpbs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.zpbs.model.SystemMessage;
import org.nix.zpbs.model.SystemMessageExample;

public interface SystemMessageMapper {
    int countByExample(SystemMessageExample example);

    int deleteByExample(SystemMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemMessage record);

    int insertSelective(SystemMessage record);

    List<SystemMessage> selectByExample(SystemMessageExample example);

    SystemMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemMessage record, @Param("example") SystemMessageExample example);

    int updateByExample(@Param("record") SystemMessage record, @Param("example") SystemMessageExample example);

    int updateByPrimaryKeySelective(SystemMessage record);

    int updateByPrimaryKey(SystemMessage record);
}