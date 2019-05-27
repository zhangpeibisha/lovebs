package org.nix.lovedomain.web.controller;

import io.swagger.annotations.Api;
import org.nix.lovedomain.dao.business.ProfessionBusinessMapper;
import org.nix.lovedomain.dao.model.ProfessionModel;
import org.nix.lovedomain.service.ProfessionService;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 */
@Api(value = "专业相关控制器(测试通过)")
@RestController
@RequestMapping(value = "profession")
public class ProfessionController {

    @Autowired
    private ProfessionService professionService;

    @Resource
    private ProfessionBusinessMapper professionBusinessMapper;

    /**
     * 获取专业信息的接口
     * @param page
     * @param limit
     * @param sql
     * @return
     */
    @GetMapping(value = "/quire/list")
    public RespondsMessage findProfession(@RequestParam(value = "page", required = false) Integer page,
                                          @RequestParam(value = "limit", required = false) Integer limit,
                                          @RequestParam(value = "quire", required = false) String sql){
        PageVo<ProfessionModel> profession = professionService.findProfession(page, limit, sql);
        return RespondsMessage.success("获取专业信息成功",profession);
    }

    @GetMapping(value = "/findById")
    public RespondsMessage findById(@RequestParam(value = "id")Integer id){
        return RespondsMessage.success("通过id查询完成",professionBusinessMapper.selectByPrimaryKey(id));
    }
}
