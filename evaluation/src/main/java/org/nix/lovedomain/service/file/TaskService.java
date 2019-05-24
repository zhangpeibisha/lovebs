package org.nix.lovedomain.service.file;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Validator;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.CourseBusinessMapper;
import org.nix.lovedomain.dao.business.StudentCourseBusinessMapper;
import org.nix.lovedomain.dao.business.TeacherCourseBusinessMapper;
import org.nix.lovedomain.dao.model.*;
import org.nix.lovedomain.service.CourseService;
import org.nix.lovedomain.service.StudentService;
import org.nix.lovedomain.service.TeacherCourseService;
import org.nix.lovedomain.service.file.model.CourseExcel;
import org.nix.lovedomain.service.file.model.StudentTaskExcel;
import org.nix.lovedomain.service.file.model.TeachTaskExcel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

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

    @Resource
    private TeacherCourseService teacherCourseService;

    @Resource
    private StudentService studentService;

    @Resource
    private StudentCourseBusinessMapper studentCourseBusinessMapper;

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


    /**
     * 上传为学生配置的教学任务信息
     *
     * @param path
     */
    public void insertStudentTask(String path) {
        List<StudentTaskExcel> studentTaskExcels
                = organizationService.readExcel2Bean(path, StudentTaskExcel.class);
        Validator.validateNotNull(studentTaskExcels, "为学生配置的教学任务为空");
        List<StudentCourseModel> studentCourseList = new ArrayList<>(studentTaskExcels.size());
        studentTaskExcels.forEach(studentTaskExcel -> {
            try {
                List<StudentCourseModel> studentCourse = createStudentCourse(studentTaskExcel);
                studentCourseList.addAll(studentCourse);
            } catch (Exception e) {
                log.warn("为学生配置教学任务失败:{}", e.getMessage(), e);
            }
        });
        studentCourseBusinessMapper.insertList(studentCourseList);
    }


    /**
     * 为这个班级的学生配置教学任务
     *
     * @param studentTaskExcel 学生的上课任务
     * @return 为这个班级的所有学生配置这个教学任务
     */
    public List<StudentCourseModel> createStudentCourse(StudentTaskExcel studentTaskExcel) {

        String classCoding = studentTaskExcel.getClassCoding();
        String teachCourseId = studentTaskExcel.getTeachCourseId();

        TeacherCourseModel teacherCourseModel
                = teacherCourseService.findTeachTaskByTeachCourseId(teachCourseId);
        Validator.validateNotNull(teacherCourseModel, "教学任务{}不存在", teachCourseId);
        List<StudentModel> studentModels
                = studentService.findStudentModelsByClassCoding(classCoding);
        Validator.validateNotNull(studentModels, "该班级{}没有学生", teachCourseId);

        List<StudentCourseModel> result = new ArrayList<>(studentModels.size());

        studentModels.forEach(studentModel -> {
            Integer accountId = studentModel.getAccountId();
            StudentCourseModel studentCourseModel = new StudentCourseModel();
            studentCourseModel.setStudentAccountId(accountId);
            studentCourseModel.setTeachCourseId(teachCourseId);
            studentCourseModel.setCreateTime(new Date());
            studentCourseModel.setUpdateTime(new Date());
            result.add(studentCourseModel);
        });
        return result;
    }

}
