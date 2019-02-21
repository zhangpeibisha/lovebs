package org.nix.lovedomain.rbac.util;

import org.nix.lovedomain.rbac.util.auth.core.extractor.AbstractResourcesExtractor;
import org.nix.lovedomain.rbac.util.auth.core.extractor.PermissionResource;
import org.nix.lovedomain.rbac.util.auth.core.extractor.Resources;
import org.nix.lovedomain.rbac.util.auth.core.extractor.RequestMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 基于spring mvc的资源提取
 * @date 2019/2/17
 */
@Component
public class SpringMvcExtractor extends AbstractResourcesExtractor {

    @Override
    protected boolean filterMethod(Method method) {
        return getAnnotation(method) != null;
    }

    @Override
    protected Annotation getAnnotation(Method method) {
        Annotation[] annotations = method.getAnnotations();
        return getAnnotation(annotations);
    }

    @Override
    protected Annotation getAnnotation(Class classzz) {
        return getAnnotation(classzz.getAnnotations());
    }

    /**
     * @param annotations 得到需要的注解
     * @return java.lang.annotation.Annotation
     * @description 得到需要的注解
     * @author zhangpe0312@qq.com
     * @date 2019/2/17
     */
    private Annotation getAnnotation(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            if (annotation instanceof GetMapping
                    || annotation instanceof PostMapping
                    || annotation instanceof DeleteMapping
                    || annotation instanceof PutMapping
                    || annotation instanceof PatchMapping
                    || annotation instanceof RequestMapping) {
                return annotation;
            }
        }
        return null;
    }

    @Override
    protected List<RequestMethod> getRequestMethods(Annotation annotation) {
        if (!(annotation instanceof RequestMapping)) {
            Class<? extends Annotation> aClass = annotation.annotationType();
            RequestMapping requestMapping = aClass.getAnnotation(RequestMapping.class);
            if (requestMapping != null) {
                return springMvcToExtractors(Arrays.asList(requestMapping.method()));
            }
        } else {
            return springMvcToExtractors(Arrays.asList(((RequestMapping) annotation).method()));
        }
        return null;
    }

    private List<RequestMethod> springMvcToExtractors(List<org.springframework.web.bind.annotation.RequestMethod> requestMethods) {
        List<RequestMethod> result = new ArrayList<>();
        requestMethods.forEach(requestMethod -> result.add(springMvcToExtractor(requestMethod)));
        return result;
    }

    private RequestMethod springMvcToExtractor(org.springframework.web.bind.annotation.RequestMethod requestMethod) {
        switch (requestMethod) {
            case GET:
                return RequestMethod.GET;
            case PATCH:
                return RequestMethod.PATCH;
            case POST:
                return RequestMethod.POST;
            case PUT:
                return RequestMethod.PUT;
            case DELETE:
                return RequestMethod.DELETE;
            default:
                return null;
        }
    }

    @Override
    protected String[] getRequestUrl(Annotation annotation) {
        if (annotation instanceof GetMapping) {
            String[] value = ((GetMapping) annotation).value();
            return value.length == 0 ? ((GetMapping) annotation).path() : value;
        }
        if (annotation instanceof PostMapping) {
            String[] value = ((PostMapping) annotation).value();
            return value.length == 0 ? ((PostMapping) annotation).path() : value;
        }
        if (annotation instanceof PutMapping) {
            String[] value = ((PutMapping) annotation).value();
            return value.length == 0 ? ((PutMapping) annotation).path() : value;
        }
        if (annotation instanceof PatchMapping) {
            String[] value = ((PatchMapping) annotation).value();
            return value.length == 0 ? ((PatchMapping) annotation).path() : value;
        }
        if (annotation instanceof DeleteMapping) {
            String[] value = ((DeleteMapping) annotation).value();
            return value.length == 0 ? ((DeleteMapping) annotation).path() : value;
        }
        if (annotation instanceof RequestMapping) {
            String[] value = ((RequestMapping) annotation).value();
            return value.length == 0 ? ((RequestMapping) annotation).path() : value;
        }
        return null;
    }

    @Override
    protected void setInfo(Resources resources, Method method, Annotation methodAnnotation) {
        String name = method.getName();
        PermissionResource annotation = method.getAnnotation(PermissionResource.class);
        // 如果有默认的资源信息，则使用默认的资源信息
        if (annotation != null) {
            String description = annotation.description();
            String authName = annotation.name();
            boolean open = annotation.open();
            resources.setDescription(description);
            resources.setName(authName);
            resources.setOpen(open);
        } else {
            resources.setName(name);
            resources.setDescription(name);
            resources.setOpen(false);
        }
    }
}
