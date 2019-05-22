package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.dao.base.BaseBusinessMapper;
import org.nix.lovedomain.dao.mapper.base.BaseMapper;
import org.nix.lovedomain.dao.model.TeacherModel;
import org.nix.lovedomain.model.Teacher;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 老师业务
 * @date 2019/5/2
 */
public interface TeacherBusinessMapper extends BaseBusinessMapper<TeacherModel> {

    /**
     * 通过sql查询老师信息
     *
     * @param page
     * @param limit
     * @param sql
     * @return
     */
    List<Teacher> findTeacherBySql(@Param(value = "page") Integer page,
                                   @Param(value = "limit") Integer limit,
                                   @Param(value = "sql") String sql);

    /**
     * 通过sql查询老师数量
     * @param sql
     * @return
     */
    Long countTeacherBySql(@Param(value = "sql") String sql);

    /**
     * 通过课程id找到老师信息
     * @param courseId 课程id
     * @return 老师信息
     */
    List<Teacher> findTeacherByCourseId(@Param(value = "courseId")Integer courseId);

}
