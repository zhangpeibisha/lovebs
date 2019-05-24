package org.nix.lovedomain.service;

import cn.hutool.core.collection.CollUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.lovedomain.EvaluationApplication;
import org.nix.lovedomain.dao.business.json.question.ChoseQuestionItem;
import org.nix.lovedomain.dao.business.json.question.base.BaseQuestion;
import org.nix.lovedomain.dao.model.EvaluationQuestionnaireModel;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.security.Principal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EvaluationApplication.class)
public class EvaluationQuestionnaireServiceTest {

    @Resource
    private EvaluationQuestionnaireService evaluationQuestionnaireService;

    @Test
    @Transactional
    public void createSimpleQuestion() {

        Principal principal = () -> "956936479";
        EvaluationQuestionnaireModel simpleQuestion
                = evaluationQuestionnaireService.createSimpleQuestion("张沛的测试问卷",
                "张沛的测试问卷",
                principal);
        ChoseQuestionItem item = new ChoseQuestionItem();
        item.setSort(10);
        item.setWeights(20);
        item.setTitle("测试题");

        BaseQuestion<ChoseQuestionItem> objectBaseQuestion = new BaseQuestion<>();
        objectBaseQuestion.addItem(item);

        evaluationQuestionnaireService.addQuestion(simpleQuestion.getId(),CollUtil.newArrayList(objectBaseQuestion),principal);
    }

}