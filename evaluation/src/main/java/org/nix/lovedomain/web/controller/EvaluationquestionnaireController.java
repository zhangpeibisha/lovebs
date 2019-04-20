package org.nix.lovedomain.web.controller;

import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.json.question.base.BaseItem;
import org.nix.lovedomain.dao.business.json.question.base.BaseQuestion;
import org.nix.lovedomain.model.Evaluationquestionnaire;
import org.nix.lovedomain.service.EvaluationquestionnaireService;
import org.nix.lovedomain.service.ServiceException;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.web.controller.base.BaseController;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * @version 1.0
 * @anthor on 2019/4/19
 * @since jdk8
 */
@Api(value = "问卷相关接口", description = "描述了问卷在本系统中的所有业务操作")
@Slf4j
@RestController
@RequestMapping(value = "/evaluationquestionnaire")
public class EvaluationquestionnaireController extends BaseController<Evaluationquestionnaire> {

    @Resource
    private EvaluationquestionnaireService evaluationquestionnaireService;

    @ApiOperation(value = "创建空问卷", notes = "一般在老师创建问卷的时候使用")
    @PostMapping(value = "/create")
    public RespondsMessage createQuestionnaire(
            @ApiParam(value = "问卷名字")
            @RequestParam(value = "title") String title,
            @ApiParam(value = "问卷描述")
            @RequestParam(value = "description", required = false) String description,
            @ApiParam(value = "认证用户信息")
                    Principal principal) throws Exception {
        Evaluationquestionnaire simpleQuestion = evaluationquestionnaireService.createSimpleQuestion(
                title, description, principal);
        return RespondsMessage.success(LogUtil
                .logInfo(log, "用户{}创建问卷{}成功，添加问卷id：{}", principal.getName(),
                        "【" + title + "】", simpleQuestion.getId()), simpleQuestion);
    }


    @ApiOperation(value = "添加一个问题", notes = "提供一个问卷id，为该问卷添加一个问题内容")
    @PostMapping(value = "/question")
    public RespondsMessage addQuestion(@RequestParam(value = "questionId") Integer questionId,
                                       @RequestBody BaseQuestion<? extends BaseItem> question,
                                       Principal principal) {
        Evaluationquestionnaire evaluationquestionnaire
                = evaluationquestionnaireService.addQuestion(questionId, question, principal);
        if (evaluationquestionnaire != null) {
            return RespondsMessage.success(LogUtil
                    .logInfo(log, "用户{}创建问卷{}成功，添加问卷id：{}", principal.getName(),
                            "【" + evaluationquestionnaire.getTitle() + "】", questionId), evaluationquestionnaire);
        }
        throw new ServiceException(StrUtil.format("查询{}问卷失败", questionId));
    }
}
