package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.model.Evaluationquestionnaire;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 问卷业务映射
 * @date 2019/4/22
 */
public interface EvaluationquestionnaireBusinessMapper {

    /**
     * 分页查询信息
     *
     * @param page     查询偏移量开始
     * @param limit    每页数量
     * @param querySql 查询sql
     * @return 查询结果
     */
    List<Evaluationquestionnaire> selectPage(@Param(value = "page") Integer page,
                                             @Param(value = "limit") Integer limit,
                                             @Param(value = "querySql") String querySql);

    /**
     * 查询指定sql返回的数据数量
     *
     * @param querySql
     * @return
     */
    Long selectCount(@Param(value = "querySql") String querySql);

}
