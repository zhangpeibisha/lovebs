package org.nix.lovedomain.service.enums;

/**
 * @author zhangpei
 * @version 1.0
 * @description 系统默认角色
 * @date 2019/5/25
 */
public enum RoleEnum {

    /**
     * 系统默认的角色信息
     */
    STUDENT("STUDENT", "学生"),
    TEACHER("TEACHER", "授课老师"),
    MANGER("MANGER", "系统管理员");

    private String name;

    private String description;

    RoleEnum(String name, String description) {
        this.name = name;
        this.description = description;
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
}
