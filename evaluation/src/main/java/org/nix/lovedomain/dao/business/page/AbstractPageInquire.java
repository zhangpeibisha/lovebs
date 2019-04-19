package org.nix.lovedomain.dao.business.page;

import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @description 分页查询参数
 * @date 2019/4/7
 */
@Data
public abstract class AbstractPageInquire {

    /**
     * 查询页面
     */
    private Integer page;
    /**
     * 页面大小
     */
    private Integer limit;
    /**
     * 查询的字段值
     */
    private String quireField;
    /**
     * 是否是模糊查询
     */
    private boolean blurry;
    /**
     * 查询的值
     */
    private Object quireValue;

    /**
     * 具体的开始指针
     */
    private Integer startPoint;
    /**
     * 结束指针
     */
    private Integer endPoint;

    /**
     * 定义查询字段，需要在该字段校验是否含有字段值
     *
     * @param quireField 需要查询的字段
     */
    public void setQuireField(String quireField) {
        checkField(quireField);
        this.quireField = quireField;
    }

    /**
     * 检查字段是否符合要求
     *
     * @param quireField 待检查字段
     */
    protected abstract void checkField(String quireField);

    /**
     * 设置分页数据
     * @param page 当前页码
     * @param limit 分页大小
     */
    public void setPage(Integer page, Integer limit) {
        this.page = page;
        this.limit = limit;
        startPoint = (page - 1) * limit;
    }
}
