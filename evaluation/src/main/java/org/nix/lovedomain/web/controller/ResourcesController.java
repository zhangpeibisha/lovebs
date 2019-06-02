package org.nix.lovedomain.web.controller;

import io.swagger.annotations.Api;
import org.nix.lovedomain.service.ResourcesService;
import org.nix.lovedomain.service.enums.Permission;
import org.nix.lovedomain.service.enums.RoleEnum;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 */
@Api(value = "资源管理器", description = "管理该系统的访问权限")
@RestController
@RequestMapping(value = "resources")
public class ResourcesController {

    @Autowired
    private ResourcesService resourcesService;

    @Permission(name = "查询资源列表",enable = false,role = RoleEnum.MANGER)
    @GetMapping(value = "/list/by")
    public RespondsMessage findResourcesList(@RequestParam(value = "key", required = false) String key,
                                             @RequestParam(value = "page", defaultValue = "1") Integer page,
                                             @RequestParam(value = "limit", defaultValue = "10") Integer limit) {

        return RespondsMessage.success("请求资源列表完成", resourcesService.findResourcesPage(key, page, limit));
    }

}
