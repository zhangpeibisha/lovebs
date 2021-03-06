package org.nix.lovedomain.dao.business.json.question;

import lombok.Getter;
import org.nix.lovedomain.dao.business.json.question.base.BaseItem;

/**
 * @author zhangpei
 * @version 1.0
 * @description 问卷问题类型
 * @date 2019/4/12
 */
@Getter
public enum QuestionnaireEnum {

    /**
     * 问卷类型
     * 1. 1类型为选择类型
     * 2. 2类型为填空类型
     */
    CHOSE_SINGLE("单选", 10, ChoseQuestionItem.class),
    CHOSE_MULTI("多选", 11, ChoseQuestionItem.class),
    FILL_BLANK_SINGLE("单项填空", 20, FillBlankQuestionItem.class);

    private String name;

    private Integer type;

    private Class<? extends BaseItem> classType;

    QuestionnaireEnum(String name, int type, Class<? extends BaseItem> classType) {
        this.name = name;
        this.type = type;
        this.classType = classType;
    }
}
