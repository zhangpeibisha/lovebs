package org.nix.lovedomain.web.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.model.TeacherModel;
import org.nix.lovedomain.service.TeacherService;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.web.controller.dto.CreateTeacherDto;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class TeacherController  {

    @Autowired
    private TeacherService teacherService;


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

}
