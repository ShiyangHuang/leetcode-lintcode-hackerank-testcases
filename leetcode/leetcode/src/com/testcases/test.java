package com.testcases;

/**
 * Created by shiyanghuang on 15/5/28.
 */
public class test {
    public static void main(String[] args) {
        String s = "asdf*asdf";
        String[] ss = s.split((char)42 + "");
        System.out.print(ss[0]);
    }
}
