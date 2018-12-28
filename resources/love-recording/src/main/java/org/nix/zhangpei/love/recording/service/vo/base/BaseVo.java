package org.nix.zhangpei.love.recording.service.vo.base;

import org.nix.zhangpei.love.recording.dao.po.base.BasePO;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/27
 */
public class BaseVo {

    protected Long id;

    protected Long createTime;

    protected Long updateTime;

    protected void setBaseVO(BasePO basePO){
        id = basePO.getId();
        createTime = basePO.getCreateTime();
        updateTime = basePO.getUpdateTime();
    }

    protected BaseVo getBaseVO(){
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
