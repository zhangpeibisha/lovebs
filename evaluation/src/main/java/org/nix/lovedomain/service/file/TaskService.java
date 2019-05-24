package org.nix.lovedomain.service.file;

import cn.hutool.core.collection.CollUtil;
import org.nix.lovedomain.dao.business.CourseBusinessMapper;
import org.nix.lovedomain.dao.model.CourseModel;
import org.nix.lovedomain.service.file.model.CourseExcel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/5/22
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TaskService {

    @Resource
    private OrganizationService commonService;

    @Resource
    private CourseBusinessMapper courseBusinessMapper;

    /**
     * 导入课程信息
     * @param path
     */
    public void insertCourse(String path) {
        List<CourseExcel> courseExcels = commonService.readExcel2Bean(path, CourseExcel.class);
        if (CollUtil.isEmpty(courseExcels)) {
            return;
        }
        List<CourseModel> courseModels = new ArrayList<>(courseExcels.size());
        courseExcels.forEach(courseExcel -> courseModels.add(createCourseModel(courseExcel)));
        courseBusinessMapper.insertList(courseModels);
    }

    public CourseModel createCourseModel(CourseExcel courseExcel) {
        String courseId = courseExcel.getCourseId();
        String courseName = courseExcel.getCourseName();
        CourseModel courseModel = new CourseModel();
        courseModel.setName(courseName);
        courseModel.setCoding(courseId);
        courseModel.setDescription(courseName);
        return courseModel;
    }





}
