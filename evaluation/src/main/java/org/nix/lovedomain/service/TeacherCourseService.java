package org.nix.lovedomain.service;

import org.nix.lovedomain.dao.mapper.TeacherCourseMapper;
import org.nix.lovedomain.service.base.BaseService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @version 1.0
 * @anthor  on 2019/4/19
 * @since jdk8
 */
@Service
public class TeacherCourseService extends BaseService {

    @Resource
    TeacherCourseMapper teacherCourseMapper;

    /**
     * 获取老师和课程组合的唯一ID
     * @param teacherId
     * @param courseId
     * @return
     */
    public Integer getTeacherCourseId(Integer teacherId,Integer courseId){
           return teacherCourseMapper.getTeacherCourseId(teacherId,courseId);
    }
}
