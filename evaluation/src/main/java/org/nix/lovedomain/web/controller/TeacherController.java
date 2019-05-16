package org.nix.lovedomain.web.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.mapper.AccountMapper;
import org.nix.lovedomain.dao.mapper.TeacherMapper;
import org.nix.lovedomain.model.Account;
import org.nix.lovedomain.model.Teacher;
import org.nix.lovedomain.service.TeacherService;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.web.controller.base.BaseController;
import org.nix.lovedomain.web.controller.dto.CreateTeacherDto;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author zhangpei
 * @version 1.0
 * @description 老师管理控制器
 * @date 2019/5/2
 */
@Slf4j
@Api(value = "老师控制器(测试通过)")
@RestController
@Transactional(rollbackFor = Exception.class)
@RequestMapping(value = "/teacher")
public class TeacherController extends BaseController<Teacher> {

    @Autowired
    private TeacherService teacherService;

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private TeacherMapper teacherMapper;

    @GetMapping(value = "/quire/list")
    public RespondsMessage findTeacherPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                           @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                           @RequestParam(value = "quire", required = false) String sql) throws IOException {
        PageVo<Teacher> studentVoPageVo = teacherService.findTeacherList(page, limit, sql);
        return RespondsMessage.success("获取老师列表成功",studentVoPageVo);
    }

    @PostMapping(value = "/create")
    public RespondsMessage createTeacher(@ModelAttribute CreateTeacherDto dto){

        String email = dto.getEmail();
        String jobNumber = dto.getJobNumber();
        String name = dto.getName();
        String phone = dto.getPhone();

        Account account = new Account();
        account.setPassword(jobNumber);
        account.setEmail(email);
        account.setPhone(phone);
        account.setNumbering(jobNumber);
        accountMapper.insertSelective(account);

        log.info("创建的账号id为{}:",account.getId());

        Teacher teacher = new Teacher();
        teacher.setAccountid(account.getId());

        teacher.setEmail(email);
        teacher.setPhone(phone);
        teacher.setName(name);
        teacher.setJobnumber(jobNumber);

        teacherMapper.insertSelective(teacher);

        return  RespondsMessage.success("创建老师成功");
    }

}
