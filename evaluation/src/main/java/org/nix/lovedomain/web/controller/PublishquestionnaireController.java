package org.nix.lovedomain.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.model.Publishquestionnaire;
import org.nix.lovedomain.service.PublishquestionnaireService;
import org.nix.lovedomain.service.ServiceException;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.web.controller.base.BaseController;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

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
                                                 @RequestParam(value = "questionnaireId")Integer questionnaireId,
                                                 @RequestParam(value = "description",required = false)String description,
                                                 @RequestParam(value = "startRespondTime")Long startRespondTime,
                                                 @RequestParam(value = "endRespondTime")Long endRespondTime) throws Exception {

        if (principal == null) {
            throw new ServiceException("用户未登陆");
        }
        Publishquestionnaire publishquestionnaire = publishquestionnaireService.pusblishQuestionnaire(principal,
                courseId, teacherId, questionnaireId, description, startRespondTime, endRespondTime);

        return RespondsMessage.success(LogUtil.logInfo(log, "{}发布评教问卷成功", principal.getName()),
                publishquestionnaire);
    }


}
