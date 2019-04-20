package org.nix.lovedomain.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.nix.lovedomain.dao.mapper.base.BaseMapper;
import org.nix.lovedomain.model.Profession;
import org.nix.lovedomain.model.ProfessionExample;

import java.util.List;

@Mapper
public interface ProfessionMapper extends BaseMapper<Profession> {
    List<Profession> selectByExample(ProfessionExample example);
}