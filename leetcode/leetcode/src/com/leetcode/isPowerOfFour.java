package com.leetcode;

/**
 * Created by shiyanghuang on 17/1/9.
 */
public class isPowerOfFour {
    public boolean isPowerOfFour(int num) {
        int x = 1;
        while (x <= num) {
            if (num == x) return true;
            x *= 4;
        }
        return false;
    }
}
