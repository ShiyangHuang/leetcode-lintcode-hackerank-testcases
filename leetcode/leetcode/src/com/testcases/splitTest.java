package com.testcases;

/**
 * Created by shiyanghuang on 16/6/28.
 */
public class splitTest {
    public static void main(String[] args) {
        String s1 = "34(+1):2,3,4#Email";
        String[] sp1 = s1.split("#");
        // System.out.print(sp[0]);

        String s2 = ":";
        String[] sp2 = s2.split(":");
        System.out.print(sp2.length);

        String uri = "gs://asdfasdf/asdfasdf";
        System.out.println(uri);
        if (uri.startsWith("gs://")) {
            System.out.println(uri.substring(0, uri.indexOf("/",5)));
        }
    }
}
