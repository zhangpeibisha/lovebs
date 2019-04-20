package org.nix.lovedomain.dao.business.json.question;

import cn.hutool.json.JSONUtil;
import lombok.Data;
import org.nix.lovedomain.dao.business.json.question.base.BaseQuestion;
import org.nix.lovedomain.model.Evaluationquestionnaire;

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

    public <T extends BaseQuestion> void addQuestion(T question) {
        if (questions == null) {
            questions = new ArrayList<>();
        }
        questions.add(question);
    }


    public  <T extends BaseQuestion> void addQuestions(Collection<T> question) {
        if (questions == null) {
            questions = new ArrayList<>();
        }
        questions.addAll(question);
    }

    public static EvaluationQuestionnaireContent getContentBean(Evaluationquestionnaire evaluationquestionnaire) {
        if (evaluationquestionnaire == null) {
            return null;
        }
        String jsonContent = evaluationquestionnaire.getContent();
        if (jsonContent == null) {
            return new EvaluationQuestionnaireContent();
        }
        return JSONUtil.toBean(jsonContent, EvaluationQuestionnaireContent.class);
    }
}
