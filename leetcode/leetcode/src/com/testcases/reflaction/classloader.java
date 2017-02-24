package com.testcases.reflaction;

/**
 * Created by shiyanghuang on 16/10/24.
 */
public class classloader {
    private int num;
    public classloader() {
        num = (int)Math.random()*100;
    }
    public int getRandNum() {
        return this.num;
    }

    public static String maskString(String str) {
        return str.hashCode() + "";
    }
}
