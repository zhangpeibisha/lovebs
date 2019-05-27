package org.nix.lovedomain.dao.business.json.question;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.Data;
import org.nix.lovedomain.dao.business.json.question.base.BaseItem;
import org.nix.lovedomain.dao.business.json.question.base.BaseQuestion;
import org.nix.lovedomain.dao.model.EvaluationQuestionnaireModel;

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
     * 想评教卷中添加问题
     *
     * @param question 问题
     */
    public void addQuestion(BaseQuestion<? extends BaseItem> question) {
        if (questions == null) {
            questions = new ArrayList<>();
        }
        addId(question);
        questions.add(question);
    }

    public List<BaseQuestion> getQuestions() {
        return questions;
    }

    public void addQuestions(List<BaseQuestion> questions) {
        questions.forEach(question -> addId(question));
        this.questions = questions;
    }

    /**
     * 更新评教卷中的一个问题，必须携带id进入
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
        question.forEach(this::addId);
        questions.addAll(question);
    }

    /**
     * 通过评教卷对象获取到评教卷内容的bean形式
     *
     * @param evaluationQuestionnaireModel 评教卷信息
     * @return 评教卷内容的bean
     */
    public static EvaluationQuestionnaireContent getContentBean(EvaluationQuestionnaireModel evaluationQuestionnaireModel) {
        if (evaluationQuestionnaireModel == null) {
            return null;
        }
        String jsonContent = evaluationQuestionnaireModel.getContent();
        if (jsonContent == null) {
            return new EvaluationQuestionnaireContent();
        }
        return JSON.parseObject(jsonContent, EvaluationQuestionnaireContent.class);
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


    private void addId(BaseQuestion<? extends BaseItem> baseQuestion) {
        addQuestionId(baseQuestion);
        addItemId(baseQuestion);
    }

    private void addQuestionId(BaseQuestion baseQuestion) {
        baseQuestion.setId(IdUtil.simpleUUID());
    }

    public void addItemId(BaseQuestion<? extends BaseItem> baseQuestion) {
        baseQuestion = JSON.parseObject(JSON.toJSONString(baseQuestion),
                new TypeReference<BaseQuestion<? extends BaseItem>>(){});
        List<? extends BaseItem> items = JSON.parseObject(JSON.toJSONString(baseQuestion.getItems()),
                new TypeReference<List<BaseItem>>(){});
        if (items != null) {
            for (BaseItem baseItem : items) {
                if (baseItem.getId() == null) {
                    baseItem.setId(IdUtil.simpleUUID());
                }
            }
        }
    }
}
