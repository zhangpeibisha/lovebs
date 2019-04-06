package org.nix.lovedomain.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.model.Statisticsscore;
import org.nix.lovedomain.model.StatisticsscoreExample;

public interface StatisticsscoreMapper {
    int countByExample(StatisticsscoreExample example);

    int deleteByExample(StatisticsscoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Statisticsscore record);

    int insertSelective(Statisticsscore record);

    List<Statisticsscore> selectByExampleWithBLOBs(StatisticsscoreExample example);

    List<Statisticsscore> selectByExample(StatisticsscoreExample example);

    Statisticsscore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Statisticsscore record, @Param("example") StatisticsscoreExample example);

    int updateByExampleWithBLOBs(@Param("record") Statisticsscore record, @Param("example") StatisticsscoreExample example);

    int updateByExample(@Param("record") Statisticsscore record, @Param("example") StatisticsscoreExample example);

    int updateByPrimaryKeySelective(Statisticsscore record);

    int updateByPrimaryKeyWithBLOBs(Statisticsscore record);

    int updateByPrimaryKey(Statisticsscore record);
}