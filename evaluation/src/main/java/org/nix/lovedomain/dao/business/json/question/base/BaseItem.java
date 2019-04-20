package org.nix.lovedomain.dao.business.json.question.base;

import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @description 基础选项
 * @date 2019/4/13
 */
@Data
public class BaseItem {
    /**
     * 选项唯一id
     */
    private String id;
    /**
     * 选项名字
     */
    protected String title;
    /**
     * 选项说明，用于对用户提示
     */
    protected String prompt;
    /**
     * 是否必须填写
     */
    protected Boolean mustWriter;
    /**
     * 排序顺序
     */
    protected Integer sort;

}
