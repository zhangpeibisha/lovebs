package org.nix.lovedomain.web.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.ProfessionBusinessMapper;
import org.nix.lovedomain.dao.model.ProfessionModel;
import org.nix.lovedomain.service.ProfessionService;
import org.nix.lovedomain.service.enums.Permission;
import org.nix.lovedomain.service.enums.RoleEnum;
import org.nix.lovedomain.service.file.OrganizationService;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 */
@Slf4j
@Api(value = "专业相关控制器(测试通过)")
@RestController
@RequestMapping(value = "profession")
public class ProfessionController {

    @Autowired
    private ProfessionService professionService;

    @Resource
    private ProfessionBusinessMapper professionBusinessMapper;

    @Resource
    private OrganizationService organizationService;

    /**
     * 获取专业信息的接口
     *
     * @param page
     * @param limit
     * @param sql
     * @return
     */
    @GetMapping(value = "/quire/list")
    public RespondsMessage findProfession(@RequestParam(value = "page", required = false) Integer page,
                                          @RequestParam(value = "limit", required = false) Integer limit,
                                          @RequestParam(value = "quire", required = false) String sql) {
        PageVo<ProfessionModel> profession = professionService.findProfession(page, limit, sql);
        return RespondsMessage.success("获取专业信息成功", profession);
    }

    @GetMapping(value = "/findById")
    public RespondsMessage findById(@RequestParam(value = "id") Integer id) {
        return RespondsMessage.success("通过id查询完成", professionBusinessMapper.selectByPrimaryKey(id));
    }


    /**
     * 上传专业信息，管理员使用
     *
     * @param faculty
     */
    @Permission(name = "excel上传专业信息",
            description = "管理员通过上传格式化的excel文件，可以达到批量上传专业信息目的",
            role = RoleEnum.MANGER)
    @PostMapping(value = "/excel")
    public void uploadProfession(MultipartFile faculty) throws IOException {
        organizationService.insertProfession(faculty.getInputStream());
    }


    @PutMapping(value = "/update")
    public RespondsMessage update(@ModelAttribute ProfessionModel professionModel) {
        professionBusinessMapper.updateByPrimaryKeySelective(professionModel);
        return RespondsMessage.success("更新专业信息完成");
    }


    @PostMapping(value = "/add")
    public RespondsMessage add(@ModelAttribute ProfessionModel professionModel){
        professionBusinessMapper.insertSelective(professionModel);
        return RespondsMessage.success("添加专业信息完成");
    }

}
