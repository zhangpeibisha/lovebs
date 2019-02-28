package org.nix.lovedomain.oss;

import com.aliyun.oss.model.ObjectMetadata;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * @author zhangpei
 * @version 1.0
 * @description 上传字符串实现类
 * @date 2019/2/28
 */
public class StringOssServiceImpl extends AbstractOssService<String> {


    public StringOssServiceImpl(OssProperties ossProperties, String bucketName) {
        super(ossProperties, bucketName);
    }

    @Override
    InputStream dataToInputStream(String data) {
        return new ByteArrayInputStream(data.getBytes());
    }

    @Override
    void configurationObjectMetadata(ObjectMetadata objectMetadata, String data) {
        objectMetadata.setContentType("application/json");
        objectMetadata.setContentDisposition(data);
    }

    /**
     * @param key 数据key
     * @return java.lang.String
     * @description 通过key获取到value
     * @author zhangpe0312@qq.com
     * @date 2019/2/28
     */
    public String getValue(String key) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        down(key, outputStream);
        return outputStream.toString();
    }

    @Override
    String directory() {
        return "string";
    }

}
