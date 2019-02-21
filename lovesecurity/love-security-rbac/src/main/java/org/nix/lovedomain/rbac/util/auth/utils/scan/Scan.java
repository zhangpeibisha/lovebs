package org.nix.lovedomain.rbac.util.auth.utils.scan;

import java.util.Set;
import java.util.function.Predicate;

/**
 * @author zhangpei
 * @version 1.0
 * @description 扫描接口
 * @date 2019/2/14
 */
public interface Scan {

    String CLASS_SUFFIX = ".class";

    Set<Class<?>> search(String packageName, Predicate<Class<?>> predicate);

    default Set<Class<?>> search(String packageName){
        return search(packageName,null);
    }

}
