package com.testcases;

/**
 * Created by shiyanghuang on 16/7/1.
 */
public class trimTest {
    public static void main(String[] args) {
        String s = "abcd\r\n";
        System.out.print(s);
        String st = s.trim();
        System.out.print(st);
        System.out.print("END");
    }
}
