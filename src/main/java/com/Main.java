package com;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangzhen
 * @Description
 * @CreateDate 2020/3/1 18:04
 */
public class Main {
    static CloseableHttpClient client = HttpClientBuilder.create().build();
    static HttpGet get = new HttpGet("https://chp.shadiao.app/api.php");
    public static void main(String[] args) throws Exception {
        addRequestHeaders(get);
        List<String> list = new ArrayList<String>();
        int count = 0;
        for (int i = 0; i < 20; i++) {
            CloseableHttpResponse execute = client.execute(get);
            HttpEntity entity = execute.getEntity();
            String s = EntityUtils.toString(entity, "utf-8");
            DataSource.insert(s);
            Thread.sleep(1000);
            System.out.println("第"+i+"条彩虹屁："+s.replace("\n",""));
        }
    }

    private static void addRequestHeaders(HttpGet get){
        get.addHeader("Accept","application/json, text/javascript, */*; q=0.01");
        get.addHeader("Accept-Encoding","gzip, deflate");
        get.addHeader("Accept-Language","zh-CN,zh;q=0.9");
        get.addHeader("Connection","keep-alive");
//        get.addHeader("Content-Length","68");
        get.addHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        get.addHeader("Cookie","JSESSIONID=4BC7700914881D3E3BF805A5FF95EF2D; JSE=USRFefQ8bd; _SESSIONKEY=EI0B6026WKT0V32YMIV6; lqtoken=8D1A9A0B0F37479FACA7CD0451A91808");
        get.addHeader("Host","lx.lanqiao.cn");
        get.addHeader("Origin","http://lx.lanqiao.cn");
        get.addHeader("Referer","http://lx.lanqiao.cn/problemset.page?code=PREV-&userid=123175");
        get.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36");
        get.addHeader("X-Requested-With","XMLHttpRequest");
    }
}
