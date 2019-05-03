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
import org.nix.lovedomain.service.vo.EvaluationquestionnaireSimpleVo;
import org.nix.lovedomain.service.vo.PageVo;
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
@Api(value = "问卷相关接口", description = "描述了问卷在本系统中的所有业务操作(测试通过)")
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
                    .logInfo(log, "用户{}在问卷【{}】中添加问题成功", principal.getName(),
                            evaluationquestionnaire.getTitle()), evaluationquestionnaire);
        }
        throw new ServiceException(StrUtil.format("请检查问卷{}是否存在", questionId));
    }

    @ApiOperation(value = "更新一个问题", notes = "需要提供更新的问卷id和问题更新后的信息，id和旧问题保持一致")
    @PutMapping(value = "/question")
    public RespondsMessage updateQuestion(@RequestParam(value = "questionId") Integer questionId,
                                          @RequestBody BaseQuestion<? extends BaseItem> question,
                                          Principal principal) {
        Evaluationquestionnaire evaluationquestionnaire
                = evaluationquestionnaireService.updateQuestionItem(questionId, question, principal);
        if (evaluationquestionnaire != null) {
            return RespondsMessage.success(LogUtil
                    .logInfo(log, "用户{}在问卷【{}】中更新问题{}成功", principal.getName(),
                            evaluationquestionnaire.getTitle(), question.getId()), evaluationquestionnaire);
        }
        throw new ServiceException(StrUtil.format("请检查问卷{}是否存在", questionId));
    }

    @ApiOperation(value = "删除一个问题", notes = "需要提供删除的问卷id和问题id信息的信息")
    @DeleteMapping(value = "/question")
    public RespondsMessage deleteQuestion(@RequestParam(value = "questionId") Integer questionId,
                                          @RequestBody BaseQuestion<? extends BaseItem> question,
                                          Principal principal) {
        Evaluationquestionnaire evaluationquestionnaire
                = evaluationquestionnaireService.deleteQuestionItem(questionId, question, principal);
        if (evaluationquestionnaire != null) {
            return RespondsMessage.success(LogUtil
                    .logInfo(log, "用户{}在问卷【{}】中删除问题{}成功", principal.getName(),
                            evaluationquestionnaire.getTitle(), question.getId()), evaluationquestionnaire);
        }
        throw new ServiceException(LogUtil.logInfo(log, "请检查问卷{}是否存在", questionId));
    }

    @ApiOperation(value = "查询用户自己拥有的问卷列表", notes = "用户登陆后，且拥有权限时可以查看自己的所有创建的问卷")
    @GetMapping(value = "/own/list")
    public RespondsMessage findOwnEvaluationquestionnairePage(Principal principal,
                                                              @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                              @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                                              @RequestParam(value = "query", required = false) String query,
                                                              @RequestParam(value = "like", defaultValue = "false") Boolean like) {
        PageVo<EvaluationquestionnaireSimpleVo> ownEvaluationquestionnairePage
                = evaluationquestionnaireService.findOwnEvaluationquestionnairePage(principal, page, limit, query, like);
        if (ownEvaluationquestionnairePage != null) {
            return RespondsMessage.success(LogUtil
                    .logInfo(log, "用户{}访问自己的问卷完成", principal.getName()), ownEvaluationquestionnairePage);
        }
        throw new ServiceException(LogUtil.logInfo(log, "查询用户拥有的问卷失败"));
    }


    @ApiOperation(value = "查询所有在册的问卷", notes = "用户登陆后，且拥有权限时可以查看所有创建的问卷")
    @GetMapping(value = "/all/list")
    public RespondsMessage findAllEvaluationquestionnairePage(Principal principal,
                                                              @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                              @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                                              @RequestParam(value = "query", required = false) String query,
                                                              @RequestParam(value = "like", defaultValue = "false") Boolean like) {
        if (principal == null) {
            return RespondsMessage.failurePermission(LogUtil
                    .logWarn(log, "未登陆的用户查询问卷信息"));
        }
        PageVo<EvaluationquestionnaireSimpleVo> ownEvaluationquestionnairePage
                = evaluationquestionnaireService.findAllEvaluationquestionnairePage(page, limit, query, like);
        String userName = principal.getName();
        if (ownEvaluationquestionnairePage != null) {
            return RespondsMessage.success(LogUtil
                    .logInfo(log, "用户{}所有的问卷完成", userName), ownEvaluationquestionnairePage);
        }
        throw new ServiceException(LogUtil.logInfo(log, "用户{}查询所有问卷失败", userName));
    }
}
