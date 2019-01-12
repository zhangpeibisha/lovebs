package org.nix.zpbs.model;

import java.io.Serializable;

public class SysResource implements Serializable {
    /**
     * 自增ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 资源名字
     *
     * @mbggenerated
     */
    private String resourceName;

    /**
     * 资源URL
     *
     * @mbggenerated
     */
    private String resourceUrl;

    /**
     * 资源开关,0为开，1为关
     *
     * @mbggenerated
     */
    private Integer resourceSwitch;

    /**
     * 权限描述
     *
     * @mbggenerated
     */
    private String resourceDescription;

    /**
     * 资源类型
     *
     * @mbggenerated
     */
    private Integer resourceType;

    /**
     * 父级资源
     *
     * @mbggenerated
     */
    private Long resourcePrent;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public Integer getResourceSwitch() {
        return resourceSwitch;
    }

    public void setResourceSwitch(Integer resourceSwitch) {
        this.resourceSwitch = resourceSwitch;
    }

    public String getResourceDescription() {
        return resourceDescription;
    }

    public void setResourceDescription(String resourceDescription) {
        this.resourceDescription = resourceDescription;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    public Long getResourcePrent() {
        return resourcePrent;
    }

    public void setResourcePrent(Long resourcePrent) {
        this.resourcePrent = resourcePrent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", resourceName=").append(resourceName);
        sb.append(", resourceUrl=").append(resourceUrl);
        sb.append(", resourceSwitch=").append(resourceSwitch);
        sb.append(", resourceDescription=").append(resourceDescription);
        sb.append(", resourceType=").append(resourceType);
        sb.append(", resourcePrent=").append(resourcePrent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}