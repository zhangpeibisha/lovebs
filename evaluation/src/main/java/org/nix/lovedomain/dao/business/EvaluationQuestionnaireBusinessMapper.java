package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.dao.base.BaseBusinessMapper;
import org.nix.lovedomain.dao.model.EvaluationQuestionnaireModel;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 评教卷业务映射
 * @date 2019/4/22
 */
public interface EvaluationQuestionnaireBusinessMapper extends BaseBusinessMapper<EvaluationQuestionnaireModel> {

    /**
     * 分页查询信息
     *
     * @param page     查询偏移量开始
     * @param limit    每页数量
     * @param querySql 查询sql
     * @return 查询结果
     */
    List<EvaluationQuestionnaireModel> selectPage(@Param(value = "page") Integer page,
                                                  @Param(value = "limit") Integer limit,
                                                  @Param(value = "querySql") String querySql);

    /**
     * 查询指定sql返回的数据数量
     *
     * @param querySql
     * @return
     */
    Long selectCountBySql(@Param(value = "querySql") String querySql);

}
