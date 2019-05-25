package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.dao.base.BaseBusinessMapper;
import org.nix.lovedomain.dao.model.RoleRecourseModel;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 角色资源业务表
 * @date 2019/4/19
 */
public interface RoleResourceBusinessMapper extends BaseBusinessMapper<RoleRecourseModel> {

    /**
     * 为一个角色批量添加资源信息
     * @param roleId 角色id
     * @param resourceIds 资源id集合
     */
    void insertResourceToRole(@Param(value = "roleId") Integer roleId,
                              @Param(value = "resourceIds") List<Integer> resourceIds);

}
