package com.testcases;

/**
 * Created by shiyanghuang on 16/6/28.
 */
public class splitTest {
    public static void main(String[] args) {
        String s = "34(+1):2,3,4#Email";
        String[] sp = s.split("#");
        // System.out.print(sp[0]);

        System.out.print(sp[0]);
    }
}
