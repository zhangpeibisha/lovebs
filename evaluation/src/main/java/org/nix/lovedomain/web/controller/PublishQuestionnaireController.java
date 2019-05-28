package org.nix.lovedomain.web.controller;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.EvaluationQuestionnaireBusinessMapper;
import org.nix.lovedomain.dao.business.PublishQuestionBusinessMapper;
import org.nix.lovedomain.dao.business.json.winding.PublishAttachInfo;
import org.nix.lovedomain.dao.model.AccountModel;
import org.nix.lovedomain.dao.model.EvaluationQuestionnaireModel;
import org.nix.lovedomain.dao.model.PublishQuestionnaireModel;
import org.nix.lovedomain.service.AccountService;
import org.nix.lovedomain.service.PublishQuestionnaireService;
import org.nix.lovedomain.service.ServiceException;
import org.nix.lovedomain.service.enums.Permission;
import org.nix.lovedomain.service.enums.RoleEnum;
import org.nix.lovedomain.service.vo.PublishQuestionJsonVo;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.List;
import java.util.Map;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 */
@Slf4j
@RestController
@Api(value = "发布评教卷控制器", description = "该控制器主要完成和发布评教卷相关的工作")
@RequestMapping(value = "publishQuestionnaire")
public class PublishQuestionnaireController {

    @Autowired
    private PublishQuestionnaireService publishquestionnaireService;

    @Resource
    private EvaluationQuestionnaireBusinessMapper evaluationQuestionnaireBusinessMapper;

    @Resource
    private AccountService accountService;

    @Resource
    private PublishQuestionBusinessMapper publishQuestionBusinessMapper;

    /**
     * 添加黑名单学生
     *
     * @param publishId  发布id
     * @param studentIds 学生的账户id集合
     * @return 处理后的数据
     */
    @Permission(name = "添加黑名单学生", role = {RoleEnum.TEACHER})
    @ApiOperation(value = "添加黑名单学生")
    @PostMapping(value = "/addBlack")
    public RespondsMessage addBlack(@RequestParam(value = "publishId") Integer publishId,
                                    @RequestParam(value = "studentIds") List<Integer> studentIds,
                                    Principal principal) {
        if (principal == null) {
            throw new ServiceException(LogUtil.logInfo(log, "用户未登陆添加黑名单那"));
        }
        PublishQuestionnaireModel publication = publishquestionnaireService.addBlack(publishId, studentIds, principal);
        return RespondsMessage.success(LogUtil.logInfo(log, "用户{}更新的问题成功", principal.getName()), publication);
    }

    /**
     * 提交回答信息，
     *
     * @param publishId         发布的评教卷自增id
     * @param completesQuestion 回答的问题
     * @return
     */
    @Permission(name = "添加黑名单学生", role = {RoleEnum.STUDENT})
    @ApiOperation(value = "提交回答信息")
    @PostMapping(value = "/writeQuestion")
    public RespondsMessage writeQuestion(@RequestParam(value = "publishId") Integer publishId,
                                         @RequestBody PublishAttachInfo.CompletesQuestion completesQuestion,
                                         Principal principal) {
        PublishQuestionnaireModel publication = publishquestionnaireService.fillInTheAnswer(publishId, completesQuestion, principal);
        return RespondsMessage.success(LogUtil.logInfo(log, "用户{}更新的问题成功", principal.getName()), publication);
    }

    /**
     * 通过id批量获取发布评教卷信息
     *
     * @param ids
     * @return
     */
    @Permission(name = "批量获取发布评教卷的信息")
    @ApiOperation(value = "批量获取发布评教卷的信息")
    @GetMapping(value = "/list/by/ids")
    public RespondsMessage batchFindPublishQuestionInfo(@RequestParam(value = "ids") List<Integer> ids) {
        return RespondsMessage.success("获取发布评教卷信息完成", publishquestionnaireService.findPublishQuestionDeatil(ids));
    }

    /**
     * 老师阅读了发布的评教卷信息
     *
     * @return
     */
    @Permission(name = "批量获取发布评教卷的信息",role = RoleEnum.TEACHER)
    @PutMapping(value = "/teacher/read/publish")
    public RespondsMessage teacherReadPublishQuestionInfo(@RequestParam(value = "publishQuestingId") Integer publishQuesting,
                                                          Principal principal) {
        PublishQuestionnaireModel publication
                = publishquestionnaireService.teacherCheckPendingQuestion(publishQuesting, principal);
        return RespondsMessage.success("获取发布评教卷信息成功", JSON.parseObject(JSON.toJSONString(publication),
                PublishQuestionJsonVo.class));
    }

    /**
     * 学生阅读了发布的评教卷信息
     *
     * @return
     */
    @Permission(name = "批量获取发布评教卷的信息",role = RoleEnum.STUDENT)
    @PutMapping(value = "/student/read/publish")
    public RespondsMessage studentReadPublishQuestionInfo(@RequestParam(value = "publishQuestingId") Integer publishQuesting,
                                                          Principal principal) {
        PublishQuestionnaireModel publication
                = publishquestionnaireService.studentCheckPendingQuestion(publishQuesting, principal);
        return RespondsMessage.success("获取发布评教卷信息成功", publication);
    }

    /**
     * 查询学生在这个评教卷中回答的问题
     *
     * @param publishId
     * @param principal
     * @return
     */
    @Permission(name = "批量获取发布评教卷的信息",role = RoleEnum.STUDENT)
    @GetMapping(value = "/answers")
    public RespondsMessage findStudentAnswers(@RequestParam(value = "publishId") Integer publishId,
                                              Principal principal) {
        AccountModel accountModel
                = accountService.findUserByAccount(principal.getName());

        PublishQuestionnaireModel publishQuestionId
                = publishQuestionBusinessMapper.selectByPrimaryKey(publishId);

        if (publishQuestionId == null) {
            return RespondsMessage.success("评教卷不存在");
        }

        PublishAttachInfo bean = PublishAttachInfo.getBean(publishQuestionId);
        List<PublishAttachInfo.CompletesQuestion> completesQuestions
                = bean.getCompletesQuestions();
        if (CollUtil.isEmpty(completesQuestions)) {
            EvaluationQuestionnaireModel evaluational
                    = evaluationQuestionnaireBusinessMapper
                    .selectByPrimaryKey(publishQuestionId.getQuestionnaireId());
            evaluational.setContent(null);
            AnswersView data = new AnswersView();
            data.setEvaluationQuestionnaire(evaluational);
            data.setAnswers(new PublishAttachInfo.CompletesQuestion());
            return RespondsMessage.success("未作答，返回评教卷信息", data);
        }

        for (PublishAttachInfo.CompletesQuestion completesQuestion : completesQuestions) {
            if (completesQuestion.getStudentAccountId().equals(accountModel.getId())) {
                AnswersView answersView = new AnswersView();
                answersView.setAnswers(completesQuestion);
                EvaluationQuestionnaireModel evaluational
                        = evaluationQuestionnaireBusinessMapper
                        .selectByPrimaryKey(publishQuestionId.getQuestionnaireId());

                answersView.setEvaluationQuestionnaire(evaluational);
                evaluational.setContent(null);
                return RespondsMessage.success("获取答案完成", answersView);
            }
        }
        return RespondsMessage.success("未作答");
    }


    @Data
    public static class AnswersView {

        private EvaluationQuestionnaireModel evaluationQuestionnaire;

        private PublishAttachInfo.CompletesQuestion answers;

    }

    /**
     * 查看发布评教卷的评分
     *
     * @param publishId
     * @return
     */
//    @GetMapping(value = "/score")
//    public RespondsMessage teacherViewStat(@RequestParam(value = "publishId") Integer publishId) {
//        return RespondsMessage.success("获取统计结果完成",
//                publishquestionnaireService.getQuestionStatisticalScore(publishId));
//    }

    /**
     * 查看发布评教卷的评分
     * 专业维度
     *
     * @param id
     * @return
//     */
//    @GetMapping(value = "/profession/score")
//    public RespondsMessage professionScore(@RequestParam(value = "id") Integer id) {
//        Map<String, Object> map = publishquestionnaireService.professionScoreStatistics(id);
//        switch ((Integer) map.get("status")) {
//            case 1:
//                return RespondsMessage.success("该专业未发布评教卷", null);
//            case 2:
//                return RespondsMessage.success("评教卷还未完全回收", null);
//            case 3:
//                return RespondsMessage.success("获取统计结果完成",
//                        map.get("data"));
//        }
//        return null;
//    }

    /**
     * 查看发布评教卷的评分
     * 学院维度
     *
     * @param id
     * @return
//     */
//    @GetMapping(value = "/factory/score")
//    public RespondsMessage factoryScore(@RequestParam(value = "id") Integer id) {
//        Map<String, Object> map = publishquestionnaireService.professionScoreStatistics(id);
//        switch ((Integer) map.get("status")) {
//            case 1:
//                return RespondsMessage.success("该专业未发布评教卷", null);
//            case 2:
//                return RespondsMessage.success("评教卷还未完全回收", null);
//            case 3:
//                return RespondsMessage.success("获取统计结果完成",
//                        map.get("data"));
//        }
//        return null;
//    }


}
