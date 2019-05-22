package org.nix.lovedomain.service.file;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.nix.lovedomain.dao.business.ProfessionBusinessMapper;
import org.nix.lovedomain.dao.mapper.ClassMapper;
import org.nix.lovedomain.dao.mapper.CourseMapper;
import org.nix.lovedomain.dao.mapper.TeacherCourseMapper;
import org.nix.lovedomain.dao.mapper.TeacherMapper;
import org.nix.lovedomain.model.Class;
import org.nix.lovedomain.model.*;
import org.nix.lovedomain.service.ProfessionService;
import org.nix.lovedomain.service.StudentService;
import org.nix.lovedomain.service.TeacherService;
import org.nix.lovedomain.web.controller.StudentCourseController;
import org.nix.lovedomain.web.controller.TeacherController;
import org.nix.lovedomain.web.controller.dto.CreateTeacherDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/5/22
 */
@Service
public class TaskService {

    public List<Courser> getTask(String filePath) {
        ExcelReader reader = ExcelUtil.getReader(filePath);
        List<Map<String, Object>> readAll = reader.readAll();
        List<Courser> coursers = new ArrayList<>();
        readAll.forEach(new Consumer<Map<String, Object>>() {
            @Override
            public void accept(Map<String, Object> map) {
                Courser courser = JSON.parseObject(JSON.toJSONString(map), Courser.class);
                coursers.add(courser);
            }
        });
        return coursers;
    }


    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private TeacherController teacherController;

    public Teacher createTeacher(String teacherName) {
        TeacherExample example = new TeacherExample();
        example.createCriteria().andNameEqualTo(teacherName);
        List<Teacher> teachers = teacherMapper.selectByExample(example);
        if (CollUtil.isEmpty(teachers)) {
            CreateTeacherDto dto = new CreateTeacherDto();
            dto.setEmail(StrUtil.format("{}@163.com", teacherName));
            dto.setJobNumber(teacherName);
            dto.setName(teacherName);
            dto.setPhone(teacherName);
            teacherController.createTeacher(dto);
        }
        teachers = teacherMapper.selectByExample(example);
        if (!CollUtil.isEmpty(teachers)) {
            return teachers.get(0);
        }
        return null;
    }


    @Resource
    private CourseMapper courseMapper;

    public Course createCourse(String courseName, String courseCoding) {
        Course courseModel = new Course();
        courseModel.setCoding(courseCoding);
        courseModel.setName(courseName);
        courseMapper.insertSelective(courseModel);
        return courseModel;
    }


    public void inserDatabases(String filePath) {
        List<Courser> task = getTask(filePath);
        task.forEach(new Consumer<Courser>() {
            @Override
            public void accept(Courser courser) {
                try {
                    inserTask(courser);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Resource
    private TeacherCourseMapper teacherCourseMapper;

    @Resource
    private StudentCourseController studentCourseController;

    @Resource
    private TeacherService teacherService;

    public void inserTask(Courser courser) throws Exception {

        // 创建一个课程
        String courseName = courser.getCourseName();
        String courseId = courser.getCourseId();
        Course course = createCourse(courseName, courseId);

        // 创建一个老师/或者找到一个老师
        String teacherName = courser.getTeacherName();
        Teacher teacher = createTeacher(teacherName);

        // 给老师添加课程
        if (teacher != null) {
            TeacherCourse teacherCourse = new TeacherCourse();
            teacherCourse.setCourseid(course.getId());
            teacherCourse.setTeacherid(teacher.getId());
            teacherCourseMapper.insertSelective(teacherCourse);
        }

        // 创建一个专业
        org.nix.lovedomain.dao.model.Profession profession
                = createProfession(courser.getProfessionName());

        // 创建一个班级
        Class creaateClas = createClass(courser.getClassId(),profession.getId());

        // 创建学生
        createStudent(creaateClas.getId());

        // 学生加入课程
        assert teacher != null;
        Integer accountId = teacherService.findTeacherAccountById(teacher.getId()).getId();
        studentCourseController.addCourse(course.getId(), accountId, new Principal() {
            @Override
            public String getName() {
                return "张沛测试";
            }
        });

    }





    @Resource
    private ClassMapper classMapper;

    public Class createClass(String coding,Integer prossionId) {
        Class classNumber = new Class();
        int classid = Integer.parseInt(coding);
        classNumber.setClassid(classid);
        ClassExample example = new ClassExample();
        example.createCriteria().andClassidEqualTo(classid);
        List<Class> classes = classMapper.selectByExample(example);
        if (CollUtil.isEmpty(classes)) {
            classNumber.setProfessionid(prossionId);
            classMapper.insertSelective(classNumber);
        }
        return classNumber;
    }

    @Resource
    private ProfessionBusinessMapper professionBusinessMapper;

    @Resource
    private ProfessionService professionService;

    public org.nix.lovedomain.dao.model.Profession createProfession(String professionName) throws Exception {
        org.nix.lovedomain.dao.model.Profession profession = new org.nix.lovedomain.dao.model.Profession();
        profession.setName(professionName);
        List<org.nix.lovedomain.dao.model.Profession> select
                = professionBusinessMapper.select(profession);
        if (CollUtil.isEmpty(select)) {
            // 创建专业
            Profession createProfession = new Profession();
            createProfession.setName(professionName);
            createProfession.setCoding("随机专业编号" + (int) (Math.random() * 10000));
            professionService.add(createProfession);
        }
        List<org.nix.lovedomain.dao.model.Profession> find
                = professionBusinessMapper.select(profession);
        if (!CollUtil.isEmpty(find)){
            return find.get(0);
        }
        return null;
    }

    @Resource
    private StudentService studentService;

    public Student createStudent(Integer classId) {
        Student student = new Student();
        student.setClassid(classId);
        student.setStudentid("随机学号" + (int) (Math.random() * 10000));
        student.setName("随机学生名字" + (int) (Math.random() * 10000));
        studentService.registerStudent(CollUtil.newArrayList(student));
        return student;
    }

    @Data
    public static class Courser {

        private String courseId;

        private String courseName;

        private String classId;

        private String startTime;

        private String teacherName;

        private String professionName;

        private String planId;

    }

}
