package org.nix.lovedomain.web.controller;

import io.swagger.annotations.Api;
import org.nix.lovedomain.model.StudentCourse;
import org.nix.lovedomain.web.controller.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @anthor on 2019/4/19
 * @since jdk8
 */
@Api(value = "学生课程相关管理器", description = "学生课程相关的操作都在里面进行")
@RestController
@RequestMapping(value = "studentCourse")
public class StudentCourseController extends BaseController<StudentCourse> {



}
