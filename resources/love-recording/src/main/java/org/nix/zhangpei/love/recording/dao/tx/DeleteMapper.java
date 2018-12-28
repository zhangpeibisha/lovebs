package org.nix.zhangpei.love.recording.dao.tx;

import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.base.delete.DeleteByPrimaryKeyMapper;
import tk.mybatis.mapper.common.condition.DeleteByConditionMapper;
import tk.mybatis.mapper.common.ids.DeleteByIdsMapper;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/28
 */
public interface DeleteMapper<T> extends Marker,
        tk.mybatis.mapper.common.base.delete.DeleteMapper<T>,
        DeleteByPrimaryKeyMapper<T>,
        DeleteByConditionMapper<T>,
        DeleteByIdsMapper<T> {
}
