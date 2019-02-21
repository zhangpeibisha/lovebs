package org.nix.lovedomain.rbac.util.auth.core.extractor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 默认资源提取器,当没有配置该类都时候会生效
 * @date 2019/2/17
 */
public class DefaultResourcesExtractor extends AbstractResourcesExtractor {

    @Override
    protected boolean filterMethod(Method method) {
        PermissionResource annotation = method.getAnnotation(PermissionResource.class);
        return annotation != null;
    }

    @Override
    protected Annotation getAnnotation(Method method) {
        return method.getAnnotation(PermissionResource.class);
    }

    @Override
    protected Annotation getAnnotation(Class classzz) {
        return classzz.getAnnotation(PermissionResource.class);
    }

    @Override
    protected List<RequestMethod> getRequestMethods(Annotation annotation) {
        if (annotation instanceof PermissionResource) {
            return Arrays.asList(((PermissionResource) annotation).method());
        }
        return null;
    }

    @Override
    protected String[] getRequestUrl(Annotation annotation) {
        if (annotation instanceof PermissionResource) {
            return ((PermissionResource) annotation).path();
        }
        return null;
    }

    @Override
    protected void setInfo(Resources resources, Method method, Annotation methodAnnotation) {
        if (methodAnnotation instanceof PermissionResource) {
            String name = ((PermissionResource) methodAnnotation).name();
            if ("".equals(name)) {
                name = method.getName();
                resources.setName(name);
            } else {
                resources.setName(name);
            }
            String description = ((PermissionResource) methodAnnotation).description();
            if ("".equals(description)) {
                resources.setDescription(name);
            } else {
                resources.setDescription(description);
            }
            resources.setOpen(((PermissionResource) methodAnnotation).open());
        }
    }


}
