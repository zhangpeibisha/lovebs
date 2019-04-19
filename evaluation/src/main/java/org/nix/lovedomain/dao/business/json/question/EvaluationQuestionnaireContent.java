package org.nix.lovedomain.dao.business.json.question;

import lombok.Data;
import org.nix.lovedomain.dao.business.json.question.base.BaseQuestion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 在数据库中为json格式的内容
 * @date 2019/4/12
 */
@Data
public class EvaluationQuestionnaireContent {

    /**
     * 问题集合
     */
    private List<BaseQuestion> questions;

    public void addQuestion(BaseQuestion question) {
        if (questions == null) {
            questions = new ArrayList<>();
        }
        questions.add(question);
    }

    public void addQuestions(Collection<BaseQuestion> question) {
        if (questions == null) {
            questions = new ArrayList<>();
        }
        questions.addAll(question);
    }
}
