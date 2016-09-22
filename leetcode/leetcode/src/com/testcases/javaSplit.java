package com.testcases;

/**
 * Created by shiyanghuang on 16/5/27.
 */
public class javaSplit {
    public static void main(String[] args) {
        String str = "1+4";
        String[] sp = str.split("\\+");
        System.out.print(sp[0]);
    }
}
