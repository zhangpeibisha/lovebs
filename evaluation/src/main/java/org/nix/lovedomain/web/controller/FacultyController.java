package org.nix.lovedomain.web.controller;

import cn.hutool.json.JSONUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.FacultyBusinessMapper;
import org.nix.lovedomain.dao.model.FacultyModel;
import org.nix.lovedomain.dao.model.TeacherModel;
import org.nix.lovedomain.service.FacultyService;
import org.nix.lovedomain.service.enums.Permission;
import org.nix.lovedomain.service.enums.RoleEnum;
import org.nix.lovedomain.service.file.OrganizationService;
import org.nix.lovedomain.service.vo.FacultyTeacherVo;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 */
@Slf4j
@Api(value = "学院服务控制器(测试通过)")
@RestController
@RequestMapping(value = "faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @Resource
    private OrganizationService organizationService;

    @Resource
    private FacultyBusinessMapper facultyBusinessMapper;

    @Permission(name = "查询学院信息列表", role = RoleEnum.MANGER)
    @GetMapping(value = "/quire/list")
    public void findStudentPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                @RequestParam(value = "quire", required = false) String sql,
                                HttpServletResponse response) throws IOException {
        PageVo<FacultyTeacherVo> studentVoPageVo = facultyService.findFacultyPage(page, limit, sql);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSONUtil.toJsonStr(RespondsMessage.success("获取学院列表成功",
                studentVoPageVo)));
    }


    @Permission(name = "通过学院id查询学院信息")
    @GetMapping(value = "/findById")
    public RespondsMessage findById(@RequestParam(value = "id") Integer id) {
        return RespondsMessage.success("通过id查询完成",
                facultyBusinessMapper.selectByPrimaryKey(id));
    }


    /**
     * 上传学院信息，管理员使用
     *
     * @param faculty
     */
    @Permission(name = "excel上传学院信息",
            description = "管理员通过上传格式化的excel文件，可以达到批量上传学院信息目的",
            role = RoleEnum.MANGER)
    @PostMapping(value = "/excel")
    public void uploadFaculty(MultipartFile faculty) throws IOException {
        organizationService.insertFaculty(faculty.getInputStream());
    }

    /**
     * 查看用户能够获取的学院列表，管理员获取
     * 所有的，老师获取自己所属的学院，学生暂时没有配置
     *
     * @param principal
     * @return
     */
    @Permission(name = "查询用户自己可以查看的学院列表")
    @GetMapping(value = "/user/faculty")
    public RespondsMessage findUserFaculty(Principal principal) {
        return RespondsMessage.success("获取用户可以查看的学院列表成功",
                facultyService.findUserFaculty(principal));
    }

    @Permission(name = "更新学院信息", role = RoleEnum.MANGER)
    @PutMapping(value = "/update")
    public RespondsMessage update(@ModelAttribute FacultyModel facultyModel) {
        facultyBusinessMapper.updateByPrimaryKeySelective(facultyModel);
        return RespondsMessage.success("更新学院信息成功");
    }

    @Permission(name = "添加学院信息", role = RoleEnum.MANGER)
    @PostMapping(value = "/add")
    public RespondsMessage add(@ModelAttribute FacultyModel facultyModel) {
        facultyBusinessMapper.insertSelective(facultyModel);
        return RespondsMessage.success("添加学院信息成功");
    }
}
