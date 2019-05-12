package org.nix.lovedomain.web.controller;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.PublishQuestionBusinessMapper;
import org.nix.lovedomain.dao.business.json.winding.PublishAttachInfo;
import org.nix.lovedomain.dao.mapper.EvaluationquestionnaireMapper;
import org.nix.lovedomain.dao.model.PublishquestionnaireModel;
import org.nix.lovedomain.model.Evaluationquestionnaire;
import org.nix.lovedomain.model.Publishquestionnaire;
import org.nix.lovedomain.service.AccountService;
import org.nix.lovedomain.service.PublishquestionnaireService;
import org.nix.lovedomain.service.ServiceException;
import org.nix.lovedomain.service.vo.EvaluationquestionnaireDeatilVo;
import org.nix.lovedomain.service.vo.PublishQuestionJsonVo;
import org.nix.lovedomain.service.vo.PublishQuestionVo;
import org.nix.lovedomain.service.vo.StudentVo;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.web.controller.base.BaseController;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.List;

/**
 * @version 1.0
 * @anthor on 2019/4/19
 * @since jdk8
 */
@Slf4j
@RestController
@Api(value = "发布问卷控制器", description = "该控制器主要完成和发布问卷相关的工作")
@RequestMapping(value = "publishquestionnaire")
public class PublishquestionnaireController extends BaseController<Publishquestionnaire> {

    @Autowired
    private PublishquestionnaireService publishquestionnaireService;

    @Resource
    public PublishQuestionBusinessMapper publishQuestionBusinessMapper;

    @Resource
    public EvaluationquestionnaireMapper evaluationquestionnaireMapper;

    @Resource
    private AccountService accountService;

    @ApiOperation(value = "发布评教问卷")
    @PostMapping(value = "/publish")
    public RespondsMessage pusblishQuestionnaire(Principal principal,
                                                 @RequestParam(value = "courseId") Integer courseId,
                                                 @RequestParam(value = "teacherId") Integer teacherId,
                                                 @RequestParam(value = "questionnaireId") Integer questionnaireId,
                                                 @RequestParam(value = "description", required = false) String description,
                                                 @RequestParam(value = "startRespondTime") Long startRespondTime,
                                                 @RequestParam(value = "endRespondTime") Long endRespondTime,
                                                 @ApiParam(value = "发布人可以设置该任课老师可以屏蔽几个学生的成绩不计入统计")
                                                 @RequestParam(value = "blacks", defaultValue = "5") Integer blacks) throws Exception {

        if (principal == null) {
            throw new ServiceException("用户未登陆");
        }
        Publishquestionnaire publishquestionnaire = publishquestionnaireService.pusblishQuestionnaire(principal,
                courseId, teacherId, questionnaireId, description, startRespondTime, endRespondTime, blacks);

        return RespondsMessage.success(LogUtil.logInfo(log, "{}发布评教问卷成功", principal.getName()),
                publishquestionnaire);
    }

    /**
     * 添加黑名单学生
     *
     * @param publisId   发布id
     * @param studentIds 学生id集合
     * @return 处理后的数据
     */
    @ApiOperation(value = "添加黑名单学生")
    @PostMapping(value = "/addBlack")
    public RespondsMessage addBlack(@RequestParam(value = "publisId") Integer publisId,
                                    @RequestParam(value = "studentIds") List<Integer> studentIds,
                                    Principal principal) {
        if (principal == null) {
            throw new ServiceException(LogUtil.logInfo(log, "用户未登陆添加黑名单那"));
        }
        Publishquestionnaire publishquestionnaire = publishquestionnaireService.addBlack(publisId, studentIds, principal);
        return RespondsMessage.success(LogUtil.logInfo(log, "用户{}更新的问题成功", principal.getName()), publishquestionnaire);
    }

    /**
     * 删除黑名单学生
     *
     * @param publisId   发布id
     * @param studentIds 学生id集合
     * @return 处理后的数据
     */
    @ApiOperation(value = "删除黑名单学生")
    @DeleteMapping(value = "/deleteBlack")
    public RespondsMessage deleteBlack(@RequestParam(value = "publisId") Integer publisId,
                                       @RequestParam(value = "studentIds") List<Integer> studentIds,
                                       Principal principal) {
        Publishquestionnaire publishquestionnaire = publishquestionnaireService.deleteBlack(publisId, studentIds, principal);
        return RespondsMessage.success(LogUtil.logInfo(log, "用户{}更新的问题成功", principal.getName()), publishquestionnaire);
    }

    /**
     * 提交回答信息，
     *
     * @param publisId
     * @param completesQuestion
     * @return
     */
    @ApiOperation(value = "提交回答信息")
    @PostMapping(value = "/writeQuestion")
    public RespondsMessage writeQuestion(@RequestParam(value = "publisId") Integer publisId,
                                         @RequestBody PublishAttachInfo.CompletesQuestion completesQuestion,
                                         Principal principal) {
        Publishquestionnaire publishquestionnaire = publishquestionnaireService.writeQuestion(publisId, completesQuestion, principal);
        return RespondsMessage.success(LogUtil.logInfo(log, "用户{}更新的问题成功", principal.getName()), publishquestionnaire);
    }

    /**
     * 更新回答，只有 status=keep的时候可以更新
     *
     * @param publisId
     * @param completesQuestion
     * @return
     */
    @ApiOperation(value = "更新回答，只有 status=keep的时候可以更新")
    @PutMapping(value = "/updateQuestion")
    public RespondsMessage updateQuestion(@RequestParam(value = "publisId") Integer publisId,
                                          @RequestBody PublishAttachInfo.CompletesQuestion completesQuestion,
                                          Principal principal) {
        Publishquestionnaire publishquestionnaire = publishquestionnaireService.updateQuestion(publisId, completesQuestion, principal);
        return RespondsMessage.success(LogUtil.logInfo(log, "用户{}更新的问题成功", principal.getName()), publishquestionnaire);
    }

    /**
     * 通过id批量获取发布问卷信息
     *
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量获取发布问卷的信息")
    @GetMapping(value = "/list/by/ids")
    public RespondsMessage batchFindPublishQuestionInfo(@RequestParam(value = "ids") List<Integer> ids) {
        return RespondsMessage.success("获取发布问卷信息完成", publishquestionnaireService.findPublishQuestionDeatil(ids));
    }

    /**
     * 老师阅读了发布的问卷信息
     *
     * @return
     */
    @PutMapping(value = "/teacher/read/publish")
    public RespondsMessage teacherReadPublishQuestionInfo(@RequestParam(value = "publishQuestingId") Integer publishQuesting,
                                                          Principal principal) {
        Publishquestionnaire publishquestionnaire
                = publishquestionnaireService.teacherCheckPendingQuestion(publishQuesting, principal);
        return RespondsMessage.success("获取发布问卷信息成功", JSON.parseObject(JSON.toJSONString(publishquestionnaire),
                PublishQuestionJsonVo.class));
    }

    /**
     * 学生阅读了发布的问卷信息
     *
     * @return
     */
    @PutMapping(value = "/student/read/publish")
    public RespondsMessage studentReadPublishQuestionInfo(@RequestParam(value = "publishQuestingId") Integer publishQuesting,
                                                          Principal principal) {
        Publishquestionnaire publishquestionnaire
                = publishquestionnaireService.studentCheckPendingQuestion(publishQuesting, principal);
        return RespondsMessage.success("获取发布问卷信息成功", publishquestionnaire);
    }

    /**
     * 查询学生在这个问卷中回答的问题
     *
     * @param publishId
     * @param principal
     * @return
     */
    @GetMapping(value = "/answers")
    public RespondsMessage findStudentAnswers(@RequestParam(value = "publishId") Integer publishId,
                                              Principal principal) {
        StudentVo studentByAccountName
                = accountService.findStudentByAccountName(principal.getName());

        Integer studentId = studentByAccountName.getId();

        Publishquestionnaire publishQuestionId
                = publishquestionnaireService.findById(publishId);

        if (publishQuestionId == null) {
            return RespondsMessage.success("问卷不存在");
        }

        PublishAttachInfo bean = PublishAttachInfo.getBean(publishQuestionId);
        List<PublishAttachInfo.CompletesQuestion> completesQuestions
                = bean.getCompletesQuestions();
        if (CollUtil.isEmpty(completesQuestions)) {
            return RespondsMessage.success("未作答");
        }

        for (PublishAttachInfo.CompletesQuestion completesQuestion : completesQuestions) {
            if (completesQuestion.getStudentId().equals(studentId)) {
                AnswersView answersView = new AnswersView();
                answersView.setAnswers(completesQuestion);
                Evaluationquestionnaire evaluationquestionnaire
                        = evaluationquestionnaireMapper.selectByPrimaryKey(publishQuestionId.getQuestionnaireid());

                answersView.setEvaluationquestionnaire(evaluationquestionnaire);
                evaluationquestionnaire.setContent(null);
                return RespondsMessage.success("获取答案完成", answersView);
            }
        }
        return RespondsMessage.success("未作答");
    }


    @Data
    public static class AnswersView {

        private Evaluationquestionnaire evaluationquestionnaire;

        private PublishAttachInfo.CompletesQuestion answers;

    }

}
