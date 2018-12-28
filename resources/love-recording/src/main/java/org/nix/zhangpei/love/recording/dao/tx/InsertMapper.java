package org.nix.zhangpei.love.recording.dao.tx;

import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.base.insert.InsertSelectiveMapper;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/28
 */
public interface InsertMapper<T>  extends Marker,
        tk.mybatis.mapper.common.base.insert.InsertMapper<T>,
        InsertSelectiveMapper<T>,
        MySqlMapper<T> {
}
