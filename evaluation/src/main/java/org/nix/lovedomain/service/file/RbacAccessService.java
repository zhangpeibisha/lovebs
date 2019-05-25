package org.nix.lovedomain.service.file;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Validator;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.ResourcesBusinessMapper;
import org.nix.lovedomain.dao.business.RoleBusinessMapper;
import org.nix.lovedomain.dao.business.RoleResourceBusinessMapper;
import org.nix.lovedomain.dao.model.ResourcesModel;
import org.nix.lovedomain.dao.model.RoleModel;
import org.nix.lovedomain.dao.model.RoleRescourseModel;
import org.nix.lovedomain.service.RoleService;
import org.nix.lovedomain.service.enums.Permission;
import org.nix.lovedomain.service.enums.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author zhangpei
 * @version 1.0
 * @description 权限服务，通过excel上传
 * @date 2019/5/25
 */
@Slf4j
@Service
public class RbacAccessService {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Resource
    private RoleBusinessMapper roleBusinessMapper;

    @Resource
    private RoleService roleService;

    @Resource
    private ResourcesBusinessMapper resourcesBusinessMapper;

    @Resource
    private RoleResourceBusinessMapper roleResourceBusinessMapper;

    /**
     * 表示为所有请求方法
     */
    private String ALL_METHOD = "";

    public void list() {
        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
            insertResourcesAndRole(m);
        }
    }

    public void insertResourcesAndRole(Map.Entry<RequestMappingInfo, HandlerMethod> methodEntry) {

        List<ResourcesModel> resourcesModels = new ArrayList<>();


        RequestMappingInfo mappingInfo = methodEntry.getKey();
        HandlerMethod methodEntryValue = methodEntry.getValue();
        Method method = methodEntryValue.getMethod();
        String methodName = method.getName();
        // 获取url
        PatternsRequestCondition patternsCondition = mappingInfo.getPatternsCondition();
        for (String url : patternsCondition.getPatterns()) {
            ResourcesModel resourcesModel = new ResourcesModel();
            // 配置url
            resourcesModel.setUrl(url);
            // 配置请求方法
            String requestMethod = requestMethod(mappingInfo);
            resourcesModel.addRequestMethods(requestMethod);
            // 配置默认名字和描述
            resourcesModel.setName(methodName);
            resourcesModel.setDescription(methodName);

            resourcesModels.add(resourcesModel);
        }

        Permission permission = findPermission(methodEntry);
        insertResourcesAndRole(resourcesModels, permission);

    }

    /**
     * 获取请求方法
     *
     * @param mappingInfo
     * @return
     */
    private String requestMethod(RequestMappingInfo mappingInfo) {
        RequestMethodsRequestCondition methodsCondition = mappingInfo.getMethodsCondition();
        String type = methodsCondition.toString();
        if (type != null && type.startsWith("[") && type.endsWith("]")) {
            String methods = type.substring(1, type.length() - 1);
            if (!ALL_METHOD.equals(methods)) {
                return methods;
            }
        }
        return "GET,POST,DELETE,PUT";
    }

    /**
     * 发现方法上的注解
     *
     * @param methodEntry
     * @return
     */
    private Permission findPermission(Map.Entry<RequestMappingInfo, HandlerMethod> methodEntry) {
        HandlerMethod methodEntryValue = methodEntry.getValue();
        return methodEntryValue.getMethodAnnotation(Permission.class);
    }

    private void insertResourcesAndRole(List<ResourcesModel> resourcesModels,
                                        Permission permission) {
        if (!CollUtil.isEmpty(resourcesModels)) {
            resourcesModels.forEach(resourcesModel ->
                    configResourcesAndRole(resourcesModel, permission));
        }
    }

    /**
     * 配置资源信息
     *
     * @param resourcesModel 资源信息
     * @param permission     权限配置信息
     */
    private void configResourcesAndRole(ResourcesModel resourcesModel, Permission permission) {

        if (permission == null) {
            resourcesBusinessMapper.insertSelective(resourcesModel);
            return;
        }

        String name = permission.name();
        // 获取资源名字
        resourcesModel.setName(name);
        // 配置描述，若没有配置则为资源名字
        String description = permission.description();
        if (Permission.NO_DESCRIPTION.equals(description)) {
            resourcesModel.setDescription(name);
        } else {
            resourcesModel.setDescription(description);
        }
        // 配置是否使用
        resourcesModel.setEnable(permission.enable());
        resourcesBusinessMapper.insertSelective(resourcesModel);
        // 获取资源id
        Integer resourcesModelId = resourcesModel.getId();
        RoleEnum[] role = permission.role();
        if (role.length != 0) {
            for (RoleEnum roleEnum : role) {
                RoleModel roleModel = checkAndInsertRole(roleEnum);
                Integer roleModelId = roleModel.getId();
                RoleRescourseModel roleRescourseModel = new RoleRescourseModel();
                roleRescourseModel.setResourceId(resourcesModelId);
                roleRescourseModel.setRoleId(roleModelId);
                roleResourceBusinessMapper.insertSelective(roleRescourseModel);
            }
        }
    }


    /**
     * 检测系统角色是否存在，若不存在则创建
     *
     * @param role
     * @return
     */
    public RoleModel checkAndInsertRole(RoleEnum role) {
        String name = role.getName();
        String description = role.getDescription();
        RoleModel roleModel = roleService.findRoleByName(name);
        if (roleModel != null) {
            return roleModel;
        }
        roleModel = new RoleModel();
        roleModel.setName(name);
        roleModel.setDescription(description);
        roleModel.setCreateTime(new Date());
        roleModel.setUpdateTime(new Date());
        int insertNumber = roleBusinessMapper.insertSelective(roleModel);
        Validator.validateTrue(insertNumber == 1, "插入角色失败");
        return roleModel;
    }


}
