package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.nix.lovedomain.dao.base.BaseBusinessMapper;
import org.nix.lovedomain.dao.model.PublishQuestionnaireModel;

/**
 * @author zhangpei
 * @version 1.0
 * @description 发布评教卷业务
 * @date 2019/5/12
 */
public interface PublishQuestionBusinessMapper extends BaseBusinessMapper<PublishQuestionnaireModel> {

    /**
     * 【测试使用】
     * 更新全部的评教任务所对应的评教卷
     * @param questionId 评教卷id
     * @return 更新数量
     */
    @Update(value = "UPDATE publishQuestionnaire SET questionnaireId = #{questionId}")
    int updateQuestionId(@Param(value = "questionId") Integer questionId);

}
