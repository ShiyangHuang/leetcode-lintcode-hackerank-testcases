package com.leetcode;

/**
 * Created by shiyanghuang on 15/11/5.
 */
public class uglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        long n = Math.abs((long)num);
        if (n < 6) {
            return true;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n %5 == 0) {
            n /= 5;
        }
        System.out.println(n);
        if (n >= 7) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print(new uglyNumber().isUgly(0));
    }
}
