package org.nix.lovedomain.web.controller;

import cn.hutool.json.JSONUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.model.Account;
import org.nix.lovedomain.service.AccountService;
import org.nix.lovedomain.service.vo.StudentVo;
import org.nix.lovedomain.service.vo.TeacherVo;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.web.controller.base.BaseController;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @version 1.0
 * @anthor on 2019/4/19
 * @since jdk8
 */
@Api(value = "账户管理器", description = "用于用户通用模块使用")
@Slf4j
@RestController
@RequestMapping(value = "/account")
public class AccountController extends BaseController<Account> {

    @Autowired
    private AccountService accountService;

    /**
     * 通过账户获取用户信息
     *
     * @param principal
     * @return
     */
    @GetMapping(value = "/user/info")
    public RespondsMessage findUserDeatilInfo(Principal principal) {
        if (principal == null) {
            return RespondsMessage.failurePermission("用户未登陆");
        }
        String name = principal.getName();
        StudentVo studentByAccountName = accountService.findStudentByAccountName(name);
        if (studentByAccountName != null) {
            return RespondsMessage.success(LogUtil.logInfo(log, "学生{}的信息获取成功", name),
                    studentByAccountName);
        }
        TeacherVo teacherByAccountName = accountService.findTeacherByAccountName(name);
        if (teacherByAccountName != null) {
            return RespondsMessage.success(LogUtil.logInfo(log, "老师{}的信息获取成功", name),
                   teacherByAccountName);
        }
        return RespondsMessage.failure("未找到用户信息");
    }

}
