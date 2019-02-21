package org.nix.lovedomain.rbac.util.auth.core.extractor;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 资源信息提取器，通过class信息获取到资源信息
 * @date 2019/2/14
 */
public interface ResourcesExtractor {

    /**
     * @param classzz 提取资源的class
     * @return java.util.List<org.nix.love.common.core.model.Resources>
     * @description 获取一个接口中的所有资源信息
     * @see Resources
     * @author zhangpe0312@qq.com
     * @date 2019/2/15
     */
    List<Resources> extractorResources(Class classzz);

}
