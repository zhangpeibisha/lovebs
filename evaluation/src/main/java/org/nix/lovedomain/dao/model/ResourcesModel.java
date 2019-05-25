package org.nix.lovedomain.dao.model;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import lombok.Data;
import org.nix.lovedomain.service.enums.RequestEnum;
import org.nix.lovedomain.utils.ListUtils;
import tk.mybatis.mapper.annotation.NameStyle;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/5/23
 */
@Data
@NameStyle
@Table(name = "resources")
public class ResourcesModel {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String url;

    private String name;

    private String description;

    private Boolean enable;

    private String method;

    /**
     * 获取请求方法
     *
     * @return
     */
    public List<RequestEnum> findRequestMethods() {
        if (StrUtil.isEmpty(method)) {
            return null;
        }
        String[] split = method.split(",");
        List<RequestEnum> requestEnums = new ArrayList<>(split.length);
        for (String method : split) {
            requestEnums.add(RequestEnum.valueOf(method));
        }
        return requestEnums;
    }

    /**
     * 添加可访问的方法
     *
     * @param methods 可请求的方法
     */
    public void addRequestMethods(List<String> methods) {
        if (CollUtil.isEmpty(methods)) {
            return;
        }
        this.method = method == null ? "" : method + "," + ListUtils.lsitIdsToString(methods);
    }

    /**
     * 添加可访问的方法
     *
     * @param methods 可请求的方法
     */
    public void addRequestMethods(String methods) {
        if (StrUtil.isEmpty(methods)) {
            return;
        }
        this.method = method == null ? "" : method + "," + methods;
    }


}
