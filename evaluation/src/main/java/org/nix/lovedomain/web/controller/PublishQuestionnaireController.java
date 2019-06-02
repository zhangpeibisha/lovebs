package org.nix.lovedomain.web.controller;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.PublishQuestionBusinessMapper;
import org.nix.lovedomain.dao.business.json.winding.PublishAttachInfo;
import org.nix.lovedomain.dao.model.PublishQuestionnaireModel;
import org.nix.lovedomain.service.PublishQuestionnaireService;
import org.nix.lovedomain.service.ServiceException;
import org.nix.lovedomain.service.StatisticsScoreService;
import org.nix.lovedomain.service.StudentCourseService;
import org.nix.lovedomain.service.enums.Permission;
import org.nix.lovedomain.service.enums.RoleEnum;
import org.nix.lovedomain.service.vo.PublishQuestionJsonVo;
import org.nix.lovedomain.service.vo.StatisticsQuestionVo;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.List;

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
    private StudentCourseService studentCourseService;

    @Resource
    private PublishQuestionBusinessMapper publishQuestionBusinessMapper;

    @Resource
    private StatisticsScoreService statisticsScoreService;

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
    @Permission(name = "提交回答信息", role = {RoleEnum.STUDENT})
    @ApiOperation(value = "提交回答信息")
    @PostMapping(value = "/writeQuestion")
    public RespondsMessage writeQuestion(@RequestParam(value = "publishId") Integer publishId,
                                         @RequestBody String completesQuestion,
                                         Principal principal) {
        PublishAttachInfo.CompletesQuestion question = JSON.parseObject(completesQuestion, PublishAttachInfo.CompletesQuestion.class);
        PublishQuestionnaireModel publication = publishquestionnaireService.fillInTheAnswer(publishId, question, principal);
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
        return RespondsMessage.success("获取发布评教卷信息完成", publishquestionnaireService.findPublishQuestionDetail(ids));
    }

    /**
     * 老师阅读了发布的评教卷信息
     *
     * @return
     */
    @Permission(name = "批量获取发布评教卷的信息", role = RoleEnum.TEACHER)
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
    @Permission(name = "批量获取发布评教卷的信息", role = RoleEnum.STUDENT)
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
    @Permission(name = "查询学生在这个评教卷中回答的问题", role = RoleEnum.STUDENT)
    @GetMapping(value = "/answers")
    public RespondsMessage findStudentAnswers(@RequestParam(value = "publishId") Integer publishId,
                                              Principal principal) {
        StudentCourseService.AnswersView answersView = studentCourseService.createStudentAnsersView(publishId, principal);
        return RespondsMessage.success("获取学生回答完成", answersView);
    }


    @GetMapping(value = "/findById")
    public RespondsMessage findById(@RequestParam(value = "id") Integer id) {
        PublishQuestionnaireModel model = publishQuestionBusinessMapper.selectByPrimaryKey(id);
        return RespondsMessage.success("获取发布的评教卷成功", model);
    }

    /**
     * 通过发布的评教卷id查询统计分数
     *
     * @param publishId 发布的评教卷id
     * @return 统计信息
     */
    @GetMapping(value = "/statisticsScore")
    public RespondsMessage statisticsScore(@RequestParam(value = "publishId") Integer publishId) throws JsonProcessingException {
        StatisticsQuestionVo questionVo = statisticsScoreService.findQuestionVo(publishId);
        return RespondsMessage.success(StrUtil.format("查询发布的评教卷{}信息成功", publishId), questionVo);
    }

    /**
     * 查询学生是否回答了评教卷
     *
     * @param publishId
     * @param principal
     * @return
     */
    @GetMapping(value = "/check/answer")
    public RespondsMessage checkStudentAnswer(@RequestParam(value = "publishId") Integer publishId,
                                              Principal principal) {
        boolean answerQuestion = studentCourseService.checkStudentAnswerQuestion(principal, publishId);
        return RespondsMessage.success("判断学生是否回答了问题了", answerQuestion);
    }

}
