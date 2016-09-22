package com.testcases;

/**
 * Created by shiyanghuang on 16/9/15.
 */
public class exceptionTest {
    public static void main(String[] args) {
        int[] str = {1,2};
        try {
            System.out.print(str[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
