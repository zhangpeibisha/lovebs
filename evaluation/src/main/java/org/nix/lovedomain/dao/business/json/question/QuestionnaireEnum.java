package org.nix.lovedomain.dao.business.json.question;

import lombok.Getter;

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
     * 3. 3类型为矩阵类型
     * 4. 4类型为打分题
     * 5. 5类型为简答题
     */
    CHOSE_SINGLE("单选", 10), CHOSE_MULTI("多选", 11),
    FILL_BLANK_SINGLE("单项填空", 20),
    MATRIX_SINGLE("矩阵单选", 30), MATRIX_MULTI("矩阵多选", 31),
    SCORE_QUANTIFICATION("量化表", 40),
    PROBLEM_SHORT_NSWER("简答题", 50);


    private String name;

    private Integer type;

    QuestionnaireEnum(String name, int type) {
        this.name = name;
        this.type = type;
    }
}
