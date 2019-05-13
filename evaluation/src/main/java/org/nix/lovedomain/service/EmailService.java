package org.nix.lovedomain.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import org.nix.lovedomain.component.email.EmailTemplate;
import org.nix.lovedomain.dao.mapper.CourseMapper;
import org.nix.lovedomain.dao.mapper.EvaluationquestionnaireMapper;
import org.nix.lovedomain.dao.mapper.TeacherMapper;
import org.nix.lovedomain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
     * 发送给发布问卷的老师信息,提醒老师问卷已经开始答卷了
     */

    public void sendReminderAnnouncerQuestionStart(Publishquestionnaire publishquestionnaire) {

    public void  sendReminderAnnouncerQuestionStart(Publishquestionnaire publishquestionnaire,int type) {

        Integer releaseid = publishquestionnaire.getReleaseid();
        Teacher teacher = teacherMapper.selectByAccountId(releaseid);
        Integer questionnaireid = publishquestionnaire.getQuestionnaireid();
        Evaluationquestionnaire evaluationquestionnaire
                = evaluationquestionnaireMapper.selectByPrimaryKey(questionnaireid);
        if (evaluationquestionnaire == null){
            return;
        }
        String title = evaluationquestionnaire.getTitle();
        EmailTemplate.EmailText emailText = new EmailTemplate.EmailText();
        String email = teacher.getEmail();
        if (email == null){
            return;
        }
        String content = StrUtil.format("你好{}：你发布的问卷{}已经开始答卷，" +
                        "你对问卷的作用描述为：{},具体信息可以登陆【重庆理工大学评教系统】查看", teacher.getName(), title
                , publishquestionnaire.getDescription());
        emailText.setContent(content);
        emailText.setSubject("【重庆理工大学评教系统】");
        emailText.setToAddress(CollUtil.newArrayList(email));

        sendQuestionTask(emailText);
    }

    /**
     * 发送信息给授课老师
     *
     * @param publishquestionnaire
     */
    public void sendReminderTeacher(Publishquestionnaire publishquestionnaire) {
        Integer teacherid = publishquestionnaire.getTeacherid();
        Teacher teacher = teacherMapper.selectByAccountId(teacherid);
        Integer courseid = publishquestionnaire.getCourseid();
        Course course = courseMapper.selectByPrimaryKey(courseid);

        EmailTemplate.EmailText emailText = new EmailTemplate.EmailText();
        emailText.setSubject("【重庆理工大学评教系统】");
        emailText.setContent(StrUtil.format("你好{}：你的教学质量评分已经开始，" +
                "本次提醒所在课程：{}，" +
                "你可以登陆【重庆理工大学评教系】的个人中心进行查看", teacher.getName(), course.getName()));
        emailText.setToAddress(CollUtil.newArrayList(teacher.getEmail()));
        sendQuestionTask(emailText);
    }

    public void sendReminderStudent(Publishquestionnaire publishquestionnaire) {
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
        EmailTemplate.EmailText emailText = new EmailTemplate.EmailText();
        String content = StrUtil.format("你好：你上了{}老师的课程:{}，" +
                        "为了提高学校教学质量，现在请你根据你的学习情况和老师的授课情况公平公正的给与老师打分",
                teacher.getName(), course.getName());
        emailText.setContent(content);
        emailText.setSubject("【重庆理工大学评教系统】");

        List<String> address = new ArrayList<>(studentByCourse.size());
        for (Student student : studentByCourse) {
            String email = student.getEmail();
            address.add(email);
        }
        emailText.setToAddress(address);

        sendQuestionTask(emailText);
    }

    public void sendPublishQuestionNotice(Publishquestionnaire publishquestionnaire){
        sendReminderAnnouncerQuestionStart(publishquestionnaire);
        sendReminderTeacher(publishquestionnaire);
        sendReminderStudent(publishquestionnaire);
    }

    /**
     * 根据课程读取所有的学生
     *
     * @param teacherId 老师id
     * @param courseId  课程id
     * @return
     */
    private List<Student> getStudentByCourse(Integer teacherId, Integer courseId) {
        return studentService.getStudentByCourse(teacherId, courseId);
    }

}
