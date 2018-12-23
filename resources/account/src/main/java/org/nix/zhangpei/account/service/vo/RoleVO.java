package org.nix.zhangpei.account.service.vo;

import org.nix.zhangpei.account.model.RolePO;
import org.nix.zhangpei.account.service.vo.base.BaseVO;

import java.util.Objects;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/23
 */
public class RoleVO extends BaseVO {

    private String name;
    private String description;

    public RoleVO(RolePO rolePO) {
        name = rolePO.getName();
        description = rolePO.getDescription();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        RoleVO roleVO = (RoleVO) o;
        return Objects.equals(name, roleVO.name) &&
                Objects.equals(description, roleVO.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), name, description);
    }

    @Override
    public String toString() {
        return "RoleVO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", createTime=" + createTime +
                ", updateTIme=" + updateTIme +
                '}';
    }
}
