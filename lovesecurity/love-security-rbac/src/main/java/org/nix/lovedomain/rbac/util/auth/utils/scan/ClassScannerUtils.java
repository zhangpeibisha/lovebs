package org.nix.lovedomain.rbac.util.auth.utils.scan;

import java.util.Set;
import java.util.function.Predicate;

/**
 * @author zhangpei
 * @version 1.0
 * @description class扫描工具类
 * @date 2019/2/14
 */
public class ClassScannerUtils {

    public static Set<Class<?>> searchClasses(String packageName){
        return searchClasses(packageName,null);
    }

    public static Set<Class<?>> searchClasses(String packageName, Predicate<Class<?>> predicate){
        return ScanExecutor.getInstance().search(packageName,predicate);
    }
}
