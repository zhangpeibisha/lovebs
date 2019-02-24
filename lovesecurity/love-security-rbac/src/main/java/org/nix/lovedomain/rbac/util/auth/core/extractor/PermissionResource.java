package org.nix.lovedomain.rbac.util.auth.core.extractor;

import java.lang.annotation.*;

/**
 * @author zhangpei
 * @version 1.0
 * @description 权限资源注解，只是在注册资源信息的时候有用
 * @date 2019/2/17
 */
@Documented
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionResource {

    /**
     * @return http 请求方法，默认 post，get,delete,put（在方法级别上确定）
     */
    RequestMethod[] method() default {};

    /**
     * @return 请求路径
     */
    String[] path() default {};

    /**
     * @return 资源注册时定义是否启用
     */
    boolean open() default false;

    /**
     * @return 资源名字，默认为方法名字
     */
    String name() default "";

    /**
     * @return 资源描述 默认为方法名字
     */
    String description() default "";

    /**
     * @return 是否允许未登录访问
     */
    boolean permitAll() default false;
}