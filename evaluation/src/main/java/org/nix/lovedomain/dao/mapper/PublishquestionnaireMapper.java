package org.nix.lovedomain.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.dao.mapper.base.BaseMapper;
import org.nix.lovedomain.model.Publishquestionnaire;
import org.nix.lovedomain.model.PublishquestionnaireExample;
import org.nix.lovedomain.model.StatisticsScoreExtra;
import java.util.List;

@Mapper
public interface PublishquestionnaireMapper extends BaseMapper<Publishquestionnaire> {

    List<Publishquestionnaire> getAllDataByLimit(@Param("dateStr") String dateStr);

    List<Publishquestionnaire> selectByExample(PublishquestionnaireExample example);

    List<StatisticsScoreExtra> professionScoreStatistics(@Param("professionId") Integer professionId);

    List<StatisticsScoreExtra> factoryScoreStatistics(@Param("factoryId") Integer factoryId);
}