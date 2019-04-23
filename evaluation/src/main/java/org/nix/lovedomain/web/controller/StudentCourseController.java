package org.nix.lovedomain.web.controller;

import cn.hutool.json.JSONUtil;
import io.swagger.annotations.Api;
import org.nix.lovedomain.dao.business.page.StudentPageInquire;
import org.nix.lovedomain.model.StudentCourse;
import org.nix.lovedomain.service.StudentService;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.service.vo.StudentVo;
import org.nix.lovedomain.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0
 * @anthor on 2019/4/19
 * @since jdk8
 */
@Api(value = "学生相关管理器", description = "学生相关的操作都在里面进行")
@RestController
@RequestMapping(value = "studentCourse")
public class StudentCourseController extends BaseController<StudentCourse> {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/list/{key}/{word}")
    public void findStuentPage(@PathVariable(required = false) String key,
                                 @PathVariable(required = false) String word,
                                 @RequestParam(defaultValue = "false") boolean blurry,
                                 @RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "limit", defaultValue = "1") Integer limit,
                                 HttpServletResponse response) throws IOException {
        StudentPageInquire pageInquire = new StudentPageInquire();
        pageInquire.setQuireField(key);
        pageInquire.setQuireValue(word);
        pageInquire.setPage(page, limit);
        pageInquire.setBlurry(blurry);
        PageVo<StudentVo> studentVoPageVo = studentService.studentVODeatilList(pageInquire);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSONUtil.toJsonStr(studentVoPageVo));
    }

}
