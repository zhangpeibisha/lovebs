package org.nix.zpbs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.zpbs.model.GroupResource;
import org.nix.zpbs.model.GroupResourceExample;

public interface GroupResourceMapper {
    int countByExample(GroupResourceExample example);

    int deleteByExample(GroupResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GroupResource record);

    int insertSelective(GroupResource record);

    List<GroupResource> selectByExample(GroupResourceExample example);

    GroupResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GroupResource record, @Param("example") GroupResourceExample example);

    int updateByExample(@Param("record") GroupResource record, @Param("example") GroupResourceExample example);

    int updateByPrimaryKeySelective(GroupResource record);

    int updateByPrimaryKey(GroupResource record);
}