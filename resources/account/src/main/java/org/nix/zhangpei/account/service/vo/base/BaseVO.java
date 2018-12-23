package org.nix.zhangpei.account.service.vo.base;

import java.util.Objects;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/22
 */
public class BaseVO {
    protected Long id;
    protected Long createTime;
    protected Long updateTIme;

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

    public Long getUpdateTIme() {
        return updateTIme;
    }

    public void setUpdateTIme(Long updateTIme) {
        this.updateTIme = updateTIme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseVO basePO = (BaseVO) o;
        return Objects.equals(id, basePO.id) &&
                Objects.equals(createTime, basePO.createTime) &&
                Objects.equals(updateTIme, basePO.updateTIme);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, createTime, updateTIme);
    }

    @Override
    public String toString() {
        return "BasePO{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTIme=" + updateTIme +
                '}';
    }
}
