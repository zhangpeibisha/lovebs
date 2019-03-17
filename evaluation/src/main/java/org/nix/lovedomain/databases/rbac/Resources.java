package org.nix.lovedomain.databases.rbac;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class Resources implements Serializable {
    private Integer id;

    /**
     * 资源的url，可以写成 /user/**的格式
     *
     * @mbggenerated
     */
    private String url;

    private String name;

    private String description;

    /**
     * 是否启用 0标识启用 1标识禁用
     *
     * @mbggenerated
     */
    private Byte use;

    /**
     * 0标识必须认证后才能访问 1标识可以不认证就可以访问
     *
     * @mbggenerated
     */
    private Byte permissionall;

    /**
     * url请求方法，默认为get方法
     *
     * @mbggenerated
     */
    private String method;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Byte getUse() {
        return use;
    }

    public void setUse(Byte use) {
        this.use = use;
    }

    public Byte getPermissionall() {
        return permissionall;
    }

    public void setPermissionall(Byte permissionall) {
        this.permissionall = permissionall;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", url=").append(url);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", use=").append(use);
        sb.append(", permissionall=").append(permissionall);
        sb.append(", method=").append(method);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}