package org.nix.zhangpei.account.model;

import org.nix.zhangpei.account.model.base.BasePO;

import java.util.Objects;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/22
 */
public class RolePO extends BasePO {
    private String name;
    private String description;

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
        RolePO rolePO = (RolePO) o;
        return Objects.equals(name, rolePO.name) &&
                Objects.equals(description, rolePO.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), name, description);
    }

    @Override
    public String toString() {
        return "RolePO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", createTime=" + createTime +
                ", updateTIme=" + updateTIme +
                '}';
    }
}
