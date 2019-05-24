package org.nix.lovedomain.service;

import org.nix.lovedomain.dao.business.TeacherCourseBusinessMapper;
import org.nix.lovedomain.dao.model.TeacherCourseModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 */
@Service
public class TeacherCourseService  {


    @Resource
    private TeacherCourseBusinessMapper teacherCourseBusinessMapper;

    /**
     * 通过教学任务id查询到教学任务的详细信息
     * @param teachCourseId 教学任务id
     * @return 教学任务详细信息
     */
    public TeacherCourseModel findTeachTaskByTeachCourseId(String teachCourseId){
        TeacherCourseModel teacherCourseModel = new TeacherCourseModel();
        teacherCourseModel.setTeachCourseId(teachCourseId);
        return teacherCourseBusinessMapper.selectOne(teacherCourseModel);
    }

}
