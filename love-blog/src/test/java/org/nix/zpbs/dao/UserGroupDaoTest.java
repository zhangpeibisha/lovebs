package org.nix.zpbs.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.zpbs.LoveBlogApplication;
import org.nix.zpbs.mapper.GroupResourceMapper;
import org.nix.zpbs.mapper.UserGroupMapper;
import org.nix.zpbs.model.GroupResource;
import org.nix.zpbs.model.GroupResourceExample;
import org.nix.zpbs.model.UserGroup;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest(classes = LoveBlogApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserGroupDaoTest {

    @Resource
    private UserGroupMapper userGroupMapper;

    @Resource
    private UserGroupDao userGroupDao;

    @Test
    public void getResourcesByUserGroupIdTest(){
        // 通过用户组id查询到用户组信息
        UserGroup userGroup = userGroupMapper.selectByPrimaryKey(1L);
        assertEquals("USER",userGroup.getGroupName());
        List<String> resourcesNameByUserGroupId = userGroupDao.getResourcesNameByUserGroupId(userGroup.getId());
        assertEquals(1,resourcesNameByUserGroupId.size());
        assertEquals("测试资源",resourcesNameByUserGroupId.get(0));
    }

}