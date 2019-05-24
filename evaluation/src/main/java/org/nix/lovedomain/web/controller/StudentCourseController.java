package org.nix.lovedomain.web.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.TeacherBusinessMapper;
import org.nix.lovedomain.dao.model.TeacherModel;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 */
@Api(value = "学生课程相关管理器", description = "学生课程相关的操作都在里面进行")
@Slf4j
@RestController
@RequestMapping(value = "studentCourse")
public class StudentCourseController {

    @Resource
    private TeacherBusinessMapper teacherBusinessMapper;

    @GetMapping(value = "/findTeacher")
    public RespondsMessage findCourseTeachers(@RequestParam(value = "courseId") Integer courseId) {

        List<TeacherModel> teacherByCourseId = teacherBusinessMapper.findTeacherByCourseId(courseId);

        return RespondsMessage.success(LogUtil.logInfo(log, "通过课程id{}找到了老师：{}"
                , courseId, teacherByCourseId), teacherByCourseId);
    }

}
