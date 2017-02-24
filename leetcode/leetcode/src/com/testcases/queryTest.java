package com.testcases;

import org.apache.commons.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * Created by shiyanghuang on 15/12/21.
 */
public class queryTest {

    public static void main(String[] args) {
        String query = "http://192.168.6.91:9099/eagle-service/rest/list?query=AlertDefinitionService[@dataSource=\"hdfsAuditLog\"%20and%20@site=\"Demo\"]{*}&pageSize=100";
        String url = "http://192.168.6.4:7000";
        System.out.print(sendGet(query, ""));
    }

    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";

        String username = "admin";
        String password = "secret";

        String auth=new StringBuffer(username).append(":").append(password).toString();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);

        try {
            URL realUrl = null; //new URL(url);

            String encodedURL=java.net.URLEncoder.encode(url, "UTF-8");
            System.out.println("Encoded URL" + encodedURL);

            realUrl = new URL(encodedURL);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            conn.setRequestProperty("AUTHORIZATION", authHeader);
            System.out.print(authHeader);
            conn.setRequestProperty("Content-Type", "application/json");

            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        String username = "admin";
        String password = "secret";

        String auth=new StringBuffer(username).append(":").append(password).toString();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);

        try {
            URL realUrl = new URL(url);

            ///String encodedURL=java.net.URLEncoder.encode(url, "UTF-8");
            //System.out.println("Encoded URL" + encodedURL);

            //realUrl = new URL(encodedURL);

            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性


            connection.setRequestProperty("AUTHORIZATION", authHeader);
            System.out.println(authHeader);
            connection.setRequestProperty("Content-Type", "application/json");

            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
               System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            System.out.println("Reading stream");
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                //result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}


