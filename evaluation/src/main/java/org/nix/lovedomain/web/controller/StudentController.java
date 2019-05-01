package org.nix.lovedomain.web.controller;

import cn.hutool.json.JSONUtil;
import io.swagger.annotations.Api;
import org.nix.lovedomain.dao.business.page.StudentPageInquire;
import org.nix.lovedomain.service.StudentService;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.service.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhangpei
 * @version 1.0
 * @description 学生控制器
 * @date 2019/5/1
 */
@Api(value = "学生管理", description = "学生相关信息获取")
@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/list")
    public void findStudentPage(@RequestParam(required = false) String key,
                                @RequestParam(required = false) String word,
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
