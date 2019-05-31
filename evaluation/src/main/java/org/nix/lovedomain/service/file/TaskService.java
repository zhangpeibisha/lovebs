package org.nix.lovedomain.service.file;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.*;
import org.nix.lovedomain.dao.business.json.winding.PublishAttachInfo;
import org.nix.lovedomain.dao.model.*;
import org.nix.lovedomain.service.CourseService;
import org.nix.lovedomain.service.StudentService;
import org.nix.lovedomain.service.dto.PublishQuestionnaireArgs;
import org.nix.lovedomain.service.enums.SemesterEnum;
import org.nix.lovedomain.service.file.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
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
    private StudentService studentService;

    @Resource
    private StudentCourseBusinessMapper studentCourseBusinessMapper;

    @Resource
    private StudentBusinessMapper studentBusinessMapper;

    @Resource
    private PublishQuestionBusinessMapper publishQuestionBusinessMapper;


    /**
     * 开始添加教学任务
     *
     * @param path
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertTeachTask(InputStream path, Integer authorAccountId) {
        byte[] bytes = IoUtil.readBytes(path);
        // 为老师添加教学任务
        insertTeachTask(IoUtil.toStream(bytes));
        // 为学生添加课程
        insertStudentTask(IoUtil.toStream(bytes));
        // 生成评教卷信息
        insertPublishQuestionnaire(IoUtil.toStream(bytes), authorAccountId);
    }


    /**
     * 导入课程信息
     *
     * @param path
     */
    public void insertCourse(InputStream path) {
        List<CourseExcel> courseExcels = organizationService.readExcel2Bean(path, CourseExcel.class);
        if (CollUtil.isEmpty(courseExcels)) {
            return;
        }
        List<CourseModel> courseModels = new ArrayList<>(courseExcels.size());
        courseExcels.forEach(courseExcel -> courseModels.add(createCourseModel(courseExcel)));
        courseBusinessMapper.insertList(courseModels);
    }

    public CourseModel createCourseModel(CourseExcel courseExcel) {
        String courseId = courseExcel.getCourseCoding();
        String courseName = courseExcel.getCourseName();
        CourseModel courseModel = new CourseModel();
        courseModel.setName(courseName);
        courseModel.setCoding(courseId);
        courseModel.setDescription(courseName);
        return courseModel;
    }

    /**
     * 为老师分配教学任务
     *
     * @param path
     */
    public void insertTeachTask(InputStream path) {
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
    public void insertStudentTask(InputStream path) {
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


    /**
     * 插入发布的评教卷信息，通过教学任务
     *
     * @param path
     * @param authorAccountId 登陆的用户的账户id
     */
    public void insertPublishQuestionnaire(InputStream path,
                                           Integer authorAccountId) {
        List<PublishQuestionnaireExcel> excelList
                = organizationService.readExcel2Bean(path, PublishQuestionnaireExcel.class);
        Validator.validateNotNull(excelList, "上传的评教任务为空");
        List<PublishQuestionnaireModel> result = new ArrayList<>(excelList.size());
        excelList.forEach(publishQuestionnaireExcel -> {
            try {
                PublishQuestionnaireArgs publishArgs = createPublishArgs(publishQuestionnaireExcel);
                result.add(createPublishQuestionnaire(publishArgs, authorAccountId));
            } catch (Exception e) {
                log.warn("发布评教卷发生异常：{}", e.getMessage(), e);
            }

        });
        publishQuestionBusinessMapper.insertList(result);
    }


    /**
     * 创建一个发布评教卷的参数信息
     *
     * @return 评教卷的参数信息
     */
    public PublishQuestionnaireArgs createPublishArgs(PublishQuestionnaireExcel excel) {

        PublishQuestionnaireArgs args = new PublishQuestionnaireArgs();

        // 配置黑名单数量，需要从excel中读取
        args.setBlacks(excel.getBlacks());
        // 具体的评教卷id需要从excel中获取
        args.setQuestionnaireId(excel.getQuestionnaireId());
        // 通过excel获取教学任务的唯一id
        args.setTeachCourseId(excel.getTeachCourseId());
        // 课程id可以通过coding获取
        String courseCoding = excel.getCourseCoding();
        CourseModel courseModel = courseService.findCourseModelByCourseCoding(courseCoding);
        Validator.validateNotNull(courseModel, "编号为{}的课程不存在无法发布评教卷", courseCoding);
        args.setCourseId(courseModel.getId());
        // 授课老师的唯一id可以通过老师名字获取
        String teacherName = excel.getTeacherName();
        TeacherModel teacherModel = organizationService.findTeacherModelByName(teacherName);
        Validator.validateNotNull(teacherModel, "编号为{}的课程的授课老师{}信息不存在", courseCoding, teacherName);
        args.setTeacherAccountId(teacherModel.getAccountId());
        // 发布描述，使用课程名字代替
        args.setDescription(courseModel.getName());
        // 结束回答时间为期末
        String semester = excel.getSemester();
        Integer year = excel.getYear();
        args.setEndRespondTime(SemesterEnum.findFinalPeriodTime(year, semester));
        // 开始回答通过 结束周-evaluationTime = 开始回答的周，然后再计算出来时间戳
        args.setStartRespondTime(SemesterEnum.semesterWeekTime(year, semester, excel.getEvaluationTime()));
        // 学年信息从excel中获取
        args.setYear(year);
        // 学期信息从excel中获取
        args.setSemester(semester);

        return args;
    }


    /**
     * 给一个教学任务配置一个测评卷用来考量
     * 老师的教学质量
     *
     * @param authorAccountId 登陆的用户
     * @param args            发布参数
     * @return 一个生成的发布卷
     */
    public PublishQuestionnaireModel createPublishQuestionnaire(PublishQuestionnaireArgs args,
                                                                Integer authorAccountId) {


        PublishQuestionnaireModel publication = new PublishQuestionnaireModel();
        // 教学课程的自增id
        publication.setCourseId(args.getCourseId());
        // 配置描述
        publication.setDescription(args.getDescription());
        // 配置回答结束时间
        publication.setEndRespondTime(args.getEndRespondTime());
        // 配置回答开始时间
        publication.setStartRespondTime(args.getStartRespondTime());
        // 配置评教卷信息
        publication.setQuestionnaireId(args.getQuestionnaireId());
        // 授课老师的账号id
        publication.setTeacherAccountId(args.getTeacherAccountId());
        // 配置发布人的账户id
        publication.setReleaseAccountId(authorAccountId);

        // 配置创建时间
        publication.setReleaseTime(new Date());
        // 配置学年信息
        publication.setYear(args.getYear());
        // 配置学期信息
        publication.setSemester(args.getSemester());
        // 配置教学任务id
        String teachCourseId = args.getTeachCourseId();
        publication.setTeachCourseId(teachCourseId);

        // ==================== 下面开始填充发布评教卷的附加信息 ==================

        // 根据教学任务id查询到学生信息

        List<StudentModel> studentModels
                = studentBusinessMapper.findStudentModelByTeachTaskId(teachCourseId);
        Validator.validateNotNull(studentModels, "教学任务{}没有学生参与", teachCourseId);
        List<Integer> studentModelIds
                = studentService.findStudentAccountIdsByStudentModel(studentModels);

        PublishAttachInfo publishAttachInfo = new PublishAttachInfo();
        publishAttachInfo.setPlan(studentModelIds.size());
        publishAttachInfo.setStudents(studentModelIds);
        // 配置黑名单信息
        publishAttachInfo.setCanFilters(args.getBlacks());
        // 设置统计信息
        publication.setStatistics(JSONUtil.toJsonStr(publishAttachInfo));

        return publication;
    }


    /**
     * 通过上传的文件更新学生的课程信息
     *
     * @param path
     */
    public void updateStudentCourseScore(InputStream path) {
        List<StudentCourseScoreExcel> scoreExcels
                = organizationService.readExcel2Bean(path, StudentCourseScoreExcel.class);
        Validator.validateFalse(CollUtil.isEmpty(scoreExcels), "上传的分数信息为空");
        scoreExcels.forEach(this::updateStudentCourseScore);
    }

    /**
     * 更新一个学生的在一个课程中的学习成绩
     *
     * @param studentCourseScoreExcel
     */
    public void updateStudentCourseScore(StudentCourseScoreExcel studentCourseScoreExcel) {
        Integer score = studentCourseScoreExcel.getScore();
        String studentId = studentCourseScoreExcel.getStudentId();
        StudentModel student = studentService.findStudentByStudentId(studentId);
        Integer accountId = student.getAccountId();
        String teachCourseId = studentCourseScoreExcel.getTeachCourseId();
        studentCourseBusinessMapper.updateStudentScore(score, accountId, teachCourseId);
    }
}
