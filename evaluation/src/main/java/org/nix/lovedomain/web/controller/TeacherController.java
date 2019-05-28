package org.nix.lovedomain.web.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.TeacherBusinessMapper;
import org.nix.lovedomain.dao.model.TeacherModel;
import org.nix.lovedomain.service.TeacherService;
import org.nix.lovedomain.service.enums.Permission;
import org.nix.lovedomain.service.enums.RoleEnum;
import org.nix.lovedomain.service.file.OrganizationService;
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
    private OrganizationService organizationService;

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
    public void uploadTeachTask(MultipartFile teacher) throws IOException {
        organizationService.insertTeacher(teacher.getInputStream());
    }


    /**
     * 为班级、专业、学院分配老师
     *
     * @param configTeacher
     */
    @Permission(name = "excel为班级、专业、学院分配老师",
            description = "管理员通过上传格式化的excel文件，可以达到批量为班级、专业、学院分配老师目的",
            role = RoleEnum.MANGER)
    @PostMapping(value = "/excel/config")
    public void uploadClass(MultipartFile configTeacher) throws IOException {
        organizationService.professionInsertTeacher(configTeacher.getInputStream());
        organizationService.classInsertTeacher(configTeacher.getInputStream());
    }
}
