package org.nix.lovedomain.dao.business.json.winding;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.nix.lovedomain.dao.business.json.question.EvaluationQuestionnaireContent;
import org.nix.lovedomain.dao.business.json.question.base.BaseItem;
import org.nix.lovedomain.dao.business.json.question.base.BaseQuestion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 * <p>
 * 存储所有的题目的描述
 * 存储所有题目选项的描述
 */
@Data
public class QuestionList {

    /**
     * 每个问题的题目
     */
    private Map<String, String> questionTitleMap;

    /**
     * 每个选项的描述
     */
    private Map<String, String> optionDescrpMap;

    public QuestionList(Map<String, String> questionTitleMap, Map<String, String> optionDescrpMap) {
        this.questionTitleMap = questionTitleMap;
        this.optionDescrpMap = optionDescrpMap;
    }

    public QuestionList() {
    }

    /**
     * 提取题目内容
     *
     * @param evaluationQuestionnaireContent
     * @return
     */
    public static QuestionList toQuestionList(EvaluationQuestionnaireContent evaluationQuestionnaireContent) {
        Map<String, String> questionTitleMap = new HashMap<>();
        Map<String, String> optionDescrpMap = new HashMap<>();
        for (BaseQuestion question :
                evaluationQuestionnaireContent.getQuestions()) {
            questionTitleMap.put(question.getId(), question.getTitle());
            List items = question.getItems();
            if (!CollUtil.isEmpty(items)) {
                for (Object item :
                        items) {
                    BaseItem baseItem = JSONObject.toJavaObject((com.alibaba.fastjson.JSONObject) item, BaseItem.class);
                    optionDescrpMap.put(baseItem.getId(), baseItem.getTitle());
                }
            }
        }
        return new QuestionList(questionTitleMap, optionDescrpMap);
    }
}