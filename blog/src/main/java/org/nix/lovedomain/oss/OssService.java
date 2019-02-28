package org.nix.lovedomain.oss;

import java.io.OutputStream;

/**
 * @author zhangpei
 * @version 1.0
 * @description Oss服务接口
 * @date 2019/2/28
 */
public interface OssService<T> {

    /**
     * @param key  文件存储名字
     * @param data 存储的数据信息
     * @return java.lang.String
     * @description 上传到oss服务器上
     * @author zhangpe0312@qq.com
     * @date 2019/2/28
     */
    String upload(String key, T data);

    /**
     * @param key 数据存储路径
     * @param outputStream 获取输出流
     * @return void
     * @description 从oss上下载数据到输出流中
     * @author zhangpe0312@qq.com
     * @date 2019/2/28
     */
    void down(String key, OutputStream outputStream);

}
