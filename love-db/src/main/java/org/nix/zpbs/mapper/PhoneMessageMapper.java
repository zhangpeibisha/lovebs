package org.nix.zpbs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.zpbs.model.PhoneMessage;
import org.nix.zpbs.model.PhoneMessageExample;

public interface PhoneMessageMapper {
    int countByExample(PhoneMessageExample example);

    int deleteByExample(PhoneMessageExample example);

    int deleteByPrimaryKey(Long phoneId);

    int insert(PhoneMessage record);

    int insertSelective(PhoneMessage record);

    List<PhoneMessage> selectByExample(PhoneMessageExample example);

    PhoneMessage selectByPrimaryKey(Long phoneId);

    int updateByExampleSelective(@Param("record") PhoneMessage record, @Param("example") PhoneMessageExample example);

    int updateByExample(@Param("record") PhoneMessage record, @Param("example") PhoneMessageExample example);

    int updateByPrimaryKeySelective(PhoneMessage record);

    int updateByPrimaryKey(PhoneMessage record);
}