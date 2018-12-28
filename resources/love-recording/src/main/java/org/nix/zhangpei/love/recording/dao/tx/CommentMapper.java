package org.nix.zhangpei.love.recording.dao.tx;

import org.springframework.stereotype.Component;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用mapper
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/28
 */
public interface CommentMapper<T> extends   InsertMapper<T>,
        DeleteMapper<T>,
        UpdateMapper<T>,
        SelectMapper<T> {

}
