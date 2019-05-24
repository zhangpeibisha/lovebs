package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.dao.base.BaseBusinessMapper;
import org.nix.lovedomain.dao.model.FacultyModel;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 学院业务
 * @date 2019/5/1
 */
public interface FacultyBusinessMapper extends BaseBusinessMapper<FacultyModel> {

    /**
     * 通过sql查询学院信息
     *
     * @param page
     * @param limit
     * @param sql
     * @return
     */
    List<FacultyModel> findFacultyBySql(@Param(value = "page") Integer page,
                                   @Param(value = "limit") Integer limit,
                                   @Param(value = "sql") String sql);

    /**
     * 通过sql查询学院数量
     * @param sql
     * @return
     */
    Long countFacultyBySql(@Param(value = "sql") String sql);

}
