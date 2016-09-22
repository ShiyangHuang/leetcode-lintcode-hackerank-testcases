package com.testcases;

/**
 * Created by shiyanghuang on 16/9/15.
 */
public class charAtTest {
    public static void main(String[] args) {
        String str = "ISA*Au*AuthInfo  *Se*SecuInfo  *30*377229987      *32*450700699      *160426*1651*U*00401*461714690*0*P*~";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '*') {
                System.out.println(i);
            }
        }
    }
}
