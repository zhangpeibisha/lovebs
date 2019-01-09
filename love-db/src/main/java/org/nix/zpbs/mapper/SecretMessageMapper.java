package org.nix.zpbs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.zpbs.model.SecretMessage;
import org.nix.zpbs.model.SecretMessageExample;

public interface SecretMessageMapper {
    int countByExample(SecretMessageExample example);

    int deleteByExample(SecretMessageExample example);

    int deleteByPrimaryKey(Long secretId);

    int insert(SecretMessage record);

    int insertSelective(SecretMessage record);

    List<SecretMessage> selectByExample(SecretMessageExample example);

    SecretMessage selectByPrimaryKey(Long secretId);

    int updateByExampleSelective(@Param("record") SecretMessage record, @Param("example") SecretMessageExample example);

    int updateByExample(@Param("record") SecretMessage record, @Param("example") SecretMessageExample example);

    int updateByPrimaryKeySelective(SecretMessage record);

    int updateByPrimaryKey(SecretMessage record);
}