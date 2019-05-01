package org.nix.lovedomain.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.model.Publishquestionnaire;
import org.nix.lovedomain.model.PublishquestionnaireExample;

public interface PublishquestionnaireMapper {
    int countByExample(PublishquestionnaireExample example);

    int deleteByExample(PublishquestionnaireExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Publishquestionnaire record);

    int insertSelective(Publishquestionnaire record);

    List<Publishquestionnaire> selectByExample(PublishquestionnaireExample example);

    Publishquestionnaire selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Publishquestionnaire record, @Param("example") PublishquestionnaireExample example);

    int updateByExample(@Param("record") Publishquestionnaire record, @Param("example") PublishquestionnaireExample example);

    int updateByPrimaryKeySelective(Publishquestionnaire record);

    List<Publishquestionnaire> getAllDataByLimit(@Param("dateStr") String dateStr);

    List<Publishquestionnaire> selectByExample(PublishquestionnaireExample example);

    int updateByPrimaryKey(Publishquestionnaire record);
}