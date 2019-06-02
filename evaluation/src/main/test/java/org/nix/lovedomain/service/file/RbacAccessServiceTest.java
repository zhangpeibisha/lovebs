package org.nix.lovedomain.service.file;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.lovedomain.EvaluationApplication;
import org.nix.lovedomain.dao.business.ResourcesBusinessMapper;
import org.nix.lovedomain.dao.business.RoleBusinessMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EvaluationApplication.class)
public class RbacAccessServiceTest {

    @Resource
    private RbacAccessService rbacAccessService;

    @Resource
    private ResourcesBusinessMapper resourcesBusinessMapper;

    @Resource
    private RoleBusinessMapper roleBusinessMapper;

    @Test
    @Transactional
    public void list() {
        rbacAccessService.list();
        System.err.println(JSON.toJSONString(resourcesBusinessMapper.selectAll()));
        System.err.println(JSON.toJSONString(roleBusinessMapper.selectAll()));
        System.out.println();
    }
}