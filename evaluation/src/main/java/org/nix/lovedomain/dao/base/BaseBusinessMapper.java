package org.nix.lovedomain.dao.base;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/5/1
 */
public interface BaseBusinessMapper<E> extends Mapper<E>, MySqlMapper<E>,IdsMapper<E> {

}
