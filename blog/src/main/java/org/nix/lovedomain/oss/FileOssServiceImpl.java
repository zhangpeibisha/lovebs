package org.nix.lovedomain.oss;

import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ObjectMetadata;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author zhangpei
 * @version 1.0
 * @description 文件上传服务实现
 * @date 2019/2/28
 */
@Slf4j
public class FileOssServiceImpl extends AbstractOssService<File> {

    public FileOssServiceImpl(OssProperties ossProperties, String bucketName) {
        super(ossProperties, bucketName);
    }

    public FileOssServiceImpl(OssProperties ossProperties, String bucketName, String key) {
        super(ossProperties, bucketName, key);
    }

    @Override
    void configurationObjectMetadata(ObjectMetadata objectMetadata, File file) {
        String fileName = file.getName();
        objectMetadata.setContentType(getcontentType(fileName));
        objectMetadata.setCacheControl("no-cache");
        objectMetadata.setHeader("Pragma", "no-cache");
        objectMetadata.setContentDisposition("inline;filename=" + fileName);
    }

    @Override
    InputStream dataToInputStream(File data) {
        try {
            return new FileInputStream(data);
        } catch (FileNotFoundException e) {
            log.info("文件{}不存在", e.getMessage());
            throw new OSSException("文件不存在", e);
        }
    }

    @Override
    String directory() {
        return "file";
    }

    /**
     * Description: 判断OSS服务文件上传时文件的contentType
     *
     * @param fileName 文件名字
     * @return String
     */
    public static String getcontentType(String fileName) {
        if (fileName == null) {
            return "";
        }
        int index;
        if ((index = fileName.lastIndexOf(".")) == -1) {
            return "";
        }
        fileName = fileName.substring(index);
        if (".bmp".equalsIgnoreCase(fileName)) {
            return "image/bmp";
        }
        if (".gif".equalsIgnoreCase(fileName)) {
            return "image/gif";
        }
        if (".jpeg".equalsIgnoreCase(fileName) ||
                ".jpg".equalsIgnoreCase(fileName) ||
                ".png".equalsIgnoreCase(fileName)) {
            return "image/jpeg";
        }
        if (".html".equalsIgnoreCase(fileName)) {
            return "text/html";
        }
        if (".txt".equalsIgnoreCase(fileName)) {
            return "text/plain";
        }
        if (".vsd".equalsIgnoreCase(fileName)) {
            return "application/vnd.visio";
        }
        if (".pptx".equalsIgnoreCase(fileName) ||
                ".ppt".equalsIgnoreCase(fileName)) {
            return "application/vnd.ms-powerpoint";
        }
        if (".docx".equalsIgnoreCase(fileName) ||
                ".doc".equalsIgnoreCase(fileName)) {
            return "application/msword";
        }
        if (".xml".equalsIgnoreCase(fileName)) {
            return "text/xml";
        }
        return "image/jpeg";
    }
}
