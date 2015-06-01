package com.lintcode;

/**
 * Created by shiyanghuang on 15/5/27.
 */
public class sqrt {
    public int sqrt(int x) {
        // write your code here
        if (x == 1) return 1;
        long l = 0, r = x;
        long ans = 0;
        while (l < r) {
            ans = (l + r) / 2;
            if (ans * ans > x) {
                r = ans;
            } else if ((ans + 1) * (ans + 1) <= x) {
                l = ans;
            } else return (int) ans;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(new sqrt().sqrt(9));
        System.out.println(Math.sqrt(2147483647));
    }
}
