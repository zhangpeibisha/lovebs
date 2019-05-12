package org.nix.lovedomain.web.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Filter;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.StudentCourseBusinessMapper;
import org.nix.lovedomain.dao.mapper.StudentCourseMapper;
import org.nix.lovedomain.dao.model.StudentCourseBusinessModel;
import org.nix.lovedomain.model.StudentCourse;
import org.nix.lovedomain.service.AccountService;
import org.nix.lovedomain.service.StudentService;
import org.nix.lovedomain.service.vo.StudentVo;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.web.controller.base.BaseController;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @version 1.0
 * @anthor on 2019/4/19
 * @since jdk8
 */
@Api(value = "学生课程相关管理器", description = "学生课程相关的操作都在里面进行")
@Slf4j
@RestController
@RequestMapping(value = "studentCourse")
public class StudentCourseController extends BaseController<StudentCourse> {

    @Resource
    private StudentCourseBusinessMapper studentCourseBusinessMapper;

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/course")
    public RespondsMessage addCourse(@RequestParam(value = "courseIds") List<Integer> courseIds,
                                     Principal principal) {

        courseIds = CollUtil.filter(courseIds, Objects::nonNull);
        StudentVo studentByAccountName
                = accountService.findStudentByAccountName(principal.getName());
        Integer id = studentByAccountName.getId();
        int size = courseIds.size();
        List<StudentCourseBusinessModel> insertList = new ArrayList<>(size);
        courseIds.forEach(integer -> {
            StudentCourseBusinessModel studentCourseBusinessModel
                    = new StudentCourseBusinessModel();
            studentCourseBusinessModel.setCourseId(integer);
            studentCourseBusinessModel.setStudentId(id);
            studentCourseBusinessModel.setCreateTime(new Date());
            studentCourseBusinessModel.setUpdateTime(new Date());
            insertList.add(studentCourseBusinessModel);
        });
        int insertListNumber = studentCourseBusinessMapper.insertList(insertList);
        if (insertListNumber == size){
            return RespondsMessage.success(LogUtil
                    .logInfo(log,"学生{}加课{}个：{}",principal.getName(),size,courseIds));
        }
        return RespondsMessage.failure(LogUtil
                .logInfo(log,"学生{}加课成功{}个，失败{}个：{}",principal.getName(),
                        insertListNumber,size-insertListNumber,courseIds));
    }

}
