package org.nix.lovedomain.service;

import org.nix.lovedomain.dao.business.ProfessionBusinessMapper;
import org.nix.lovedomain.dao.model.ProfessionModel;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.utils.SQLUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 */
@Service
public class ProfessionService {


    @Resource
    private ProfessionBusinessMapper professionBusinessMapper;

    public PageVo<ProfessionModel> findProfession(Integer page,
                                                  Integer limit,
                                                  String sql) {
        if (page == null) {
            page = 1;
        }
        int tempPage = page;
        page = SQLUtil.getOffset(page, limit);
        List<ProfessionModel> professionPageBySql
                = professionBusinessMapper.findProfessionPageBySql(page, limit, sql);
        Long aLong = professionBusinessMapper.countProfessionPageBySql(sql);

        return PageVo.<ProfessionModel>builder()
                .page(tempPage)
                .limit(limit)
                .total(aLong)
                .data(professionPageBySql)
                .build();
    }

}
