package org.nix.lovedomain.service;

import org.nix.lovedomain.dao.business.FacultyBusinessMapper;
import org.nix.lovedomain.model.Faculty;
import org.nix.lovedomain.service.base.BaseService;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.service.vo.StudentVo;
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
public class FacultyService extends BaseService {

    @Resource
    private FacultyBusinessMapper facultyBusinessMapper;



    public PageVo<Faculty> findFacultyPage(Integer page,
                                           Integer limit,
                                           String sql) {
        if (page == null) {
            page = 1;
        }
        int tempPage = page;
        page = SQLUtil.getOffset(page, limit);
        List<Faculty> studentBySql
                = facultyBusinessMapper.findFacultyBySql(page, limit, sql);
        Long aLong = facultyBusinessMapper.countFacultyBySql(sql);
        return PageVo.<Faculty>builder()
                .page(tempPage)
                .limit(limit)
                .total(aLong)
                .data(studentBySql)
                .build();

    }

}
