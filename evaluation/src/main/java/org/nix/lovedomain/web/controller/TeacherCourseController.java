package org.nix.lovedomain.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.service.TeacherCourseService;
import org.nix.lovedomain.service.enums.Permission;
import org.nix.lovedomain.service.enums.RoleEnum;
import org.nix.lovedomain.service.enums.SemesterEnum;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 */
@Slf4j
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

    /**
     * 上传教学任务信息，管理员使用
     * @param teachTask
     */
    @Permission(name = "excel上传教学任务",
            description = "管理员通过上传格式化的excel文件，可以达到批量上传教学任务的目的",
            role = RoleEnum.MANGER)
    @PostMapping(value = "/excel/teachTask")
    public void uploadTeachTask(MultipartFile teachTask){
        log.info("上传的文件名字为{}",teachTask.getOriginalFilename());
        log.info("上传的文件的大小为{}",teachTask.getSize());
    }

}
