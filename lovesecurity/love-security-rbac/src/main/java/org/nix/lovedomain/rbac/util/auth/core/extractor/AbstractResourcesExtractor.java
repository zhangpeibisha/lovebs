package org.nix.lovedomain.rbac.util.auth.core.extractor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 抽象的资源提取类
 * @date 2019/2/17
 */
public abstract class AbstractResourcesExtractor implements ResourcesExtractor {

    @Override
    public List<Resources> extractorResources(Class classzz) {
        // 返回的结果集合
        List<Resources> resources = new ArrayList<>();
        Annotation classAnnotation = getAnnotation(classzz);
        // 获取到合法的方法
        List<Method> methods = filterMethod(classzz.getMethods());
        // 如果类没有这个注解直接处理方法上的注解即可
        if (classAnnotation == null) {
            for (Method method : methods) {
                Annotation methodAnnotation = getAnnotation(method);
                if (methodAnnotation != null) {
                    List<RequestMethod> methodRequestMethod = getRequestMethods(methodAnnotation);
                    String[] methodPath = getRequestUrl(methodAnnotation);
                    for (String path : methodPath) {
                        Resources resourcesResult = new Resources();
                        // 获取到方法
                        setRequestMethod(resourcesResult, methodRequestMethod, new ArrayList<>());
                        // 设置请求路径
                        resourcesResult.setUrl(path);
                        // 设置其他信息
                        setInfo(resourcesResult, method, methodAnnotation);
                        resources.add(resourcesResult);
                    }
                }
            }
            return resources;
        }
        // 获取类上面的请求方法，如果有则记录，没有则不记录
        List<RequestMethod> requestMethods = getRequestMethods(classAnnotation);
        // 该方法的前缀
        String[] classPath = getRequestUrl(classAnnotation);
        for (Method method : methods) {
            Annotation methodAnnotation = getAnnotation(method);
            if (methodAnnotation != null) {
                List<RequestMethod> methodRequestMethod = getRequestMethods(methodAnnotation);
                String[] methodPath = getRequestUrl(methodAnnotation);
                for (String aClassPath : classPath) {
                    for (String path : methodPath) {
                        Resources resourcesResult = new Resources();
                        // 获取到方法
                        setRequestMethod(resourcesResult, methodRequestMethod, requestMethods);
                        // 设置请求路径
                        resourcesResult.setUrl(aClassPath + path);
                        // 设置其他信息
                        setInfo(resourcesResult, method, methodAnnotation);
                        resources.add(resourcesResult);
                    }
                }
            }
        }
        return resources;
    }

    /**
     * @param resources           资源实体
     * @param methodRequestMethod 在请求上的请求方法
     * @param requestMethods      在类上的请求方法
     * @return void
     * @description 设置资源实体的请求方法
     * @author zhangpe0312@qq.com
     * @date 2019/2/17
     */
    protected void setRequestMethod(Resources resources, List<RequestMethod> methodRequestMethod, List<RequestMethod> requestMethods) {
        List<RequestMethod> tempResultMethod = new ArrayList<>(requestMethods);
        if (methodRequestMethod == null || methodRequestMethod.size() == 0) {
            tempResultMethod.add(RequestMethod.GET);
            tempResultMethod.add(RequestMethod.POST);
            tempResultMethod.add(RequestMethod.PUT);
            tempResultMethod.add(RequestMethod.DELETE);
        } else {
            tempResultMethod.addAll(methodRequestMethod);
        }
        resources.setHttpMethods(new HashSet<>(tempResultMethod));
    }

    /**
     * @param methods 需要过滤的方法
     * @return java.util.List<java.lang.reflect.Method>
     * @description 过滤需要的方法出来，做资源提取
     * @author zhangpe0312@qq.com
     * @date 2019/2/17
     */
    protected List<Method> filterMethod(Method[] methods) {
        List<Method> result = new ArrayList<>();
        for (Method method : methods) {
            if (filterMethod(method)) {
                result.add(method);
            }
        }
        return result;
    }

    /**
     * @param method 方法
     * @return boolean
     * @description 是否需要这个方法的信息
     * @author zhangpe0312@qq.com
     * @date 2019/2/17
     */
    protected abstract boolean filterMethod(Method method);

    /**
     * @param method 方法
     * @return java.lang.annotation.Annotation
     * @description 获取方法上的注解信息
     * @author zhangpe0312@qq.com
     * @date 2019/2/17
     */
    protected abstract Annotation getAnnotation(Method method);

    /**
     * @param classzz 类
     * @return java.lang.annotation.Annotation
     * @description 获取类上面的注解信息
     * @author zhangpe0312@qq.com
     * @date 2019/2/17
     */
    protected abstract Annotation getAnnotation(Class classzz);

    /**
     * @param annotation 注解中包含了请求方法信息
     * @return java.util.List<org.nix.love.common.core.RequestMethod>
     * @description 通过注解获取请求方法信息
     * @author zhangpe0312@qq.com
     * @date 2019/2/17
     */
    protected abstract List<RequestMethod> getRequestMethods(Annotation annotation);

    /**
     * @param annotation 注解信息
     * @return java.lang.String[]
     * @description 通过注解信息获取到请求的URL
     * @author zhangpe0312@qq.com
     * @date 2019/2/17
     */
    protected abstract String[] getRequestUrl(Annotation annotation);

    /**
     * @param resources        资源实体
     * @param method           方法具体信息
     * @param methodAnnotation 方法上的注解信息
     * @return void
     * @description 子类补充资源实体的信息
     * @author zhangpe0312@qq.com
     * @date 2019/2/17
     */
    protected abstract void setInfo(Resources resources, Method method, Annotation methodAnnotation);
}
