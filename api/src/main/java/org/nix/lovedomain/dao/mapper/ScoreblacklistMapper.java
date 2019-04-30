package org.nix.lovedomain.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.model.Scoreblacklist;
import org.nix.lovedomain.model.ScoreblacklistExample;

public interface ScoreblacklistMapper {
    int countByExample(ScoreblacklistExample example);

    int deleteByExample(ScoreblacklistExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Scoreblacklist record);

    int insertSelective(Scoreblacklist record);

    List<Scoreblacklist> selectByExample(ScoreblacklistExample example);

    Scoreblacklist selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Scoreblacklist record, @Param("example") ScoreblacklistExample example);

    int updateByExample(@Param("record") Scoreblacklist record, @Param("example") ScoreblacklistExample example);

    int updateByPrimaryKeySelective(Scoreblacklist record);

    int updateByPrimaryKey(Scoreblacklist record);
}