package org.nix.lovedomain.component;


import org.nix.lovedomain.dao.model.PublishQuestionnaireModel;
import org.nix.lovedomain.service.EmailService;
import org.nix.lovedomain.service.StudentService;
import org.nix.lovedomain.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 * <p>
 * 定时任务调度,用于定时扫描发布的评教卷是否可以正真的发送到用户
 * 的任务里，并且检测任务是否结束，如果结束了则需要执行回收任务
 * 每天凌晨0点执行
 */
@Component
public class PublishQuestionScheduledTask {

    @Autowired
    private EmailService emailService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    /**
     * 执行分发任务，就是执行当天应该发送的给用户应该处理的邮件
     *
     * @param publishQuestionnaireModel
     */
    public void runDistributionTask(PublishQuestionnaireModel publishQuestionnaireModel) throws Exception {

        // 给老师添加新任务
        teacherService.addTask(publishQuestionnaireModel);

        // 给学生添加任务
        studentService.addPublishQuestionTask(publishQuestionnaireModel);

        // 最后发送邮件提醒
        emailService.sendPublishQuestionNotice(publishQuestionnaireModel, 1);
    }


    /**
     * 执行回收评教卷动作，就是评教卷回答的时间已经结束，不可以在做其他修改，
     * 只能作为查询使用，将回收的信息发送给对应的用户，并处理相关数据
     *
     * @param publishQuestionnaireModel
     */
    public void runRecoverTask(PublishQuestionnaireModel publishQuestionnaireModel) throws Exception {

        // 取消老师的任务
        teacherService.task2Complete(publishQuestionnaireModel);

        // 取消学生的任务
        studentService.removePublishQuestionTask(publishQuestionnaireModel);

        // 最后发送邮件提醒
        emailService.sendPublishQuestionNotice(publishQuestionnaireModel, 2);
    }

}
