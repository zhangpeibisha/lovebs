package org.nix.lovedomain.web.controller;

import cn.hutool.core.collection.CollUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.StudentBusinessMapper;
import org.nix.lovedomain.dao.model.StudentModel;
import org.nix.lovedomain.service.StudentService;
import org.nix.lovedomain.service.enums.Permission;
import org.nix.lovedomain.service.enums.RoleEnum;
import org.nix.lovedomain.service.file.OrganizationService;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.service.vo.StudentVo;
import org.nix.lovedomain.utils.ListUtils;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
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

    @Resource
    private OrganizationService organizationService;

    @Resource
    private StudentBusinessMapper studentBusinessMapper;

    @Permission(name = "查询学生列表", role = RoleEnum.MANGER)
    @GetMapping(value = "/list")
    public RespondsMessage findStudentPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                           @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                           @RequestParam(value = "quire", required = false) String sql) throws IOException {
        PageVo<StudentVo> studentVoPageVo = studentService.studentVODetailListNotHaveTeacher(page, limit, sql);
        return RespondsMessage.success("获取学生列表成功", studentVoPageVo);
    }

    /**
     * 批量添加学生
     *
     * @param students
     * @return
     */
    @Permission(name = "批量添加学生", role = RoleEnum.MANGER)
    @PostMapping(value = "/register/list")
    public RespondsMessage registerStudents(@RequestBody List<StudentModel> students) {
        if (CollUtil.isEmpty(students)) {
            return RespondsMessage.success("没有需要添加的学生");
        }
        studentService.registerStudent(students);
        return RespondsMessage.success(LogUtil.logInfo(log, "添加学生成功:共：{}人",
                students.size()));
    }

    /**
     * 上传学生信息，管理员使用
     *
     * @param student
     */
    @Permission(name = "excel上传学生信息",
            description = "通过excel上传学生信息（模拟学生）",
            role = RoleEnum.MANGER)
    @PostMapping(value = "/excel")
    public void uploadTeachTask(MultipartFile student) throws IOException {
        organizationService.insertStudent(student.getInputStream());
    }

    /**
     * 通过学生账户id集合，获取到学生信息
     *
     * @param studentAccountIds 学生账户id集合
     * @return 响应信息
     */
    @Permission(name = "通过学生id集合查询学生信息", role = {RoleEnum.MANGER,RoleEnum.TEACHER})
    @GetMapping(value = "/find/by/ids")
    public RespondsMessage findStudentByIds(@RequestParam(value = "ids") List<Integer> studentAccountIds) {
        List<StudentModel> accountIds
                = studentBusinessMapper.findStudentModelByAccountIds(studentAccountIds);
        return RespondsMessage.success("获取学生信息完成", accountIds);
    }

    @Permission(name = "更新学生信息", role = RoleEnum.MANGER)
    @PutMapping(value = "/info")
    public RespondsMessage update(@ModelAttribute StudentModel studentModel) {
        studentBusinessMapper.updateByPrimaryKeySelective(studentModel);
        return RespondsMessage.success("更新学生信息完成");
    }
}
