package com.leetcode;

import java.util.HashSet;

/**
 * Created by shiyanghuang on 15/7/6.
 */
public class isPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        HashSet<Integer> list = new HashSet<Integer>();
        for (int i = 0; i < 31; i++) {
            list.add(1<<i);
        }
        System.out.print(list);
        if (list.contains(n)) return true;
        return false;
    }
    public static void main(String[] args) {
        new isPowerOfTwo().isPowerOfTwo(1);
    }
}
