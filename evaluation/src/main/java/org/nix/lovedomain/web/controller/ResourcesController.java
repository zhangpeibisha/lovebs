package org.nix.lovedomain.web.controller;

import io.swagger.annotations.Api;
import org.nix.lovedomain.model.Resources;
import org.nix.lovedomain.service.ResourcesService;
import org.nix.lovedomain.web.controller.base.BaseController;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @anthor on 2019/4/19
 * @since jdk8
 */
@Api(value = "资源管理器", description = "管理该系统的访问权限")
@RestController
@RequestMapping(value = "resources")
public class ResourcesController extends BaseController<Resources> {

    @Autowired
    private ResourcesService resourcesService;

    @GetMapping(value = "/list/by")
    public RespondsMessage findResourcesList(@RequestParam(value = "key", required = false) String key,
                                             @RequestParam(value = "page", defaultValue = "1") Integer page,
                                             @RequestParam(value = "limit", defaultValue = "10") Integer limit) {

        return RespondsMessage.success("请求资源列表完成", resourcesService.findResourcesPage(key, page, limit));
    }


}
