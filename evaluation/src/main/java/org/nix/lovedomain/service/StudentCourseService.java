package org.nix.lovedomain.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Validator;
import lombok.Data;
import org.nix.lovedomain.dao.business.EvaluationQuestionnaireBusinessMapper;
import org.nix.lovedomain.dao.business.PublishQuestionBusinessMapper;
import org.nix.lovedomain.dao.business.StudentCourseBusinessMapper;
import org.nix.lovedomain.dao.business.json.winding.PublishAttachInfo;
import org.nix.lovedomain.dao.model.EvaluationQuestionnaireModel;
import org.nix.lovedomain.dao.model.PublishQuestionnaireModel;
import org.nix.lovedomain.dao.model.StudentCourseModel;
import org.nix.lovedomain.dao.model.TeacherCourseModel;
import org.nix.lovedomain.security.UserDetail;
import org.nix.lovedomain.service.enums.RoleEnum;
import org.nix.lovedomain.web.controller.PublishQuestionnaireController;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 */
@Service
public class StudentCourseService {

    @Resource
    private PublishQuestionBusinessMapper publishQuestionBusinessMapper;

    @Resource
    private EvaluationQuestionnaireBusinessMapper evaluationQuestionnaireBusinessMapper;

    @Resource
    private StudentCourseBusinessMapper studentCourseBusinessMapper;

    @Resource
    private PublishQuestionnaireService publishQuestionnaireService;

    /**
     * 学生获取自己课程的分数
     *
     * @param principal
     * @param teachCourseId
     * @return
     */
    public Integer viewScore(Principal principal,
                             String teachCourseId) {
        PublishQuestionnaireModel model
                = publishQuestionnaireService.findPublishQuestionnaireModelByTeachCourseId(teachCourseId);
        Validator.validateNotNull(model, "{}教学任务没有对应的评教卷", teachCourseId);
        Integer publishId = model.getId();
        Validator.validateTrue(checkStudentAnswerQuestion(principal, publishId), "你还未回答教学任务{}的评教卷，请先回答评教卷", teachCourseId);
        Integer accountId = UserDetail.analysisUserAccountId(principal);
        StudentCourseModel studentTeachTask = findStudentTeachTask(accountId, teachCourseId);
        Validator.validateNotNull(studentTeachTask, "你没有教学任务{}，不能查分", teachCourseId);
        return studentTeachTask.getScore();
    }

    /**
     * 通过学生账号id和教学号找到学生的教学任务
     *
     * @param accountId     学生的账号id
     * @param teachCourseId 教学任务id
     * @return 学生的教学任务
     */
    public StudentCourseModel findStudentTeachTask(Integer accountId, String teachCourseId) {
        StudentCourseModel studentCourseModel = new StudentCourseModel();
        studentCourseModel.setStudentAccountId(accountId);
        studentCourseModel.setTeachCourseId(teachCourseId);
        return studentCourseBusinessMapper.selectOne(studentCourseModel);
    }

    /**
     * 检测学生是否已经回答了该发布的评教卷
     *
     * @param principal         登陆用户信息
     * @param publishQuestionId 发布的评教卷
     * @return 如果为true则代表回答了
     */
    public boolean checkStudentAnswerQuestion(Principal principal,
                                              Integer publishQuestionId) {
        return createStudentAnsersView(publishQuestionId, principal) != null;
    }


    /**
     * 获取学生的回答信息
     *
     * @param publishQuestionId
     * @param principal
     * @return
     */
    public AnswersView createStudentAnsersView(Integer publishQuestionId,
                                               Principal principal) {
        List<String> roles = UserDetail.analysisUserStrRoles(principal);
        Validator.validateTrue(roles.contains(RoleEnum.STUDENT.getName()),
                "权限不足", roles);
        PublishQuestionnaireModel questionnaireModel
                = publishQuestionBusinessMapper.selectByPrimaryKey(publishQuestionId);
        Validator.validateNotNull(questionnaireModel, "发布的评教卷{}不存在", publishQuestionId);
        PublishAttachInfo bean = PublishAttachInfo.getBean(questionnaireModel);
        List<PublishAttachInfo.CompletesQuestion> completesQuestions
                = bean.getCompletesQuestions();
        if (CollUtil.isEmpty(completesQuestions)) {
            return null;
        }
        for (PublishAttachInfo.CompletesQuestion completesQuestion : completesQuestions) {
            if (completesQuestion.getStudentAccountId().equals(UserDetail.analysisUserAccountId(principal))) {
                AnswersView answersView = new AnswersView();
                answersView.setAnswers(completesQuestion);
                EvaluationQuestionnaireModel evaluational
                        = evaluationQuestionnaireBusinessMapper
                        .selectByPrimaryKey(questionnaireModel.getQuestionnaireId());

                answersView.setEvaluationQuestionnaire(evaluational);
                evaluational.setContent(null);

                return answersView;
            }
        }
        return null;
    }


    @Data
    public static class AnswersView {

        private EvaluationQuestionnaireModel evaluationQuestionnaire;

        private PublishAttachInfo.CompletesQuestion answers;

    }
}
