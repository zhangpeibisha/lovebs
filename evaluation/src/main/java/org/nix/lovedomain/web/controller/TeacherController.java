package org.nix.lovedomain.web.controller;

import io.swagger.annotations.Api;
import org.nix.lovedomain.model.Teacher;
import org.nix.lovedomain.service.TeacherService;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.service.vo.StudentVo;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author zhangpei
 * @version 1.0
 * @description 老师管理控制器
 * @date 2019/5/2
 */
@Api(value = "老师控制器")
@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping(value = "/quire/list")
    public RespondsMessage findStudentPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                           @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                           @RequestParam(value = "quire", required = false) String sql) throws IOException {
        PageVo<Teacher> studentVoPageVo = teacherService.findTeacherList(page, limit, sql);
        return RespondsMessage.success("获取老师列表成功",studentVoPageVo);
    }


}
