package org.nix.lovedomain.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.lovedomain.EvaluationApplication;
import org.nix.lovedomain.dao.business.json.question.QuestionnaireEnum;
import org.nix.lovedomain.dao.business.json.winding.PublishAttachInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @anthor on 2019/5/2
 * @since jdk8
 */

@SpringBootTest(classes = EvaluationApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PublishquestionnaireServiceTest {

    @Autowired
    PublishquestionnaireService publishquestionnaireService;

    /**
     * 添加回答
     */
    @Test
    public void writeQuestion(){
        Principal principal = () -> "15802314793";

        //第一个学生的回答
        PublishAttachInfo.CompletesQuestion completesQuestion
                = new PublishAttachInfo.CompletesQuestion();
        completesQuestion.setStudentId(1);
        completesQuestion.setStatus(PublishAttachInfo.CompletesQuestion.STATUS_COMMIT);
        List<PublishAttachInfo.QuestionReply> questionReplies = new ArrayList<>();
        PublishAttachInfo.QuestionReply reply1 = new PublishAttachInfo.QuestionReply();
        reply1.setScore(1);
        reply1.setQuestionnaireEnum(QuestionnaireEnum.CHOSE_SINGLE);
        PublishAttachInfo.QuestionReply reply2 = new PublishAttachInfo.QuestionReply();
        reply2.setScore(2);
        reply2.setQuestionnaireEnum(QuestionnaireEnum.CHOSE_SINGLE);
        questionReplies.add(reply1);
        questionReplies.add(reply2);

        publishquestionnaireService.writeQuestion(215,completesQuestion,principal);

    }
}
