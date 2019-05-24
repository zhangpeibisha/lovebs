package org.nix.lovedomain.utils;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/5/24
 */
public class ListUtils {

    /**
     * 将list id转换成字符串
     *
     * @param list id集合
     * @param <T>  id类型
     * @return 转换结果
     */
    public static <T> String lsitIdsToString(List<T> list) {
        return list.toString().replaceAll("\\[", "")
                .replaceAll("]", "")
                .replaceAll(" ", "");
    }

}
