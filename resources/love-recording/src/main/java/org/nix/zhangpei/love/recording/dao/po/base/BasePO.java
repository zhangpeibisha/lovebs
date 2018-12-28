package org.nix.zhangpei.love.recording.dao.po.base;

import org.nix.zhangpei.love.recording.service.vo.base.BaseVo;

import javax.persistence.Id;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/27
 */
public class BasePO {

    @Id
    protected Long id;

    protected Long createTime;

    protected Long updateTime;

    /**
     * 创建的时候方便设置创建时间和更新时间
     * @return 当前对象
     */
    public BasePO baseCreate(){
        createTime = System.currentTimeMillis();
        updateTime = System.currentTimeMillis();
        return this;
    }

    /**
     * 更新的时候方便设置更新时间
     * @return 当前对象
     */
    public BasePO baseUpdate(){
        updateTime = System.currentTimeMillis();
        return this;
    }

    public BasePO getBasePO(){
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "BasePO{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
