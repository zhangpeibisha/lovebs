package org.nix.lovedomain.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.model.Evaluationquestionnaire;
import org.nix.lovedomain.service.EvaluationquestionnaireService;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.web.controller.base.BaseController;
import org.nix.lovedomain.web.controller.base.RespondsMessage;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@Transactional(rollbackFor = Exception.class)
@RequestMapping(value = "/evaluationquestionnaire")
public class EvaluationquestionnaireController extends BaseController<Evaluationquestionnaire> {

    @Resource
    private EvaluationquestionnaireService evaluationquestionnaireService;

    @ApiOperation(value = "创建问卷，需要提供一个问卷题目")
    @PostMapping(value = "/create")
    public RespondsMessage createQuestionnaire(@RequestParam(value = "title") String title,
                                               @RequestParam(value = "description", required = false) String description,
                                               Principal principal) throws Exception {
        Evaluationquestionnaire evaluationquestionnaire = new Evaluationquestionnaire();
        evaluationquestionnaire.setTitle(title);
        evaluationquestionnaire.setAuthorid(3);
        evaluationquestionnaire.setDescritption(description);
        Integer add = evaluationquestionnaireService.add(evaluationquestionnaire);
        return RespondsMessage.success(LogUtil
                .logInfo(log, "用户{}创建问卷{}成功:{}", 1, add, principal == null ? "游客" : principal.getName()));
    }


}
