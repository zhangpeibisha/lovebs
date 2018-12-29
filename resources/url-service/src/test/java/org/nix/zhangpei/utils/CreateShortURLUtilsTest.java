package org.nix.zhangpei.utils;

import cn.hutool.crypto.digest.DigestUtil;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 需求分析
 * 1. 生成算法
 * 1.1 通过MD5算法
 * 1.2 通过id转换
 */
public class CreateShortURLUtilsTest {

    private String url = "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&ch=12&tn=98012088_5_dg&wd=500%E4%BA%BF%E7%9A%84%E5%93%88%E5%B8%8C%E5%80%BC%E4%BC%9A%E5%86%B2%E7%AA%81%E5%90%97&oq=postman%2520%25E5%25A6%2582%25E4%25BD%2595%25E8%25AE%25A9%25E4%25BC%259A%25E8%25AF%259D%25E4%25BF%259D%25E5%25AD%2598&rsv_pq=afea1cae0000343c&rsv_t=33a1hZlCN889tdrxe4VOZyT0ybmvuTB%2BoUzowPWJkqrmphx31XNXJZ%2BsCCUgtPvDPvsIMQ&rqlang=cn&rsv_enter=1&inputT=2127037&rsv_sug3=99&rsv_sug1=52&rsv_sug7=100&bs=postman%20%E5%A6%82%E4%BD%95%E8%AE%A9%E4%BC%9A%E8%AF%9D%E4%BF%9D%E5%AD%98";


    @Test
    public void createShortUrl() {
        // 1. 得到要转换的URL


    }

    @Test
    public void createMd5() {
        md5CreateShortUrl(url);
    }

    /**
     * 1、将给定的字符串（长链接） 先转换为32位的一个md5字符串。  比如该字符串用A表示
     * <p>
     * 2、将上面的A字符串分为4段处理， 每段的长度为8 ， 比如四段分别为  M、N、O、P
     * <p>
     * 3、可以将M字符串当作一个16进制格式的数字来处理， 将其转换为一个Long类型。  比如转换为L
     * <p>
     * 4、此时L的二进制有效长度为32位， 需要将前面两位去掉，留下30位  ， 可以 & 0x3fffffff 得到想要的结果
     * <p>
     * 5、此时L的二进制有效长度为30位， 分为6段处理， 每段的长度为5
     * <p>
     * 6、依次取出L的每一段（5位），进行位操作 &  0x0000003D 得到一个 <= 61的数字，来当做index 。根据index 去预定义的字符表里面去取一个字符， 最后能取出6个字符，此时就能那这6个字符相加，成一个字符串。 作为短链接了。
     * <p>
     * 7、根据2重复3、4、5、6 ，总共能得到6个第六步生成的字符串。 
     *
     * @param url
     * @return
     */
    public static String md5CreateShortUrl(String url) {
        // 1.生成md5字符串
        String s = DigestUtil.md5Hex(url);
        System.out.println(s + "   " + s.length());
        assertEquals(s.length(), 32);
        // 2、将上面的A字符串分为4段处理， 每段的长度为8 ， 比如四段分别为  M、N、O、P
        String M = s.substring(0, 8);
        String N = s.substring(8, 16);
        String O = s.substring(16, 24);
        String P = s.substring(24, 32);
        assertEquals(M, "b0866bcf");
        assertEquals(N, "34412058");
        assertEquals(O, "75659540");
        assertEquals(P, "36abc1ab");
        // 3.可以将M字符串当作一个16进制格式的数字来处理， 将其转换为一个Long类型。  比如转换为L
        String twoByte = hexString2binaryString(M);
        System.out.println(twoByte + " " + twoByte.length());
        // 4.此时L的二进制有效长度为32位， 需要将前面两位去掉，留下30位  ， 可以 & 0x3fffffff 得到想要的结果
        // 得到0x3fffffff的二进制字符串
        String s1 = hexString2binaryString("3fffffff");
        System.out.println(s1 + " " + s1.length());
        String and = and(twoByte, s1);
        System.out.println(and + " " + and.length());
        String substring = and.substring(2, 32);
        System.out.println(substring);
        return null;
    }

    public static String and(String s1, String s2) {
        int len = s1.length();
        byte[] bytes = s1.getBytes();
        byte[] bytes1 = s2.getBytes();
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++) {
            result[i] = (byte) (bytes[i] & bytes1[i]);
        }
        return new String(result);
    }

    /**
     * @param hexString 十六进制的字符串
     * @return 对应十六进制字符串的二进制字符串
     */
    public static String hexString2binaryString(String hexString) {
        if (hexString == null || hexString.length() % 2 != 0)
            return null;
        String bString = "", tmp;
        for (int i = 0; i < hexString.length(); i++) {
            tmp = "0000" + Integer.
                    toBinaryString(Integer.parseInt(hexString.substring(i, i + 1), 16));
            bString += tmp.substring(tmp.length() - 4);
        }
        return bString;
    }

    /**
     * @param bString 二进制字符串
     * @return 对应输入的二进制字符串的十六进制的字符串
     */
    public static String binaryString2hexString(String bString) {
        if (bString == null || bString.equals("") || bString.length() % 8 != 0)
            return null;
        StringBuffer tmp = new StringBuffer();
        int iTmp = 0;
        for (int i = 0; i < bString.length(); i += 4) {
            iTmp = 0;
            for (int j = 0; j < 4; j++) {
                iTmp += Integer.parseInt(bString.substring(i + j, i + j + 1)) << (4 - j - 1);
            }
            tmp.append(Integer.toHexString(iTmp));
        }
        return tmp.toString();
    }

}