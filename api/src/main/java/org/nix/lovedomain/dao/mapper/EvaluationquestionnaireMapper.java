package org.nix.lovedomain.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.model.Evaluationquestionnaire;
import org.nix.lovedomain.model.EvaluationquestionnaireExample;

public interface EvaluationquestionnaireMapper {
    int countByExample(EvaluationquestionnaireExample example);

    int deleteByExample(EvaluationquestionnaireExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Evaluationquestionnaire record);

    int insertSelective(Evaluationquestionnaire record);

    List<Evaluationquestionnaire> selectByExampleWithBLOBs(EvaluationquestionnaireExample example);

    List<Evaluationquestionnaire> selectByExample(EvaluationquestionnaireExample example);

    Evaluationquestionnaire selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Evaluationquestionnaire record, @Param("example") EvaluationquestionnaireExample example);

    int updateByExampleWithBLOBs(@Param("record") Evaluationquestionnaire record, @Param("example") EvaluationquestionnaireExample example);

    int updateByExample(@Param("record") Evaluationquestionnaire record, @Param("example") EvaluationquestionnaireExample example);

    int updateByPrimaryKeySelective(Evaluationquestionnaire record);

    int updateByPrimaryKeyWithBLOBs(Evaluationquestionnaire record);

    int updateByPrimaryKey(Evaluationquestionnaire record);
}