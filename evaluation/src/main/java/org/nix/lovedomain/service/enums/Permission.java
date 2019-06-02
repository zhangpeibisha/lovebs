package org.nix.lovedomain.service.enums;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhangpei
 * @version 1.0
 * @description 权限注解
 * @date 2019/5/25
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Permission {

    /**
     * 该资源没有什么需要描述的，默认
     * 使用名字作为描述信息
     */
    String NO_DESCRIPTION = "";

    String name();

    String description() default NO_DESCRIPTION;

    /**
     * 默认所有人可以访问
     *
     * @return
     */
    RoleEnum[] role() default {RoleEnum.STUDENT,RoleEnum.TEACHER,RoleEnum.MANGER};

    /**
     * 是否使用
     * @return
     */
    boolean enable() default true;

}
