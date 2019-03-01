package org.nix.lovedomain.oss;

import org.junit.Before;

public class FileOssServiceImplTest {

    private FileOssServiceImpl fileOssService;

    @Before
    public void setUp() throws Exception {
        fileOssService = new FileOssServiceImpl(new OssProperties(), "zhangpei-bisha-blog");
    }

//    @Test
//    public void upload() {
//        String pathname = "C:\\Users\\Lenovo\\Desktop\\上海\\IMG_20180716_191336.jpg";
//        File data = new File(pathname);
//        System.out.println(data.getName());
//        String upload = fileOssService.upload(data.getName(), data);
//        System.out.println(upload);
//    }
}