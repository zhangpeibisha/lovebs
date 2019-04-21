package org.nix.lovedomain.dao.business.json.question;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import lombok.Data;
import org.nix.lovedomain.dao.business.json.question.base.BaseItem;
import org.nix.lovedomain.dao.business.json.question.base.BaseQuestion;
import org.nix.lovedomain.model.Evaluationquestionnaire;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
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

    /**
     * 想问卷中添加问题
     *
     * @param question 问题
     */
    public void addQuestion(BaseQuestion<? extends BaseItem> question) {
        if (questions == null) {
            questions = new ArrayList<>();
        }
        setId(question);
        questions.add(question);
    }

    /**
     * 更新问卷中的一个问题，必须携带id进入
     *
     * @param baseQuestion 问题信息
     */
    public void updateQuestion(BaseQuestion<? extends BaseItem> baseQuestion) {
        Integer index = getQuestInListIndex(baseQuestion);
        if (index != null) {
            questions.remove(index.intValue());
        }
        questions.add(baseQuestion);
    }

    /**
     * 删除问题，不能为空
     *
     * @param objectBaseQuestion 问题id
     */
    public void deleteQuestion(BaseQuestion<? extends BaseItem> objectBaseQuestion) {
        if (objectBaseQuestion == null) {
            return;
        }
        Integer questInListIndex = getQuestInListIndex(objectBaseQuestion);
        if (questInListIndex != null) {
            questions.remove(questInListIndex.intValue());
        }
    }

    /**
     * 批量添加问题
     *
     * @param question 问题集合
     */
    public void addQuestions(Collection<? extends BaseQuestion<? extends BaseItem>> question) {
        if (questions == null) {
            questions = new ArrayList<>();
        }
        if (CollUtil.isEmpty(question)) {
            return;
        }
        question.forEach(this::setId);
        questions.addAll(question);
    }

    /**
     * 通过问卷对象获取到问卷内容的bean形式
     *
     * @param evaluationquestionnaire 问卷信息
     * @return 问卷内容的bean
     */
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

    private Integer getQuestInListIndex(BaseQuestion<? extends BaseItem> baseQuestion) {
        String questionId;
        if (CollUtil.isEmpty(questions) || baseQuestion == null
                || (questionId = baseQuestion.getId()) == null) {
            return null;
        }
        int index = -1;
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).getId().equals(questionId)) {
                index = i;
                break;
            }
        }
        return index == -1 ? null : index;
    }


    private void setId(BaseQuestion<? extends BaseItem> baseQuestion) {
        setQuestionId(baseQuestion);
        setItemId(baseQuestion);
    }

    private void setQuestionId(BaseQuestion baseQuestion) {
        baseQuestion.setId(IdUtil.simpleUUID());
    }

    public void setItemId(BaseQuestion<? extends BaseItem> baseQuestion) {
        List<? extends BaseItem> items = baseQuestion.getItems();
        if (items != null) {
            items.sort((Comparator<BaseItem>) (o1, o2) -> {
                Integer sort1 = o1.getSort();
                Integer sort2 = o2.getSort();
                if (sort1 == null && sort2 != null) {
                    return sort2;
                }
                if (sort1 != null && sort2 == null) {
                    return sort1;
                }
                if (sort1 != null) {
                    return sort1 - sort2;
                }
                return 0;
            });
            for (BaseItem baseItem : items) {
                if (baseItem.getId() == null) {
                    baseItem.setId(IdUtil.simpleUUID());
                }
            }
        }
    }
}
