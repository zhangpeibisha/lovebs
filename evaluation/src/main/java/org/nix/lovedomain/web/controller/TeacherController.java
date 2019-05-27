package org.nix.lovedomain.web.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.TeacherBusinessMapper;
import org.nix.lovedomain.dao.model.TeacherModel;
import org.nix.lovedomain.service.TeacherService;
import org.nix.lovedomain.service.enums.Permission;
import org.nix.lovedomain.service.enums.RoleEnum;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.web.controller.dto.CreateTeacherDto;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author zhangpei
 * @version 1.0
 * @description 老师管理控制器
 * @date 2019/5/2
 */
@Slf4j
@Api(value = "老师控制器(测试通过)")
@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Resource
    private TeacherBusinessMapper teacherBusinessMapper;

    @GetMapping(value = "/quire/list")
    public RespondsMessage findTeacherPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                           @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                           @RequestParam(value = "quire", required = false) String sql) throws IOException {
        PageVo<TeacherModel> studentVoPageVo = teacherService.findTeacherList(page, limit, sql);
        return RespondsMessage.success("获取老师列表成功", studentVoPageVo);
    }

    @PostMapping(value = "/create")
    public RespondsMessage createTeacher(@ModelAttribute CreateTeacherDto dto) {

        teacherService.createTeacher(dto);

        return RespondsMessage.success("创建老师成功");
    }

    @GetMapping(value = "/findById")
    public RespondsMessage findById(@RequestParam Integer id) {
        TeacherModel teacherModel = new TeacherModel();
        teacherModel.setAccountId(id);
        return RespondsMessage.success("查询老师成功",
                teacherBusinessMapper.selectOne(teacherModel));
    }

    /**
     * 上传老师信息，管理员使用
     * @param teacher
     */
    @Permission(name = "excel上传老师信息",
            description = "通过excel上传老师信息（模拟学生）",
            role = RoleEnum.MANGER)
    @PostMapping(value = "/excel")
    public void uploadTeachTask(MultipartFile teacher){
        log.info("上传的文件名字为{}",teacher.getOriginalFilename());
        log.info("上传的文件的大小为{}",teacher.getSize());
    }

    /**
     * 上传学生课程分数，授课老师上传
     * @param teachCourScore
     */
    @Permission(name = "excel上传学生的课程得分信息",
            role = RoleEnum.TEACHER)
    @PostMapping(value = "/excel/teachCourScore")
    public void teachCourScore(MultipartFile teachCourScore){
        log.info("上传的文件名字为{}",teachCourScore.getOriginalFilename());
        log.info("上传的文件的大小为{}",teachCourScore.getSize());
    }
}
