package org.nix.lovedomain.databases.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.databases.rbac.Questionnaireanswer;
import org.nix.lovedomain.databases.rbac.QuestionnaireanswerExample;

public interface QuestionnaireanswerMapper {
    int countByExample(QuestionnaireanswerExample example);

    int deleteByExample(QuestionnaireanswerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Questionnaireanswer record);

    int insertSelective(Questionnaireanswer record);

    List<Questionnaireanswer> selectByExampleWithBLOBs(QuestionnaireanswerExample example);

    List<Questionnaireanswer> selectByExample(QuestionnaireanswerExample example);

    Questionnaireanswer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Questionnaireanswer record, @Param("example") QuestionnaireanswerExample example);

    int updateByExampleWithBLOBs(@Param("record") Questionnaireanswer record, @Param("example") QuestionnaireanswerExample example);

    int updateByExample(@Param("record") Questionnaireanswer record, @Param("example") QuestionnaireanswerExample example);

    int updateByPrimaryKeySelective(Questionnaireanswer record);

    int updateByPrimaryKeyWithBLOBs(Questionnaireanswer record);

    int updateByPrimaryKey(Questionnaireanswer record);
}