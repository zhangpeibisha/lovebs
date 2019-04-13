package org.nix.lovedomain.dao.business.json.question;

import lombok.Data;
import org.nix.lovedomain.dao.business.json.question.base.BaseItem;

/**
 * @author zhangpei
 * @version 1.0
 * @description 填空相关模型
 * @date 2019/4/13
 */
@Data
public class FillBlankQuestionItem extends BaseItem {

    /**
     * 填空题高宽
     */
    private Double high;
    private Double width;
    /**
     * 最大字数
     */
    private Integer maxSize;

    /**
     * 默认值和是否默认
     */
    private Boolean defaults;
    private String defaultsValue;


}
