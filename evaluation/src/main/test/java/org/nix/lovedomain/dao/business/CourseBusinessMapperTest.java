package org.nix.lovedomain.dao.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.lovedomain.EvaluationApplication;
import org.nix.lovedomain.dao.model.CourseModel;
import org.nix.lovedomain.dao.model.ResourcesModel;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EvaluationApplication.class)
public class CourseBusinessMapperTest {

    @Resource
    private CourseBusinessMapper courseBusinessMapper;

    @Resource
    private ResourcesBusinessMapper resourcesBusinessMapper;

    @Test
    public void test(){

        List<ResourcesModel> resourcesByLoginName
                = resourcesBusinessMapper.findResourcesByLoginName("858536994");
        System.out.println(resourcesByLoginName);
        List<CourseModel> courseModels = courseBusinessMapper.selectAll();
        System.out.println(courseModels);
        Long aLong = courseBusinessMapper.countCourseBySql(null);
        System.out.println(aLong);
        List<CourseModel> courseBySql = courseBusinessMapper.findCourseBySql(0, 10, null);
        System.out.println(courseBySql);
    }

}