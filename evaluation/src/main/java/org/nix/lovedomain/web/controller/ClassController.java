package org.nix.lovedomain.web.controller;

import cn.hutool.json.JSONUtil;
import io.swagger.annotations.Api;
import org.nix.lovedomain.model.Class;
import org.nix.lovedomain.service.ClassService;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.web.controller.base.BaseController;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0
 * @anthor on 2019/4/19
 * @since jdk8
 */
@Api(value = "班级管理器(测试通过)")
@RestController
@RequestMapping(value = "class")
public class ClassController extends BaseController<Class> {

    @Autowired
    private ClassService classService;

    @GetMapping(value = "/quire/list")
    public void findStudentPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                @RequestParam(value = "quire", required = false) String sql,
                                HttpServletResponse response) throws IOException {
        PageVo<Class> studentVoPageVo = classService.findClassPage(page, limit, sql);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSONUtil.toJsonStr(RespondsMessage.success("获取班级列表成功",
                studentVoPageVo)));
    }

}
