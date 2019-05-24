package org.nix.lovedomain.service;

import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.ResourcesBusinessMapper;
import org.nix.lovedomain.dao.model.ResourcesModel;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.utils.SQLUtil;
import org.nix.lovedomain.web.controller.dto.ResourcesDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 资源服务
 * @date 2019/3/6
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class ResourcesService {

    @Resource
    private ResourcesBusinessMapper resoucesBusinessMapper;

    /**
     * 批量插入资源
     *
     * @param resourcesDos
     */
    public void batchAddResource(List<ResourcesDto> resourcesDos) {

    }



    /**
     * 分页查询资源信息
     * @param key 关键字
     * @param page 页码
     * @param limit 数量
     * @return
     */
    public PageVo findResourcesPage(String key,
                                    Integer page,
                                    Integer limit) {
        List<ResourcesModel> resources
                = resoucesBusinessMapper.findResourcesPage(key, SQLUtil.getOffset(page, limit), limit);
        Integer integer = resoucesBusinessMapper.countResources(key, SQLUtil.getOffset(page, limit), limit);

        return PageVo.<ResourcesModel>builder()
                .data(resources)
                .total(new Long(integer))
                .page(page)
                .limit(limit)
                .build();
    }


    /**
     * 查询一个用户的所有权限信息
     *
     * @param account 账户名字（手机、邮箱、账户）
     * @return 权限集合
     */
    public List<ResourcesModel> findResourcesByAccount(String account) {
        return null;
    }

    /**
     * 返回不需要登陆就可以访问的页面
     *
     * @return
     */
    public List<ResourcesModel> findPermissionAllResources() {
        return null;
    }
}
