package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/10.
 */
public class bitSwapRequired {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        int c = a ^ b;
        int count = 0;
        while (c != 0) {
            if ((c & 1) == 1) {
                count++;
            }
            c = c >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new bitSwapRequired().bitSwapRequired(Integer.MAX_VALUE, Integer.MIN_VALUE));
        System.out.println(new bitSwapRequired().bitSwapRequired(1, -1));
    }
}
