package org.nix.lovedomain.web.controller;

import cn.hutool.core.collection.CollUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.StudentCourseBusinessMapper;
import org.nix.lovedomain.dao.business.TeacherBusinessMapper;
import org.nix.lovedomain.dao.business.TeacherCourseBusinessMapper;
import org.nix.lovedomain.dao.model.StudentCourseModel;
import org.nix.lovedomain.dao.model.TeacherCourseModel;
import org.nix.lovedomain.dao.model.TeacherModel;
import org.nix.lovedomain.service.AccountService;
import org.nix.lovedomain.service.vo.StudentVo;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @anthor on 2019/4/19
 * @since jdk8
 */
@Api(value = "学生课程相关管理器", description = "学生课程相关的操作都在里面进行")
@Slf4j
@RestController
@RequestMapping(value = "studentCourse")
public class StudentCourseController {

    @Resource
    private StudentCourseBusinessMapper studentCourseBusinessMapper;

    @Autowired
    private AccountService accountService;

    @Resource
    private TeacherBusinessMapper teacherBusinessMapper;

    @Resource
    private TeacherCourseBusinessMapper teacherCourseBusinessMapper;

    @PostMapping(value = "/course")
    public RespondsMessage addCourse(@RequestParam(value = "courseId") Integer courseId,
                                     @RequestParam(value = "teacherAccountId") Integer accountId,
                                     Principal principal) {

        TeacherCourseModel teacherCourseModel = new TeacherCourseModel();
        teacherCourseModel.setCourseId(courseId);
        teacherCourseModel.setTeacherAccountId(accountId);
        List<TeacherCourseModel> select = teacherCourseBusinessMapper.select(teacherCourseModel);


        if (CollUtil.isEmpty(select)) {
            return RespondsMessage.success(LogUtil.logInfo(log, "老师{}没有传授课程{}"
                    , accountId, courseId));
        }
        select.sort((o1, o2) -> o2.getId() - o1.getId());
        TeacherCourseModel join = select.get(0);

        StudentVo studentByAccountName
                = accountService.findStudentByAccountName(principal.getName());
        Integer id = studentByAccountName.getId();
        StudentCourseModel studentCourseModel
                = new StudentCourseModel();
        studentCourseModel.setTeachCourseId(join.getId());
        studentCourseModel.setStudentId(id);
        studentCourseModel.setCreateTime(new Date());
        studentCourseModel.setUpdateTime(new Date());
        studentCourseBusinessMapper.insertSelective(studentCourseModel);
        return RespondsMessage.success(LogUtil.logInfo(log, "学生{}加入课程完成{},授课老师为：{}"
                , principal.getName(), courseId, join.getTeacherAccountId()));
    }

    @GetMapping(value = "/findTeacher")
    public RespondsMessage findCourseTeachers(@RequestParam(value = "courseId") Integer courseId) {

        List<TeacherModel> teacherByCourseId = teacherBusinessMapper.findTeacherByCourseId(courseId);

        return RespondsMessage.success(LogUtil.logInfo(log, "通过课程id{}找到了老师：{}"
                , courseId, teacherByCourseId), teacherByCourseId);
    }

}
