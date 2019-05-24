package org.nix.lovedomain.service;

import cn.hutool.core.collection.CollUtil;
import org.nix.lovedomain.component.email.EmailTemplate;
import org.nix.lovedomain.dao.business.CourseBusinessMapper;
import org.nix.lovedomain.dao.business.EvaluationQuestionnaireBusinessMapper;
import org.nix.lovedomain.dao.business.TeacherBusinessMapper;
import org.nix.lovedomain.dao.model.*;
import org.nix.lovedomain.utils.EmailContent;
import org.nix.lovedomain.utils.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 邮箱服务
 * @date 2019/4/28
 */
@Service
public class EmailService {

    @Autowired
    private StudentService studentService;

    @Resource
    private TeacherBusinessMapper teacherBusinessMapper;

    @Resource
    private CourseBusinessMapper courseMapper;

    @Resource
    private EvaluationQuestionnaireBusinessMapper evaluationQuestionnaireBusinessMapper;

    /**
     * 发送提示信息给发布的老师
     *
     * @param publishQuestionnaireModel
     * @param type 值为1代表评教卷开始做答，值为2代表评教卷结束做答
     */
    public void sendReminderAnnouncerQuestionStart(PublishQuestionnaireModel publishQuestionnaireModel,Integer type) {
        Integer releaseAccountId = publishQuestionnaireModel.getReleaseAccountId();
        TeacherModel teacher = teacherBusinessMapper.selectByAccountId(releaseAccountId);
        Integer questionnaireId = publishQuestionnaireModel.getQuestionnaireId();
        EvaluationQuestionnaireModel evaluational
                = evaluationQuestionnaireBusinessMapper.selectByPrimaryKey(questionnaireId);
        if (evaluational == null){
            return;
        }
        String title = evaluational.getTitle();
        String email = teacher.getEmail();

        if(type == 1){
            //发送邮件给发布评教卷的老师
            EmailUtil.sendEmail(EmailContent.SEND_PT_START.toContent(teacher.getName(),title,publishQuestionnaireModel.getDescription()),
                    Arrays.asList(email));
        }else if(type == 2){
            //发送邮件给发布评教卷的老师
            EmailUtil.sendEmail(EmailContent.SEND_PT_END.toContent(teacher.getName(),title,publishQuestionnaireModel.getDescription()),
                    Arrays.asList(email));
        }


    }

    /**
     * 发送提示邮件给授课老师
     *
     * @param publishQuestionnaireModel
     * @param type 值为1代表评教卷开始做答，值为2代表评教卷结束做答
     */
    public void sendReminderTeacher(PublishQuestionnaireModel publishQuestionnaireModel,Integer type){
        Integer teacherAccountId = publishQuestionnaireModel.getTeacherAccountId();
        TeacherModel teacher = teacherBusinessMapper.selectByAccountId(teacherAccountId);
        Integer teachCourseId = publishQuestionnaireModel.getCourseId();
        // 通过授课课程找到课程信息
        CourseModel course = courseMapper.findCourseByTeachCourse(teachCourseId);
        if(type == 1){
            //发送邮件给授课老师
            EmailUtil.sendEmail(EmailContent.SEND_T_START.toContent(teacher.getName(),course.getName()),
                    Arrays.asList(teacher.getEmail()));
        }else if(type == 2){
            //发送邮件给授课老师
            EmailUtil.sendEmail(EmailContent.SEND_T_END.toContent(teacher.getName(),course.getName()),
                    Arrays.asList(teacher.getEmail()));
        }


    }

    /**
     * 发送提示邮件给学生
     *
     * @param publishQuestionnaireModel
     * @param type 值为1代表评教卷开始做答，值为2代表评教卷结束做答
     */
    public void sendReminderStudent(PublishQuestionnaireModel publishQuestionnaireModel,Integer type) {
        if (publishQuestionnaireModel == null) {
            return;
        }
        Integer teachCourseId = publishQuestionnaireModel.getCourseId();
        Integer teacherAccountId = publishQuestionnaireModel.getTeacherAccountId();
        if (teachCourseId == null || teacherAccountId == null) {
            return;
        }
        List<StudentModel> studentByCourse
                = getStudentByTeachCourse(teacherAccountId,
                teachCourseId);
        if (CollUtil.isEmpty(studentByCourse)) {
            return;
        }
        TeacherModel teacher = teacherBusinessMapper.selectByPrimaryKey(teacherAccountId);

        // 通过授课课程找到课程信息
        CourseModel course = courseMapper.findCourseByTeachCourse(teachCourseId);
        List<String> address = new ArrayList<>(studentByCourse.size());
        for (StudentModel student : studentByCourse) {
            String email = student.getEmail();
            address.add(email);
        }

        if(type == 1){
            // 发送邮件给老师
            EmailUtil.sendEmail(EmailContent.SEND_S_START.toContent(teacher.getName(),course.getName()),address);
        }else if(type == 2){
            // 发送邮件给老师
            EmailUtil.sendEmail(EmailContent.SEND_S_END.toContent(teacher.getName(),course.getName()),address);
        }


    }

    /**
     * 发送他提示邮件
     *
     * @param publishQuestionnaireModel
     * @param tyepe  值为1代表评教卷开始，2代表评教卷结束
     */
    public void sendPublishQuestionNotice(PublishQuestionnaireModel publishQuestionnaireModel, Integer tyepe){
        sendReminderAnnouncerQuestionStart(publishQuestionnaireModel,tyepe);
        sendReminderTeacher(publishQuestionnaireModel,tyepe);
        sendReminderStudent(publishQuestionnaireModel,tyepe);
    }

    /**
     * 根据课程读取所有的学生
     *
     * @param teacherId 老师id
     * @param teachCourseId  授课课程id ： teacher_course自增主键
     * @return
     */
    private List<StudentModel> getStudentByTeachCourse(Integer teacherId,
                                                       Integer teachCourseId)  {
        return studentService.getStudentByTeachCourse(teacherId, teachCourseId);
    }

}
