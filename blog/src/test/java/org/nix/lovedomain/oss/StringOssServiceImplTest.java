package org.nix.lovedomain.oss;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringOssServiceImplTest {

    private StringOssServiceImpl stringOssService;

    @Before
    public void before(){
        stringOssService = new StringOssServiceImpl(new OssProperties(),"zhangpei-bisha-blog");
    }

    @Test
    public void upload(){
        String upload = stringOssService.upload("zhangpei", "zhangpei");
        System.out.println(upload);
        String zhangpei = stringOssService.getValue("zhangpei");
        assertEquals(zhangpei,"zhangpei");
    }

}