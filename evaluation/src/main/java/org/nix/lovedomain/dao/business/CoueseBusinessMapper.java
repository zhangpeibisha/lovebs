package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.dao.base.BaseBusinessMapper;
import org.nix.lovedomain.dao.model.CourseModel;
import org.nix.lovedomain.model.Course;
import org.nix.lovedomain.model.Teacher;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 课程业务
 * @date 2019/5/11
 */
public interface CoueseBusinessMapper extends BaseBusinessMapper<CourseModel> {

    /**
     * 通过sql查询课程信息
     *
     * @param page
     * @param limit
     * @param sql
     * @return
     */
    List<Course> findCourseBySql(@Param(value = "page") Integer page,
                                 @Param(value = "limit") Integer limit,
                                 @Param(value = "sql") String sql);

    /**
     * 通过sql查询老师数量
     * @param sql
     * @return
     */
    Long countCourseBySql(@Param(value = "sql") String sql);

}
