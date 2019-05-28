package org.nix.lovedomain.web.controller;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.CourseBusinessMapper;
import org.nix.lovedomain.dao.model.CourseModel;
import org.nix.lovedomain.service.CourseService;
import org.nix.lovedomain.service.enums.Permission;
import org.nix.lovedomain.service.enums.RoleEnum;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 */
@Slf4j
@RestController
@RequestMapping(value = "course")
public class CourseController{

    @Autowired
    CourseService courseService;

    @Resource
    private CourseBusinessMapper coueseBusinessMapper;

    @GetMapping(value = "/quire/list")
    public RespondsMessage findTeacherPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                           @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                           @RequestParam(value = "quire", required = false) String sql) throws IOException {
        PageVo<CourseModel> courseList = courseService.findCourseList(page, limit, sql);
        return RespondsMessage.success("获取课程列表成功",courseList);
    }

    @DeleteMapping(value = "/ids")
    public RespondsMessage deleteByIds(@RequestParam(value = "ids")StringBuilder ids){
        if (!StrUtil.isEmpty(ids)){
            ids = ids.delete(ids.lastIndexOf(","),ids.length());
        }
        int number = coueseBusinessMapper.deleteByIds(ids.toString());
        return RespondsMessage.success(LogUtil.logInfo(log,"删除课程{}个",number));
    }

    /**
     * 上传课程信息，管理员使用
     * @param course
     */
    @Permission(name = "excel上传课程信息",
            description = "管理员通过上传格式化的excel文件，可以达到批量上传课程信息目的",
            role = RoleEnum.MANGER)
    @PostMapping(value = "/excel")
    public void uploadCourse(MultipartFile course){
        log.info("上传的文件名字为{}",course.getOriginalFilename());
        log.info("上传的文件的大小为{}",course.getSize());
    }


}
