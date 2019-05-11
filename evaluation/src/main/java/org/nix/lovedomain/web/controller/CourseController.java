package org.nix.lovedomain.web.controller;

import org.nix.lovedomain.model.Course;
import org.nix.lovedomain.service.CourseService;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.web.controller.base.BaseController;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @version 1.0
 * @anthor on 2019/4/19
 * @since jdk8
 */
@RestController
@RequestMapping(value = "course")
public class CourseController extends BaseController<Course> {

    @Autowired
    CourseService courseService;

    @GetMapping(value = "/quire/list")
    public RespondsMessage findTeacherPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                           @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                           @RequestParam(value = "quire", required = false) String sql) throws IOException {
        PageVo<Course> courseList = courseService.findCourseList(page, limit, sql);
        return RespondsMessage.success("获取课程列表成功",courseList);
    }

}
