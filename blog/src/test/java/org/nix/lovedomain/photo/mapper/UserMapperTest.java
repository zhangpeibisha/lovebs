package org.nix.lovedomain.photo.mapper;

import org.junit.runner.RunWith;
import org.nix.lovedomain.BlogApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = BlogApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

//    @Test
//    public void insertSelective() {
//        User record = new User();
//        record.setNickname("张沛");
//        record.setPassword("zhangpei");
//        record.setUsername("zhangpei");
//        int i = userMapper.insertSelective(record);
//        assert 1 == i;
//    }
}