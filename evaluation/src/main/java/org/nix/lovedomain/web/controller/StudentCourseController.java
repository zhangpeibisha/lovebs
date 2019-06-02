package org.nix.lovedomain.web.controller;

import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.TeacherBusinessMapper;
import org.nix.lovedomain.dao.model.TeacherModel;
import org.nix.lovedomain.service.StudentCourseService;
import org.nix.lovedomain.service.enums.Permission;
import org.nix.lovedomain.service.enums.RoleEnum;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;
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

    @Resource
    private StudentCourseService studentCourseService;

    @Permission(name = "通过课程id查询到老师信息", role = RoleEnum.MANGER, enable = false)
    @GetMapping(value = "/findTeacher")
    public RespondsMessage findCourseTeachers(@RequestParam(value = "courseId") Integer courseId) {

        List<TeacherModel> teacherByCourseId = teacherBusinessMapper.findTeacherByCourseId(courseId);

        return RespondsMessage.success(LogUtil.logInfo(log, "通过课程id{}找到了老师：{}"
                , courseId, teacherByCourseId), teacherByCourseId);
    }

    /**
     * 学生查询自己课程的分数
     *
     * @param teachCourseId
     * @param principal
     * @return
     */
    @Permission(name = "查询分数",description = "学生查询自己教学任务中的分数",role = RoleEnum.STUDENT)
    @GetMapping(value = "/teachCourser/score")
    public RespondsMessage findTeachCourseScore(@RequestParam(value = "teachCourseId") String teachCourseId,
                                                Principal principal) {
        Integer viewScore = studentCourseService.viewScore(principal, teachCourseId);
        return RespondsMessage.success(StrUtil.format("获取{}的分数完成", teachCourseId), viewScore);
    }

}
