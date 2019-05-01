package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.model.Class;
import org.nix.lovedomain.model.Faculty;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 课程业务
 * @date 2019/5/1
 */
public interface ClassBusinessMapper {

    /**
     * 通过sql查询学院信息
     *
     * @param page
     * @param limit
     * @param sql
     * @return
     */
    List<Class> findClassBySql(@Param(value = "page") Integer page,
                                 @Param(value = "limit") Integer limit,
                                 @Param(value = "sql") String sql);

    /**
     * 通过sql查询学院数量
     * @param sql
     * @return
     */
    Long countClassBySql(@Param(value = "sql") String sql);

}
