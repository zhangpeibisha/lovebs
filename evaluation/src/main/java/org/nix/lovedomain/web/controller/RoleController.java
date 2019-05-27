package org.nix.lovedomain.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.service.enums.Permission;
import org.nix.lovedomain.service.enums.RoleEnum;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 */
@Slf4j
@RestController
@RequestMapping(value = "role")
public class RoleController {

    /**
     * 上传教学任务信息，管理员使用
     * @param role
     */
    @Permission(name = "excel上传系统角色信息",
            description = "管理员通过上传格式化的excel文件，可以达到批量上传角色信息目的",
            role = RoleEnum.MANGER)
    @PostMapping(value = "/excel")
    public void uploadRole(MultipartFile role){
        log.info("上传的文件名字为{}",role.getOriginalFilename());
        log.info("上传的文件的大小为{}",role.getSize());
    }

}
