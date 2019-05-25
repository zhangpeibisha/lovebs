package org.nix.lovedomain.web.controller;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.json.question.base.BaseQuestion;
import org.nix.lovedomain.dao.model.EvaluationQuestionnaireModel;
import org.nix.lovedomain.service.EvaluationQuestionnaireService;
import org.nix.lovedomain.service.ServiceException;
import org.nix.lovedomain.service.enums.Permission;
import org.nix.lovedomain.service.enums.RoleEnum;
import org.nix.lovedomain.service.vo.EvaluationalSimpleVo;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 */
@Api(value = "评教卷相关接口", description = "描述了评教卷在本系统中的所有业务操作(测试通过)")
@Slf4j
@RestController
@RequestMapping(value = "/evaluationQuestionnaire")
public class EvaluationQuestionnaireController {

    @Resource
    private EvaluationQuestionnaireService evaluationquestionnaireService;

    @Permission(name = "创建空评教卷",role = RoleEnum.MANGER)
    @ApiOperation(value = "创建空评教卷", notes = "一般在老师创建评教卷的时候使用")
    @PostMapping(value = "/create")
    public RespondsMessage createQuestionnaire(
            @ApiParam(value = "评教卷名字")
            @RequestParam(value = "title") String title,
            @ApiParam(value = "评教卷描述")
            @RequestParam(value = "description", required = false) String description,
            @ApiParam(value = "认证用户信息")
                    Principal principal) throws Exception {
        EvaluationQuestionnaireModel simpleQuestion = evaluationquestionnaireService.createSimpleQuestion(
                title, description, principal);
        return RespondsMessage.success(LogUtil
                .logInfo(log, "用户{}创建评教卷{}成功，添加评教卷id：{}", principal.getName(),
                        "【" + title + "】", simpleQuestion.getId()), simpleQuestion);
    }


    @Permission(name = "一次性添加多个问题",role = RoleEnum.MANGER)
    @ApiOperation(value = "一次性添加多个问题", notes = "提供一个评教卷id，为该评教卷添加多个问题内容")
    @PostMapping(value = "/batch/add/question")
    public RespondsMessage addQuestion(@RequestParam(value = "evaluationId") Integer evaluationId,
                                       @RequestBody List<BaseQuestion> question,
                                       Principal principal) {
        EvaluationQuestionnaireModel evaluationquestionnaire
                = evaluationquestionnaireService.addQuestion(evaluationId, question, principal);
        if (evaluationquestionnaire != null) {
            return RespondsMessage.success(LogUtil
                    .logInfo(log, "用户{}在评教卷【{}】中添加问题成功", principal.getName(),
                            evaluationquestionnaire.getTitle()), evaluationquestionnaire);
        }
        throw new ServiceException(StrUtil.format("请检查评教卷{}是否存在", evaluationId));
    }


    @ApiOperation(value = "查询所有在册的评教卷", notes = "用户登陆后，且拥有权限时可以查看所有创建的评教卷")
    @GetMapping(value = "/all/list")
    public RespondsMessage findAllEvaluationalPage(Principal principal,
                                                   @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                   @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                                   @RequestParam(value = "query", required = false) String query) {

        Validator.validateNotNull(principal, "未登陆的用户查询评教卷信息");

        PageVo<EvaluationalSimpleVo> ownEvaluationalPage
                = evaluationquestionnaireService.findAllEvaluationalPage(page, limit, query);
        String userName = principal.getName();
        if (ownEvaluationalPage != null) {
            return RespondsMessage.success(LogUtil
                    .logInfo(log, "用户{}所有的评教卷完成", userName), ownEvaluationalPage);
        }
        throw new ServiceException(LogUtil.logInfo(log, "用户{}查询所有评教卷失败", userName));
    }

    @Permission(name = "获取评教卷信息")
    @GetMapping(value = "/question/by/id")
    public RespondsMessage findEvaluationQuestionnaireById(@RequestParam(value = "evaluationId") Integer evaluationId,
                                                           Principal principal) {
        return RespondsMessage.success("获取评教卷信息成功",
                evaluationquestionnaireService.getEvaluationsDeathVoById(evaluationId, principal));
    }
}
