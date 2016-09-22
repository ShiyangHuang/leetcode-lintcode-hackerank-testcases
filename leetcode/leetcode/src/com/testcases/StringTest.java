package com.testcases;

import java.util.Arrays;

/**
 * Created by shiyanghuang on 16/9/16.
 */
public class StringTest {
    public static void main(String[] args) {
        String s = "asdf";
        String t = "qwer";
        String[] ss = {"asdf","qwer"};
        changeString(s, t);
        System.out.print(Arrays.asList(ss));
    }

    public static void changeString(String s, String t) {
        s = s + t;
    }
}
