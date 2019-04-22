package org.nix.lovedomain.web.controller;

import org.nix.lovedomain.model.Account;
import org.nix.lovedomain.model.Publishquestionnaire;
import org.nix.lovedomain.service.AccountService;
import org.nix.lovedomain.service.ServiceException;
import org.nix.lovedomain.web.controller.base.BaseController;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Date;

/**
 * @version 1.0
 * @anthor on 2019/4/19
 * @since jdk8
 */
@Controller
@RequestMapping(value = "publishquestionnaire")
public class PublishquestionnaireController extends BaseController<Publishquestionnaire> {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/publish")
    public RespondsMessage pusblishQuestionnaire(Principal principal,
                                                 Integer courseId,
                                                 Integer teacherId,
                                                 Integer questionnaireId,
                                                 String description,
                                                 Long startRespondTime,
                                                 Long endRespondTime) {

        if (principal == null){
            throw new ServiceException("用户未登陆");
        }
        Publishquestionnaire publishquestionnaire = new Publishquestionnaire();
        publishquestionnaire.setCourseid(courseId);
        publishquestionnaire.setDescription(description);
        publishquestionnaire.setEndrespondtime(new Date(endRespondTime));
        publishquestionnaire.setStartrespondtime(new Date(startRespondTime));
        publishquestionnaire.setQuestionnaireid(questionnaireId);
        publishquestionnaire.setTeacherid(teacherId);

        String name = principal.getName();
        Account userByAccount = accountService.findUserByAccount(name);
        publishquestionnaire.setReleaseid(userByAccount.getId());

        // 根据课程id和老师id找到相应的学生id




        return null;
    }


}
