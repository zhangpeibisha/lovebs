package org.nix.lovedomain.service;

import org.nix.lovedomain.dao.business.FacultyBusinessMapper;
import org.nix.lovedomain.dao.model.FacultyModel;
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
public class FacultyService {

    @Resource
    private FacultyBusinessMapper facultyBusinessMapper;


    public PageVo<FacultyModel> findFacultyPage(Integer page,
                                                Integer limit,
                                                String sql) {
        if (page == null) {
            page = 1;
        }
        int tempPage = page;
        page = SQLUtil.getOffset(page, limit);
        List<FacultyModel> studentBySql
                = facultyBusinessMapper.findFacultyBySql(page, limit, sql);
        Long aLong = facultyBusinessMapper.countFacultyBySql(sql);
        return PageVo.<FacultyModel>builder()
                .page(tempPage)
                .limit(limit)
                .total(aLong)
                .data(studentBySql)
                .build();

    }

}
