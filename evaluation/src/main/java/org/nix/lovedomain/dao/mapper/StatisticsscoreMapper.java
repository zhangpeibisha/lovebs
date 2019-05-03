package org.nix.lovedomain.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.dao.mapper.base.BaseMapper;
import org.nix.lovedomain.model.Statisticsscore;

import java.util.List;

@Mapper
public interface StatisticsscoreMapper extends BaseMapper<Statisticsscore> {

    /**
     * 批量插入
     * @param list
     */
    void Inserts(@Param("list") List<Statisticsscore> list);
}