package org.nix.lovedomain.service;

import org.nix.lovedomain.dao.mapper.CourseMapper;
import org.nix.lovedomain.service.base.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
