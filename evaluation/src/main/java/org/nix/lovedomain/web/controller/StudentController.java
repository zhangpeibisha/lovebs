package org.nix.lovedomain.web.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.model.Student;
import org.nix.lovedomain.service.StudentService;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.service.vo.StudentVo;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 学生控制器
 * @date 2019/5/1
 */
@Api(value = "学生管理", description = "学生相关信息获取")
@Slf4j
@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/list")
    public void findStudentPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                @RequestParam(value = "quire", required = false) String sql,
                                HttpServletResponse response) throws IOException {
        PageVo<StudentVo> studentVoPageVo = studentService.studentVODetailList(page, limit, sql);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSONUtil.toJsonStr(RespondsMessage.success("获取学生列表成功",
                studentVoPageVo)));
    }

    /**
     * 更新学生信息
     *
     * @param student
     * @return
     */
    @PutMapping(value = "/info")
    public RespondsMessage updateStudent(@ModelAttribute Student student) {
        studentService.updateStudent(student);
        return RespondsMessage.success("更新学生信息成功");
    }

    /**
     * 批量添加学生
     *
     * @param students
     * @return
     */
    @PostMapping(value = "/register/list")
    public RespondsMessage registerStudents(@RequestBody List<Student> students) {
        if (CollUtil.isEmpty(students)) {
            return RespondsMessage.success("没有需要添加的学生");
        }
        studentService.registerStudent(students);
        return RespondsMessage.success(LogUtil.logInfo(log, "添加学生成功:共：{}人",
                students.size()));
    }

    /**
     * 通过学生id批量删除
     *
     * @param studentIds
     * @return
     */
    @DeleteMapping(value = "/list")
    public RespondsMessage deleteStudentByIds(@RequestParam(value = "ids") List<Integer> studentIds) {
        if (CollUtil.isEmpty(studentIds)) {
            return RespondsMessage.success("没有需要删除的学生");
        }
        studentService.delteStudent(studentIds);
        return RespondsMessage.success(LogUtil.logInfo(log, "删除学生成功:共：{}人",
                studentIds.size()));
    }
}
