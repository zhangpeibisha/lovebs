package org.nix.lovedomain.oss;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author zhangpei
 * @version 1.0
 * @description spring mvc文件上传处理
 * @date 2019/3/9
 */
@Slf4j
public class SpringMvcOssServiceImpl extends FileOssServiceImpl {


    public SpringMvcOssServiceImpl(OssProperties ossProperties, String bucketName) {
        super(ossProperties, bucketName);
    }

    public SpringMvcOssServiceImpl(OssProperties ossProperties, String bucketName, String key) {
        super(ossProperties, bucketName, key);
    }

    public SpringMvcOssServiceImpl(OssProperties ossProperties) {
        super(ossProperties,"zhangpei-bisha-blog");
    }

    public String upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        File targetFile = new File(originalFilename);
        inputStreamToFile(inputStream,targetFile);
        return super.upload(targetFile);
    }


    public void inputStreamToFile(InputStream ins, File file) throws IOException {
        OutputStream os = new FileOutputStream(file);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        os.close();
        ins.close();
    }
}
