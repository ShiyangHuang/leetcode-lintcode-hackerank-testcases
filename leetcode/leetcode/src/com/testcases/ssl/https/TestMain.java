package com.testcases.ssl.https;

/**
 * Created by shiyanghuang on 17/2/13.
 */
import java.util.HashMap;
import java.util.Map;
//对接口进行测试
public class TestMain {
    private String url = "http://centos.dgctrl6:8111/HDFSAgent/services/KeepAlive?agentId=1&controllerUrl=http://192.168.6.39:10181";
    private String charset = "utf-8";
    private HttpClientUtil httpClientUtil = null;

    public TestMain(){
        httpClientUtil = new HttpClientUtil();
    }

    public void test(){
        String httpOrgCreateTest = url + "httpOrg/create";
        Map<String,String> createMap = new HashMap<String,String>();
        createMap.put("authuser","asdf1234");
        createMap.put("authpass","asdf1234");
        createMap.put("orgkey","asdf1234");
        createMap.put("orgname","asdf1234");
        String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest,createMap,charset);
        System.out.println("result:"+httpOrgCreateTestRtn);
    }

    public static void main(String[] args){
        TestMain main = new TestMain();
        main.test();
    }
}
