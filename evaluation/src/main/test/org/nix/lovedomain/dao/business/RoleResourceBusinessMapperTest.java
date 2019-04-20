package org.nix.lovedomain.dao.business;

import cn.hutool.core.collection.CollUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.lovedomain.EvaluationApplication;
import org.nix.lovedomain.dao.mapper.RoleResourceMapper;
import org.nix.lovedomain.model.RoleResourceExample;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = EvaluationApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RoleResourceBusinessMapperTest {

    @Resource
    private RoleResourceMapper roleResourceMapper;

    @Resource
    private RoleResourceBusinessMapper roleResourceBusinessMapper;

    @Test
    public void insertResourceToRole() {
        roleResourceBusinessMapper.insertResourceToRole(1,CollUtil.newArrayList(1,2,3,4,5,6));
        RoleResourceExample example = new RoleResourceExample();
        example.createCriteria().andRoleidEqualTo(1);
        roleResourceMapper.deleteByExample(example);
    }
}