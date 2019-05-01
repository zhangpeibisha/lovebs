package org.nix.lovedomain.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.dao.mapper.base.BaseMapper;
import org.nix.lovedomain.model.TeacherCourse;

@Mapper
public interface TeacherCourseMapper extends BaseMapper<TeacherCourse> {

    /**
     * 获取老师和课程组合的唯一ID
     * @param teacherId
     * @param courseId
     * @return Integer
     */
    public Integer getTeacherCourseId(@Param("teacherId") Integer teacherId,@Param("courseId") Integer courseId);

}