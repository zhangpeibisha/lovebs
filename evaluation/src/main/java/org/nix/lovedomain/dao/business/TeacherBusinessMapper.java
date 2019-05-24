package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.nix.lovedomain.dao.base.BaseBusinessMapper;
import org.nix.lovedomain.dao.model.TeacherModel;

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
    List<TeacherModel> findTeacherBySql(@Param(value = "page") Integer page,
                                        @Param(value = "limit") Integer limit,
                                        @Param(value = "sql") String sql);

    /**
     * 通过sql查询老师数量
     *
     * @param sql
     * @return
     */
    Long countTeacherBySql(@Param(value = "sql") String sql);

    /**
     * 通过课程id找到老师信息
     *
     * @param courseId 课程id
     * @return 老师信息
     */
    List<TeacherModel> findTeacherByCourseId(@Param(value = "courseId") Integer courseId);

    /**
     * 通过账号查询到老师信息
     * @param accountId 老师的账号id
     * @return 老师信息
     */
    @Select(value = "SELECT * FROM `teacher` WHERE accountId = #{accountId};")
    TeacherModel selectByAccountId(@Param(value = "accountId") Integer accountId);

}
