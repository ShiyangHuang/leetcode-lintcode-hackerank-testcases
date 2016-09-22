package com.leetcode;

/**
 * Created by shiyanghuang on 15/11/5.
 */
public class firstBadVersion {
    private int firstBadVersionCode = 1702766719;
    public boolean isBadVersion(int n) {
        if (n >= firstBadVersionCode) {
            return true;
        } else {
            return false;
        }
    }
    public int firstBadVersion(int n) {
        long i = 1, j = n;
        while (i <= j) {
            long m = (i + j) / 2;
            if (isBadVersion((int)m)) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return (int)i;
    }

    public static void main(String[] args) {
        System.out.print(new firstBadVersion().firstBadVersion(2126753390));
    }
}
