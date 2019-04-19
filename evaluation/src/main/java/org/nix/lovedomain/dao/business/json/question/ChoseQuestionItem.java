package org.nix.lovedomain.dao.business.json.question;

import lombok.Data;
import org.nix.lovedomain.dao.business.json.question.base.BaseItem;

/**
 * @author zhangpei
 * @version 1.0
 * @description 选择题特有属性
 * @date 2019/4/13
 */
@Data
public class ChoseQuestionItem extends BaseItem {
    /**
     * 选项权重，可选
     */
    private Integer weights;
    /**
     * 是否默认
     */
    private Boolean defaults;

    /**
     * 默认权重为0
     */
    public ChoseQuestionItem() {
        this.weights = 0;
    }
}
