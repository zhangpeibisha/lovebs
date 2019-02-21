package org.nix.lovedomain.rbac.util.auth;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.rbac.util.auth.core.extractor.DefaultResourcesExtractor;
import org.nix.lovedomain.rbac.util.auth.core.extractor.ResourcesExtractor;
import org.nix.lovedomain.rbac.util.auth.core.extractor.ResourcesExtractorExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author zhangpei
 * @version 1.0
 * @description 自动装配权限
 * @date 2019/2/21
 */
@Configuration
@Slf4j
public class AutomaticPermissionConfig {

    @Autowired
    private PermissionProperties permissionProperties;

    @Resource
    private ResourcesExtractor resourcesExtractor;

    @Bean
    public ResourcesExtractorExecutor resourcesExtractorExecutor(){
        String path = permissionProperties.getResources().path;
        ResourcesExtractorExecutor resourcesExtractorExecutor =
                new ResourcesExtractorExecutor(resourcesExtractor, path);
        log.info("资源扫描路径为:{}",path);
        log.info("获取到的资源有：{}",JSONUtil.toJsonStr(resourcesExtractorExecutor.getResults()));
        return resourcesExtractorExecutor;
    }

    @Bean
    @ConditionalOnMissingBean(value = ResourcesExtractor.class)
    public ResourcesExtractor defaultResourcesExtractor(){
        return new DefaultResourcesExtractor();
    }
}
