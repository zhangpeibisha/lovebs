package org.nix.lovedomain.service;

import org.nix.lovedomain.dao.business.ProfessionBusinessMapper;
import org.nix.lovedomain.model.Profession;
import org.nix.lovedomain.service.base.BaseService;
import org.nix.lovedomain.service.vo.PageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version 1.0
 * @anthor on 2019/4/19
 * @since jdk8
 */
@Service
public class ProfessionService extends BaseService<Profession> {


    @Resource
    private ProfessionBusinessMapper professionBusinessMapper;

    public PageVo<Profession> findProfession(Integer page,
                                             Integer limit,
                                             String sql) {
        List<Profession> professionPageBySql
                = professionBusinessMapper.findProfessionPageBySql(page, limit, sql);
        Long aLong = professionBusinessMapper.countProfessionPageBySql(sql);

        return PageVo.<Profession>builder()
                .page(page)
                .limit(limit)
                .total(aLong)
                .data(professionPageBySql)
                .build();
    }

}
