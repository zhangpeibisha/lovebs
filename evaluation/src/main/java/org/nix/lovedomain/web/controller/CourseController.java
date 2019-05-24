package org.nix.lovedomain.web.controller;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.CourseBusinessMapper;
import org.nix.lovedomain.dao.model.CourseModel;
import org.nix.lovedomain.service.CourseService;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
