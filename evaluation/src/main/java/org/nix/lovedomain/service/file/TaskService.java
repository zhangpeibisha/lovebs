package org.nix.lovedomain.service.file;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Validator;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.CourseBusinessMapper;
import org.nix.lovedomain.dao.business.TeacherCourseBusinessMapper;
import org.nix.lovedomain.dao.business.json.student.StudentTask;
import org.nix.lovedomain.dao.model.CourseModel;
import org.nix.lovedomain.dao.model.StudentCourseModel;
import org.nix.lovedomain.dao.model.TeacherCourseModel;
import org.nix.lovedomain.dao.model.TeacherModel;
import org.nix.lovedomain.service.CourseService;
import org.nix.lovedomain.service.file.model.CourseExcel;
import org.nix.lovedomain.service.file.model.StduentTaskExcel;
import org.nix.lovedomain.service.file.model.TeachTaskExcel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/5/22
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class TaskService {

    @Resource
    private OrganizationService organizationService;

    @Resource
    private CourseBusinessMapper courseBusinessMapper;

    @Resource
    private CourseService courseService;

    @Resource
    private TeacherCourseBusinessMapper teacherCourseBusinessMapper;

    /**
     * 导入课程信息
     *
     * @param path
     */
    public void insertCourse(String path) {
        List<CourseExcel> courseExcels = organizationService.readExcel2Bean(path, CourseExcel.class);
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


    public void insertTeachTask(String path) {
        List<TeachTaskExcel> teachTaskExcels
                = organizationService.readExcel2Bean(path, TeachTaskExcel.class);
        Validator.validateNotNull(teachTaskExcels, "课程任务不存在");
        List<TeacherCourseModel> teacherCourseModels = new ArrayList<>(teachTaskExcels.size());
        teachTaskExcels.forEach(teachTaskExcel -> {
            try {
                teacherCourseModels.add(createTeachTask(teachTaskExcel));
            } catch (Exception e) {
                log.warn("发生错误：{}", e.getMessage(), e);
            }
        });
        if (!CollUtil.isEmpty(teacherCourseModels)) {
            teacherCourseBusinessMapper.insertList(teacherCourseModels);
        }
    }

    /**
     * 创建一个教学任务对象
     *
     * @param teachTaskExcel 从excel中导入教学任务
     * @return 教学任务对象
     */
    public TeacherCourseModel createTeachTask(TeachTaskExcel teachTaskExcel) {
        // 教学计划中的课程在学校编码中的id
        String courseCoding = teachTaskExcel.getCourseCoding();
        // 教学计划唯一id
        String teachCourseId = teachTaskExcel.getTeachCourseId();
        String teacherName = teachTaskExcel.getTeacherName();
        // 发现授课老师
        TeacherModel teacherModel
                = organizationService.findTeacherModelByName(teacherName);
        Validator.validateNotNull(teacherModel, "教学计划{}的授课老师不存在", teachCourseId);

        CourseModel courseModel = courseService.findCourseModelByCourseCoding(courseCoding);
        Validator.validateNotNull(courseModel, "课程编号为{}的课程不存在，无法发布教学任务", courseCoding);

        // 授课老师的账号id
        Integer teacherModelAccountId = teacherModel.getAccountId();
        // 教学计划开始的时间戳
        Date teachStartTime = teachTaskExcel.findTeachStartTime();
        Date teachEndTime = teachTaskExcel.findTeachEndTime();
        // 教学计划的开始周和结束周
        int teachStartWeek = teachTaskExcel.findTeachStartWeek();
        int teachEndWeek = teachTaskExcel.findTeachEndWeek();
        // 学年
        Integer year = teachTaskExcel.getYear();
        // 第几学期
        String semester = teachTaskExcel.getSemester();

        TeacherCourseModel teacherCourseModel = new TeacherCourseModel();
        // 设置课程计划id
        teacherCourseModel.setTeachCourseId(teachCourseId);
        // 设置授课老师的账号id
        teacherCourseModel.setTeacherAccountId(teacherModelAccountId);
        // 设置课程自增主键
        teacherCourseModel.setCourseId(courseModel.getId());
        // 设置课程开始时间
        teacherCourseModel.setStartTime(teachStartTime);
        // 设置课程结束时间
        teacherCourseModel.setEndTime(teachEndTime);
        // 设置开始周
        teacherCourseModel.setStartWeek(teachStartWeek);
        // 设置结束周
        teacherCourseModel.setEndWeek(teachEndWeek);
        // 设置学年
        teacherCourseModel.setSchoolYear(year);
        // 设置学期
        teacherCourseModel.setSemester(semester);
        // 设置创建时间
        teacherCourseModel.setCreateTime(new Date());
        // 设置更新时间
        teacherCourseModel.setUpdateTime(new Date());
        return teacherCourseModel;
    }


    public StudentCourseModel createStudentCourse(StduentTaskExcel stduentTaskExcel) {

        return null;
    }

}
