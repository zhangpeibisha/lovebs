package org.nix.lovedomain.web.controller;

import org.nix.lovedomain.service.TeacherCourseService;
import org.nix.lovedomain.service.enums.SemesterEnum;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 */
@RestController
@RequestMapping(value = "teacherCourse")
public class TeacherCourseController {

    @Resource
    private TeacherCourseService teacherCourseService;

    /**
     * @param page         页码
     * @param limit        数量
     * @param principal    登陆用户
     * @param year         学年
     * @param semesterEnum 学期
     * @return 响应信息
     */
    @GetMapping(value = "/teachTask")
    public RespondsMessage findUserTeachTask(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                             @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                             Principal principal,
                                             @RequestParam(value = "year", required = false) Integer year,
                                             @RequestParam(value = "semester", required = false) SemesterEnum semesterEnum) {
        return RespondsMessage.success("获取教学任务成功",
                teacherCourseService.teachTaskPage(page, limit, principal, year, semesterEnum));
    }

    /**
     * 获取用户所有学年任务的学年值列表
     *
     * @param principal 登陆用户
     * @return 相应信息
     */
    @GetMapping(value = "/school/year")
    public RespondsMessage findUserTeachTaskHaveYear(Principal principal) {
        return RespondsMessage.success("获取用户学年列表成功", teacherCourseService.findSchoolYearByTaskList(principal));
    }

}
