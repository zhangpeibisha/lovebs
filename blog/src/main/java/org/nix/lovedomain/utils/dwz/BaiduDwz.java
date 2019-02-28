package org.nix.lovedomain.utils.dwz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author zhangpei
 * @version 1.0
 * @description 百度短地址工具
 * @date 2019/2/28
 */
public class BaiduDwz {
    final static String CREATE_API = "https://dwz.cn/admin/v2/create";
    final static String TOKEN = "e6119a2803cc335e992cb4825bbd4466";

    public static class UrlResponse {

        @JSONField(name = "Code")
        private int code;

        @JSONField(name = "ErrMsg")
        private String errMsg;

        @JSONField(name = "LongUrl")
        private String longUrl;

        @JSONField(name = "ShortUrl")
        private String shortUrl;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getErrMsg() {
            return errMsg;
        }

        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }

        public String getLongUrl() {
            return longUrl;
        }

        public void setLongUrl(String longUrl) {
            this.longUrl = longUrl;
        }

        public String getShortUrl() {
            return shortUrl;
        }

        public void setShortUrl(String shortUrl) {
            this.shortUrl = shortUrl;
        }
    }

    /**
     * 创建短网址
     *
     * @param longUrl 长网址：即原网址
     * @return 成功：短网址
     * 失败：返回空字符串
     */
    public static String createShortUrl(String longUrl) {
        String params = "{\"url\":\"" + longUrl + "\"}";

        BufferedReader reader = null;
        try {
            // 创建连接
            URL url = new URL(CREATE_API);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            // 设置请求方式
            connection.setRequestMethod("POST");
            // 设置发送数据的格式
            connection.setRequestProperty("Content-Type", "application/json");
            // 设置发送数据的格式");
            connection.setRequestProperty("Token", TOKEN);

            // 发起请求
            connection.connect();
            // utf-8编码
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            out.append(params);
            out.flush();
            out.close();

            // 读取响应
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            StringBuilder res = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                res.append(line);
            }
            reader.close();
            System.out.println(res);
            // 抽取生成短网址
            UrlResponse urlResponse = JSON.parseObject(res.toString(), UrlResponse.class);
            int code = urlResponse.getCode();
            switch (code) {
                case 0:
                    return urlResponse.getShortUrl();
                case -1:
                    throw new RuntimeException("短网址生成失败");
                case -2:
                    throw new RuntimeException("长网址不合法");
                case -3:
                    throw new RuntimeException("长网址存在安全隐患");
                case -4:
                    throw new RuntimeException("长网址插入数据库失败");
                case -5:
                    throw new RuntimeException("长网址在黑名单中，不允许注册");
                default:
                    throw new RuntimeException("短网址生成失败,意料之外的错误代码" + code);
            }
        } catch (IOException e) {
            throw new RuntimeException("生成短地址失败", e);
        }
    }

    public static void main(String[] args) {
        String res = createShortUrl("http://zhangpei-bisha-blog.oss-cn-beijing.aliyuncs.com/file/IMG_20180716_191336.jpg?Expires=1551350677&OSSAccessKeyId=TMP.AQFAu0H4hGZN2IgcPp8M7TnVc3spYhRwgZrrTkXlcL0JnvLg4Mb9MOr9m7OzADAtAhQv40V6uL9F6KqPLRJMjLFwCrE-iQIVANI3mj56-DsswMgVHlZ3p0lmE20X&Signature=1oU858MnKIVUbMPmlOitfOViaC0%3D");
        System.out.println(res);
    }

}
