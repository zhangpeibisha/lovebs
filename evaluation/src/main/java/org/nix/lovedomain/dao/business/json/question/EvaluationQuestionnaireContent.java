package org.nix.lovedomain.dao.business.json.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangpei
 * @version 1.0
 * @description 在数据库中为json格式的内容
 * @date 2019/4/12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationQuestionnaireContent {
    /**
     * 问卷题目
     */
    private String title;
    /**
     * 问卷描述
     */
    private String description;


}
