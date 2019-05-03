package org.nix.lovedomain.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.json.winding.PublishAttachInfo;
import org.nix.lovedomain.model.Publishquestionnaire;
import org.nix.lovedomain.service.PublishquestionnaireService;
import org.nix.lovedomain.service.ServiceException;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.web.controller.base.BaseController;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
