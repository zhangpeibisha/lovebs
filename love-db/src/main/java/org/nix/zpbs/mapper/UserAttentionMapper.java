package org.nix.zpbs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.zpbs.model.UserAttention;
import org.nix.zpbs.model.UserAttentionExample;

public interface UserAttentionMapper {
    int countByExample(UserAttentionExample example);

    int deleteByExample(UserAttentionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserAttention record);

    int insertSelective(UserAttention record);

    List<UserAttention> selectByExample(UserAttentionExample example);

    UserAttention selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserAttention record, @Param("example") UserAttentionExample example);

    int updateByExample(@Param("record") UserAttention record, @Param("example") UserAttentionExample example);

    int updateByPrimaryKeySelective(UserAttention record);

    int updateByPrimaryKey(UserAttention record);
}