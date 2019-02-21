package org.nix.lovedomain.rbac.util.auth.utils.scan;

import java.util.Set;
import java.util.function.Predicate;

/**
 * @author zhangpei
 * @version 1.0
 * @description 扫描执行者，单例
 * @date 2019/2/14
 */
public class ScanExecutor implements Scan{
    private volatile static ScanExecutor instance;

    @Override
    public Set<Class<?>> search(String packageName, Predicate<Class<?>> predicate) {
        Scan fileSc = new FileScanner();
        Set<Class<?>> fileSearch = fileSc.search(packageName, predicate);
        Scan jarScanner = new JarScanner();
        Set<Class<?>> jarSearch = jarScanner.search(packageName,predicate);
        fileSearch.addAll(jarSearch);
        return fileSearch;
    }

    private ScanExecutor(){}

    public static ScanExecutor getInstance(){
        if(instance == null){
            synchronized (ScanExecutor.class){
                if(instance == null){
                    instance = new ScanExecutor();
                }
            }
        }
        return instance;
    }
}
