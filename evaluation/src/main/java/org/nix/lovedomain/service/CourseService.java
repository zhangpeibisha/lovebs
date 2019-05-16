package org.nix.lovedomain.service;

import org.nix.lovedomain.dao.business.CoueseBusinessMapper;
import org.nix.lovedomain.dao.mapper.CourseMapper;
import org.nix.lovedomain.model.Course;
import org.nix.lovedomain.model.Teacher;
import org.nix.lovedomain.service.base.BaseService;
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
public class CourseService extends BaseService {

    @Resource
    CourseMapper courseMapper;

    public int testList(){
        return  courseMapper.testList();
    }


    @Resource
    private CoueseBusinessMapper coueseBusinessMapper;

    /**
     * 获取老师列表
     *
     * @param page
     * @param limit
     * @param sql
     * @return
     */
    public PageVo<Course> findCourseList(Integer page,
                                         Integer limit,
                                         String sql) {
        if (page == null) {
            page = 1;
        }
        int tempPage = page;
        page = SQLUtil.getOffset(page, limit);
        List<Course> professionPageBySql
                = coueseBusinessMapper.findCourseBySql(page, limit, sql);
        Long aLong = coueseBusinessMapper.countCourseBySql(sql);

        return PageVo.<Course>builder()
                .page(tempPage)
                .limit(limit)
                .total(aLong)
                .data(professionPageBySql)
                .build();

    }

}
