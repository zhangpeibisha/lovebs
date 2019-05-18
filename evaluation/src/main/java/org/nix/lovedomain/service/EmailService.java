package org.nix.lovedomain.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import org.nix.lovedomain.component.email.EmailTemplate;
import org.nix.lovedomain.dao.mapper.CourseMapper;
import org.nix.lovedomain.dao.mapper.EvaluationquestionnaireMapper;
import org.nix.lovedomain.dao.mapper.TeacherMapper;
import org.nix.lovedomain.model.*;
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
    private EmailTemplate emailTemplate;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private EvaluationquestionnaireMapper evaluationquestionnaireMapper;

    public void sendQuestionTask(EmailTemplate.EmailText emailText) {
        emailTemplate.sendTextEmail(emailText);
    }

    /**
     * 发送提示信息给发布的老师
     *
     * @param publishquestionnaire
     * @param type 值为1代表问卷开始做答，值为2代表问卷结束做答
     */
    public void sendReminderAnnouncerQuestionStart(Publishquestionnaire publishquestionnaire,Integer type) {
        Integer releaseid = publishquestionnaire.getReleaseid();
        Teacher teacher = teacherMapper.selectByAccountId(releaseid);
        Integer questionnaireid = publishquestionnaire.getQuestionnaireid();
        Evaluationquestionnaire evaluationquestionnaire
                = evaluationquestionnaireMapper.selectByPrimaryKey(questionnaireid);
        if (evaluationquestionnaire == null){
            return;
        }
        String title = evaluationquestionnaire.getTitle();
        String email = teacher.getEmail();

        if(type == 1){
            //发送邮件给发布问卷的老师
            EmailUtil.sendEmail(EmailContent.SEND_PT_START.toContent(teacher.getName(),title,publishquestionnaire.getDescription()),
                    Arrays.asList(email));
        }else if(type == 2){
            //发送邮件给发布问卷的老师
            EmailUtil.sendEmail(EmailContent.SEND_PT_END.toContent(teacher.getName(),title,publishquestionnaire.getDescription()),
                    Arrays.asList(email));
        }


    }

    /**
     * 发送提示邮件给授课老师
     *
     * @param publishquestionnaire
     * @param type 值为1代表问卷开始做答，值为2代表问卷结束做答
     */
    public void sendReminderTeacher(Publishquestionnaire publishquestionnaire,Integer type){
        Integer teacherid = publishquestionnaire.getTeacherid();
        Teacher teacher = teacherMapper.selectByAccountId(teacherid);
        Integer courseid = publishquestionnaire.getCourseid();
        Course course = courseMapper.selectByPrimaryKey(courseid);

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
     * @param publishquestionnaire
     * @param type 值为1代表问卷开始做答，值为2代表问卷结束做答
     */
    public void sendReminderStudent(Publishquestionnaire publishquestionnaire,Integer type) {
        if (publishquestionnaire == null) {
            return;
        }
        Integer courseid = publishquestionnaire.getCourseid();
        Integer teacherid = publishquestionnaire.getTeacherid();
        if (courseid == null || teacherid == null) {
            return;
        }
        List<Student> studentByCourse
                = getStudentByCourse(teacherid,
                courseid);
        if (CollUtil.isEmpty(studentByCourse)) {
            return;
        }
        Teacher teacher = teacherMapper.selectByPrimaryKey(teacherid);
        Course course = courseMapper.selectByPrimaryKey(courseid);
        List<String> address = new ArrayList<>(studentByCourse.size());
        for (Student student : studentByCourse) {
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
     * @param publishquestionnaire
     * @param tyepe  值为1代表问卷开始，2代表问卷结束
     */
    public void sendPublishQuestionNotice(Publishquestionnaire publishquestionnaire,Integer tyepe){
        sendReminderAnnouncerQuestionStart(publishquestionnaire,tyepe);
        sendReminderTeacher(publishquestionnaire,tyepe);
        sendReminderStudent(publishquestionnaire,tyepe);
    }

    /**
     * 根据课程读取所有的学生
     *
     * @param teacherId 老师id
     * @param courseId  课程id
     * @return
     */
    private List<Student> getStudentByCourse(Integer teacherId, Integer courseId)  {
        return studentService.getStudentByCourse(teacherId, courseId);
    }

}
