package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.nix.lovedomain.dao.base.BaseBusinessMapper;
import org.nix.lovedomain.dao.model.TeacherCourseModel;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 老师课程业务类
 * @date 2019/5/12
 */
public interface TeacherCourseBusinessMapper extends BaseBusinessMapper<TeacherCourseModel> {

    /**
     * 查询指定课程在指定时间老师的授课情况
     *
     * @param courseId  课程id集合
     * @param startTime 开始搜索时间
     * @param endTime   开始结束时间
     * @return 老师+课程定位老师的授课课程
     */
    List<TeacherCourseModel> findTeacherCourseInCurrSemester(
            @Param(value = "courseId") List<Integer> courseId,
            @Param(value = "startTime") String startTime,
            @Param(value = "endTime") String endTime
    );

}
