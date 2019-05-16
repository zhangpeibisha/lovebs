package org.nix.lovedomain.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.lovedomain.EvaluationApplication;
import org.nix.lovedomain.dao.mapper.PublishquestionnaireMapper;
import org.nix.lovedomain.model.Publishquestionnaire;
import org.nix.lovedomain.service.EmailService;
import org.nix.lovedomain.utils.EmailContent;
import org.nix.lovedomain.utils.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @anthor on 2019/5/16
 * @since jdk8
 */
@SpringBootTest(classes = EvaluationApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class EmailUtilTest {

    @Resource
    PublishquestionnaireMapper publishquestionnaireMapper;

    @Autowired
    EmailService emailService;


    @Test
    public void testSendEmail(){
        Publishquestionnaire publishquestionnaire
                = publishquestionnaireMapper.selectByPrimaryKey(827);
        emailService.sendPublishQuestionNotice(publishquestionnaire,1);

//        List<String> address = new ArrayList<>();
//        for(int i = 0; i < 3; i++){
//           address.add("1318699937@qq.com");
//        }
//        EmailUtil.sendEmail(EmailContent.SEND_S_END.toContent("李白","计算机导论"),address);
    }
}
