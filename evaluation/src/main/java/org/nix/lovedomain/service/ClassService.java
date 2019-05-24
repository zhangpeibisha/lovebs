package org.nix.lovedomain.service;

import org.nix.lovedomain.dao.business.ClassBusinessMapper;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.utils.SQLUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version 1.0
 * @anthor  on 2019/4/19
 * @since jdk8
 */
@Service
public class ClassService  {

    @Resource
    private ClassBusinessMapper classBusinessMapper;


    public PageVo<Class> findClassPage(Integer page,
                                       Integer limit,
                                       String sql) {
        if (page == null) {
            page = 1;
        }
        int tempPage = page;
        page = SQLUtil.getOffset(page, limit);
        List<Class> studentBySql
                = classBusinessMapper.findClassBySql(page, limit, sql);
        Long aLong = classBusinessMapper.countClassBySql(sql);
        return PageVo.<Class>builder()
                .page(tempPage)
                .limit(limit)
                .total(aLong)
                .data(studentBySql)
                .build();

    }



}
