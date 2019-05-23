package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.dao.base.BaseBusinessMapper;
import org.nix.lovedomain.dao.model.ProfessionModel;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 专业业务类
 * @date 2019/5/1
 */
public interface ProfessionBusinessMapper extends BaseBusinessMapper<ProfessionModel> {


    List<org.nix.lovedomain.model.Profession>
    findProfessionPageBySql(@Param(value = "page") Integer page,
                            @Param(value = "limit") Integer limit,
                            @Param(value = "sql") String sql);

    Long countProfessionPageBySql(@Param(value = "sql") String sql);
}
