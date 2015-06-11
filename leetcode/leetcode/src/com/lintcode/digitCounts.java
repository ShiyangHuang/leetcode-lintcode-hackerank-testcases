package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/11.
 */
public class digitCounts {
    /*
 * param k : As description.
 * param n : As description.
 * return: An integer denote the count of digit k in 1..n
 */
    public int digitCounts(int k, int n) {
        // write your code here
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            ans += check(i,k);
        }
        return ans;
    }
    int check(int a,int k) {
        int ans = 0;
        while (a > 0) {
            if (a % 10 == k) {
                ans++;
            }
            a /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.print(new digitCounts().digitCounts(1,13));
    }
}
