package org.nix.lovedomain.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.nix.lovedomain.dao.mapper.base.BaseMapper;
import org.nix.lovedomain.model.Evaluationquestionnaire;
import org.nix.lovedomain.model.EvaluationquestionnaireExample;

import java.util.List;

@Mapper
public interface EvaluationquestionnaireMapper extends BaseMapper<Evaluationquestionnaire> {
    List<Evaluationquestionnaire> selectByExample(EvaluationquestionnaireExample example);
}