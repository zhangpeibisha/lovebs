package org.nix.lovedomain.web.controller;

import cn.hutool.json.JSONUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.ClassBusinessMapper;
import org.nix.lovedomain.dao.model.ClassModel;
import org.nix.lovedomain.service.ClassService;
import org.nix.lovedomain.service.dto.ClassUpdateDto;
import org.nix.lovedomain.service.enums.Permission;
import org.nix.lovedomain.service.enums.RoleEnum;
import org.nix.lovedomain.service.file.OrganizationService;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 */
@Slf4j
@Api(value = "班级管理器(测试通过)")
@RestController
@RequestMapping(value = "class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @Resource
    private ClassBusinessMapper classBusinessMapper;

    @Resource
    private OrganizationService organizationService;

    @GetMapping(value = "/quire/list")
    public void findStudentPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                @RequestParam(value = "quire", required = false) String sql,
                                HttpServletResponse response) throws IOException {
        PageVo<ClassModel> studentVoPageVo = classService.findClassPage(page, limit, sql);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSONUtil.toJsonStr(RespondsMessage.success("获取班级列表成功",
                studentVoPageVo)));
    }


    /**
     * 上传专业信息，管理员使用
     *
     * @param classFile
     */
    @Permission(name = "excel上传班级信息",
            description = "管理员通过上传格式化的excel文件，可以达到批量上传专业信息目的",
            role = RoleEnum.MANGER)
    @PostMapping(value = "/excel")
    public void uploadClass(MultipartFile classFile) throws IOException {
        organizationService.insertClass(classFile.getInputStream());
    }

    @PutMapping(value = "/update")
    public RespondsMessage update(@ModelAttribute ClassUpdateDto classUpdateDto) {
        classService.updateClass(classUpdateDto);
        return RespondsMessage.success("更新班级信息完成");
    }

    @PostMapping(value = "/add")
    public RespondsMessage add(ClassModel classModel) {
        classBusinessMapper.insertSelective(classModel);
        return RespondsMessage.success("创建班级完成");
    }

}
