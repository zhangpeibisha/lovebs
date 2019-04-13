package org.nix.lovedomain.dao.business.json.question.base;

import lombok.Data;
import org.nix.lovedomain.dao.business.json.question.QuestionnaireEnum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 基本问题
 * @date 2019/4/13
 */
@Data
public class BaseQuestion<I> {
    /**
     * 题目唯一id
     */
    private Integer id;
    /**
     * 问题类型
     */
    protected QuestionnaireEnum questionnaireType;

    /**
     * 题目
     */
    protected String title;
    /**
     * 是否必须填写
     */
    protected Boolean mustWriter;

    /**
     * 对填写用户进行提示
     */
    protected String prompt;

    /**
     * 组成的单元项
     */
    private List<I> items;

    public BaseQuestion() {
        this.mustWriter = true;
    }

    public void addItem(I item) {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(item);
    }

    public void addItems(Collection<I> item) {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.addAll(item);
    }

    /**
     * 验证方法，验证问题要求和用户所答复的信息是否
     * 符合要求
     */
    public void verification() {

    }
}
