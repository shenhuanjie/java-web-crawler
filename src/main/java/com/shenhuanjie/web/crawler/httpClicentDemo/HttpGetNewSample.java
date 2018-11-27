package com.shenhuanjie.web.crawler.httpClicentDemo;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;

public class HttpGetNewSample {
    public static void main(String[] args) {
        // String uri = "http://www.baidu.com";

        // 如果有请求参数的话，使用setParameter来设置参数
        String uri = new URIBuilder()
                .setScheme("http")
                .setHost("www.baidu.com")
                .setPath("/s")
                .setParameter("wd", "HttpClient")
                .toString();

        System.out.println(uri);

        // 使用默认配置的HttpClient
        CloseableHttpClient client = HttpClients.createDefault();
        // 使用Get方法
        HttpGet httpGet = new HttpGet(uri);
        InputStream inputStream = null;
        CloseableHttpResponse response = null;

        try {
            // 执行请求，获取响应
            response = client.execute(httpGet);
            // 请求是否成功，打印http状态码
            System.out.println(response.getStatusLine().getStatusCode());
            // 获取响应的实体内容，即所要抓取的网页内容
            HttpEntity entity = response.getEntity();

            //打印到控制台
            //方法一：使用EntityUtils
            if (entity != null) {
                System.out.println(EntityUtils.toString(entity, "utf-8"));
            }
            EntityUtils.consume(entity);
            //方法二  :使用inputStream
           /* if (entity != null) {
                inputStream = entity.getContent();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);

                }
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
