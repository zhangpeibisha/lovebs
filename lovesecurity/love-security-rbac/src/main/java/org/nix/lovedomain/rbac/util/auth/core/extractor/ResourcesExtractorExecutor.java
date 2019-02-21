package org.nix.lovedomain.rbac.util.auth.core.extractor;


import org.nix.lovedomain.rbac.util.auth.utils.scan.ClassScannerUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

/**
 * @author zhangpei
 * @version 1.0
 * @description 资源提取执行者
 * @date 2019/2/15
 */
public class ResourcesExtractorExecutor {

    /**
     * 资源提取器
     */
    private ResourcesExtractor resourcesExtractor;
    /**
     * 需要处理的class
     */
    private Set<Class<?>> classes;
    /**
     * 结果
     */
    private volatile Set<Resources> results;

    public ResourcesExtractorExecutor(ResourcesExtractor resourcesExtractor, Set<Class<?>> classes) {
        this.resourcesExtractor = resourcesExtractor;
        this.classes = classes;
    }

    public ResourcesExtractorExecutor(ResourcesExtractor resourcesExtractor, String packageName, Predicate<Class<?>> predicate) {
        this.resourcesExtractor = resourcesExtractor;
        this.classes = ClassScannerUtils.searchClasses(packageName,predicate);
    }

    public ResourcesExtractorExecutor(ResourcesExtractor resourcesExtractor, String packageName) {
        this.resourcesExtractor = resourcesExtractor;
        this.classes = ClassScannerUtils.searchClasses(packageName);
    }

    /**
     * @return 提取资源信息并返回
     */
    private void extractor(){
       synchronized (this){
           if (results == null){
               Set<Resources> resources = new HashSet<>();
               classes.forEach(aClass -> resources.addAll(resourcesExtractor.extractorResources(aClass)));
               results = resources;
           }
       }
    }

    public Set<Resources> getResults(){
        if (results == null){
            extractor();
        }
        return results;
    }

}
