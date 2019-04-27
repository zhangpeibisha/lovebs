package org.nix.lovedomain.service

import cn.hutool.core.collection.CollUtil
import org.junit.runner.RunWith
import org.nix.lovedomain.EvaluationApplication
import org.nix.lovedomain.dao.business.ResoucesBusinessMapper
import org.nix.lovedomain.dao.business.RoleResourceBusinessMapper
import org.nix.lovedomain.model.Resources
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification

import javax.annotation.Resource

@WebAppConfiguration
@ContextConfiguration(classes = [EvaluationApplication.class],loader = SpringBootContextLoader.class)
 class ResourcesServiceTest extends Specification {

    @Resource
    private ResoucesBusinessMapper resoucesBusinessMapper;

    def "BatchAddResource"() {
        def object = new Resources();
        object.setUrl("/resources/**")
        object.setName("资源管理者")
        object.setPermissionall(new Byte(String.valueOf(0)))
        def list = CollUtil.newArrayList(object)
        when:
        resoucesBusinessMapper.batchInsertResources(list)
        then:
        1 == 1
    }
}
