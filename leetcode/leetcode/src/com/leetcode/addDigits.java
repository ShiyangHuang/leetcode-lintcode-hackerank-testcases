package com.leetcode;

/**
 * Created by shiyanghuang on 15/11/5.
 */
public class addDigits {
    public int addDigits(int num) {
        while (num > 10) {
            int n = 0;
            while (num > 0) {
                n += num % 10;
                num /= 10;
            }
            num = n;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new addDigits().addDigits(38));
    }
}
