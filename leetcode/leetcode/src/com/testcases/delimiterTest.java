package com.testcases;

/**
 * Created by shiyanghuang on 16/10/12.
 */
public class delimiterTest {
    public static void main(String[] args) {
        String s = "asdf^asdf";
        System.out.print(s.split("\\^")[0]);
    }
}
