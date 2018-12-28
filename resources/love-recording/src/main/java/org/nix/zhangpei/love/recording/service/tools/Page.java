package org.nix.zhangpei.love.recording.service.tools;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/27
 */
public class Page<T> {

    /**
     * 全部多少数据
     */
    private Long count;
    /**
     * 页码
     */
    private Long pageNum;
    /**
     * 每页大小
     */
    private Long pageSize;
    /**
     * 数据域
     */
    private List<T> datas;

    private Page() {
    }

    public Page setDataCount(Long count) {
        this.count = count;
        return this;
    }

    public Page setPageNum(Long pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public Page setPageSize(Long pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Page addData(T data) {
        if (datas == null){
            datas = new ArrayList<T>();
        }
        datas.add(data);
        return this;
    }

    public Page addAllData(List<T> data) {
        if (datas == null){
            datas = new ArrayList<T>();
        }
        datas.addAll(data);
        return this;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getPageNum() {
        return pageNum;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "Page{" +
                "count=" + count +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", datas=" + datas +
                '}';
    }
}
