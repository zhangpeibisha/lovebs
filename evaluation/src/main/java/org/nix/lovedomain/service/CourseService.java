package org.nix.lovedomain.service;

import cn.hutool.core.util.PageUtil;
import org.nix.lovedomain.dao.business.CourseBusinessMapper;
import org.nix.lovedomain.dao.model.CourseModel;
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
public class CourseService {

    @Resource
    private CourseBusinessMapper courseBusinessMapper;

    /**
     * 获取老师列表
     *
     * @param page  页码
     * @param limit 数量
     * @param sql   sql查询
     * @return
     */
    public PageVo<CourseModel> findCourseList(Integer page,
                                              Integer limit,
                                              String sql) {
        int tempPage = PageUtil.getStart(page, limit);
        page = SQLUtil.getOffset(page, limit);
        List<CourseModel> professionPageBySql
                = courseBusinessMapper.findCourseBySql(page, limit, sql);
        Long aLong = courseBusinessMapper.countCourseBySql(sql);

        return PageVo.<CourseModel>builder()
                .page(tempPage)
                .limit(limit)
                .total(aLong)
                .data(professionPageBySql)
                .build();

    }

}
