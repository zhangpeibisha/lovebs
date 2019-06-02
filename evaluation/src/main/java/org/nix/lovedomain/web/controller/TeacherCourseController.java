package org.nix.lovedomain.web.controller;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.security.UserDetail;
import org.nix.lovedomain.service.StatisticsScoreService;
import org.nix.lovedomain.service.TeacherCourseService;
import org.nix.lovedomain.service.constant.CacheConstant;
import org.nix.lovedomain.service.enums.Permission;
import org.nix.lovedomain.service.enums.RoleEnum;
import org.nix.lovedomain.service.enums.SemesterEnum;
import org.nix.lovedomain.service.file.TaskService;
import org.nix.lovedomain.service.vo.TeachRankVo;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
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

    @Resource
    private TaskService taskService;

    @Resource
    private StatisticsScoreService statisticsScoreService;

    /**
     * @param page         页码
     * @param limit        数量
     * @param principal    登陆用户
     * @param year         学年
     * @param semesterEnum 学期
     * @return 响应信息
     */
    @Permission(name = "查询教学任务",description = "查询自己权限能获取到的教学任务")
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
    @Permission(name = "查询学年",description = "查询自己权限能获取到的教学任务的学年集合")
    @GetMapping(value = "/school/year")
    public RespondsMessage findUserTeachTaskHaveYear(Principal principal) {
        return RespondsMessage.success("获取用户学年列表成功", teacherCourseService.findSchoolYearByTaskList(principal));
    }

    /**
     * 上传教学任务信息，管理员使用
     * 需要删除用户任务的数量缓存
     *
     * @param teachTask
     */
    @CacheEvict(cacheNames = CacheConstant.USER_TEACH_TASK_NUMBER, allEntries = true)
    @Permission(name = "excel上传教学任务",
            description = "管理员通过上传格式化的excel文件，可以达到批量上传教学任务的目的",
            role = RoleEnum.MANGER)
    @PostMapping(value = "/excel/teachTask")
    public void uploadTeachTask(MultipartFile teachTask, Principal principal) throws IOException {
        Integer accountId = UserDetail.analysisUserAccountId(principal);
        taskService.insertTeachTask(teachTask.getInputStream(), accountId);
    }

    /**
     * 上传学生课程分数，授课老师上传
     *
     * @param teachCourScore
     */
    @Permission(name = "excel上传学生的课程得分信息",
            role = RoleEnum.TEACHER)
    @PostMapping(value = "/excel/teachCourScore")
    public void teachCourScore(MultipartFile teachCourScore, Principal principal) throws IOException {
        log.info("上传的文件名字为{}", teachCourScore.getOriginalFilename());
        log.info("上传的文件的大小为{}", teachCourScore.getSize());
        taskService.updateStudentCourseScore(teachCourScore.getInputStream(), principal);
    }


    /**
     * 查询一个学院在学年+学期的排名统计
     *
     * @param facultyId 学院自增id
     * @param year      学年
     * @param semester  学期
     * @return
     */
    @Permission(name = "查询排名",description = "老师和管理员可以查看排名信息",role = {RoleEnum.MANGER,RoleEnum.TEACHER})
    @GetMapping(value = "/faculty/rank")
    public RespondsMessage findRankByFacultyAndYearAndSemester(@RequestParam(value = "facultyId") Integer facultyId,
                                                               @RequestParam(value = "year") Integer year,
                                                               @RequestParam(value = "semester") String semester) {
        TeachRankVo rankVo = statisticsScoreService.findFacultyTeachRankVo(facultyId, year, semester);
        return RespondsMessage.success(StrUtil.format("获取{}学院-{}学年-{}的排名信息完成", facultyId, year, semester), rankVo);
    }

}
