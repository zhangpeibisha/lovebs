package org.nix.lovedomain.component;

import cn.hutool.json.JSONUtil;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.nix.lovedomain.component.email.EmailTemplate;
import org.nix.lovedomain.dao.business.json.task.QnaireTask;
import org.nix.lovedomain.dao.business.json.task.QnaireTaskItem;
import org.nix.lovedomain.dao.business.json.teacher.TeacherWork;
import org.nix.lovedomain.dao.mapper.AccountMapper;
import org.nix.lovedomain.dao.mapper.EvaluationquestionnaireMapper;
import org.nix.lovedomain.dao.mapper.TeacherMapper;
import org.nix.lovedomain.model.Account;
import org.nix.lovedomain.model.Publishquestionnaire;
import org.nix.lovedomain.model.Student;
import org.nix.lovedomain.model.Teacher;
import org.nix.lovedomain.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @version 1.0
 * @anthor on 2019/4/23
 * @since jdk8
 * <p>
 * 定时任务调度,用于定时扫描发布的问卷是否可以正真的发送到用户
 * 的任务里，并且检测任务是否结束，如果结束了则需要执行回收任务
 * 每天凌晨0点执行
 */
@Component
public class PublishQuestionScheduledTask {

    @Autowired
    private PublishquestionnaireService publishquestionnaireService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    /**
     * 执行分发任务，就是执行当天应该发送的给用户应该处理的邮件
     *
     * @param publishquestionnaire
     */
    public void runDistributionTask(Publishquestionnaire publishquestionnaire) throws Exception {

        // 给老师添加新任务
        teacherService.addTask(publishquestionnaire);

        // 给学生添加任务
        studentService.addPublishQuestionTask(publishquestionnaire);

        // 最后发送邮件提醒
        emailService.sendPublishQuestionNotice(publishquestionnaire);
    }


    /**
     * 执行回收问卷动作，就是问卷回答的时间已经结束，不可以在做其他修改，
     * 只能作为查询使用，将回收的信息发送给对应的用户，并处理相关数据
     *
     * @param publishquestionnaire
     */
    public void runRecoverTask(Publishquestionnaire publishquestionnaire) {

    }


    /**
     * 读取所有需要发布的问卷
     *
     * @return List<Publishquestionnaire>
     */
    private List<Publishquestionnaire> getPublishquestionnaires() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return publishquestionnaireService.getAllDataByLimit(simpleDateFormat.format(new Date()));
    }


}
