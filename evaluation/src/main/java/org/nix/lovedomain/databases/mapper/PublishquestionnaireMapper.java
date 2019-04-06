package org.nix.lovedomain.databases.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.databases.rbac.Publishquestionnaire;
import org.nix.lovedomain.databases.rbac.PublishquestionnaireExample;

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

    int updateByPrimaryKey(Publishquestionnaire record);
}