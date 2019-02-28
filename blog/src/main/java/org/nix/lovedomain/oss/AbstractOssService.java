package org.nix.lovedomain.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ObjectMetadata;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
 * @author zhangpei
 * @version 1.0
 * @description 抽象的实现Oss服务
 * @date 2019/2/28
 */
@Slf4j
public abstract class AbstractOssService<T> implements OssService<T> {

    private OssProperties ossProperties;

    private OSSClient ossClient;

    private String bucketName;
    /**
     * 额外的key，用户可以不使用，使用该值只是为了更进一步的区分数据类容
     */
    String key;

    public AbstractOssService(OssProperties ossProperties, String bucketName, String key) {
        this(ossProperties, bucketName);
        this.key = key;
    }

    public AbstractOssService(OssProperties ossProperties, String bucketName) {
        this.ossProperties = ossProperties;
        this.bucketName = bucketName;
    }

    @Override
    public String upload(String key, T data) {
        createClient();
        InputStream input = dataToInputStream(data);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        configurationObjectMetadata(objectMetadata,data);
        ossClient.putObject(bucketName, createKey(key), input, objectMetadata);
        String url = getUrl(key);
        shutdown();
        return url;
    }

    /**
     * https://blog.csdn.net/wahaha13168/article/details/81236090 html数据类型
     * @param objectMetadata oss数据格式
     * @param data 数据信息
     * @return void
     * @description 配置数据格式信息
     * @author zhangpe0312@qq.com
     * @date 2019/2/28
     */
    abstract void configurationObjectMetadata(ObjectMetadata objectMetadata,T data);

    /**
     * @param data 数据对象
     * @return java.io.InputStream
     * @description 讲数据对象转换成输入流
     * @author zhangpe0312@qq.com
     * @date 2019/2/28
     */
    abstract InputStream dataToInputStream(T data);

    /**
     * @return java.lang.String
     * @description 返回一个目录
     * @author zhangpe0312@qq.com
     * @date 2019/2/28
     */
    abstract String directory();

    private String createKey(String fileName) {
        if (key != null) {
            return directory() + "/" + key + "/" + fileName;
        }
        return directory() + "/" + fileName;
    }

    @Override
    public void down(String key, OutputStream outputStream) {
        createClient();
        InputStream inputStream = null;
        URL url;
        String path = null;
        try {
            path = getUrl(key);
            if (path == null) {
                throw new OSSException(key + "指向的数据不存在");
            }
            url = new URL(path);
            HttpURLConnection uc = (HttpURLConnection) url.openConnection();
            //设置是否要从 URL 连接读取数据,默认为true
            uc.setDoInput(true);
            uc.connect();
            inputStream = uc.getInputStream();
            byte[] buffer = new byte[4 * 1024];
            int byteRead;
            while ((byteRead = (inputStream.read(buffer))) != -1) {
                outputStream.write(buffer, 0, byteRead);
            }
            outputStream.flush();
        } catch (MalformedURLException e) {
            log.info("创建url:{}链接下载数据失败:{}", path, e.getMessage());
            throw new OSSException("下载文件失败", e);
        } catch (IOException e) {
            log.info("{}的数据读取数据失败:{}", path, e.getMessage());
            throw new OSSException("下载文件失败", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.info("关闭输入流失败", path, e.getMessage());
                }
            }
        }
        shutdown();
    }

    /**
     * @param key 数据存储路径
     * @return java.lang.String
     * @description 获取url获取存储路径的信息
     * @author zhangpe0312@qq.com
     * @date 2019/2/28
     */
    private String getUrl(String key) {
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, createKey(key), urlExpirationTime());
        if (url != null) {
            return url.toString();
        }
        return null;
    }

    /**
     * @return java.util.Date
     * @description 默认设置URL过期时间为10年  3600l* 1000*24*365*10
     * @author zhangpe0312@qq.com
     * @date 2019/2/28
     */
    protected Date urlExpirationTime() {
        return new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
    }

    /**
     * @description 创建一个oss客户端
     * @author zhangpe0312@qq.com
     * @date 2019/2/28
     */
    private void createClient() {
        ossClient = new OSSClient(ossProperties.getEndpoint(),
                ossProperties.getAccessKeyId(),
                ossProperties.getAccessKeySecret());
    }

    /**
     * @return void
     * @description 关闭客户端
     * @author zhangpe0312@qq.com
     * @date 2019/2/28
     */
    private void shutdown() {
        ossClient.shutdown();
    }


}
