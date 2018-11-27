package com.shenhuanjie.web.crawler.chapter;

import org.apache.http.client.HttpClient;

import java.io.InputStream;
import java.net.URL;

/**
 *
 */
public class demo {
    public static void main(String[] args) {
        String path = "http://www.shenhuanjie.com";
        try {
            URL pageURL = new URL(path);
            InputStream stream = pageURL.openStream();
            // 创建一个客户端，类似于打开一个浏览器
//            HttpClient httpClient=new HttpClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
