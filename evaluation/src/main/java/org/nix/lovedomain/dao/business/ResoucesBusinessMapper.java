package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.model.Resources;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 资源业务映射
 * @date 2019/4/24
 */
public interface ResoucesBusinessMapper {

    /**
     * 通过关键字查询资源并分页
     * @param key 关键字
     * @param offset 偏移量
     * @param limit 数量
     * @return
     */
    List<Resources> findResourcesPage(@Param(value = "key") String key,
                                      @Param(value = "offset") Integer offset,
                                      @Param(value = "limit") Integer limit);

    Integer countResources(@Param(value = "key") String key,
                           @Param(value = "offset") Integer offset,
                           @Param(value = "limit") Integer limit);

    /**
     * 批量插入资源
     * @param resources
     * @return
     */
    Integer batchInsertResources(@Param(value = "resources")List<Resources> resources);
}
