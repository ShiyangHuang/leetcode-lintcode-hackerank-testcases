package com.leetcode;

/**
 * Created by shiyanghuang on 15/6/19.
 */
public class totalNQueens {
    int n;
    boolean[] b;
    boolean[] c;
    boolean[] d;
    int ans;

    public int totalNQueens(int n) {
        this.n = n;
        ans = 0;
        b = new boolean[n];
        c = new boolean[n * 2];
        d = new boolean[n * 2];
        for (int i = 0; i < n; i++) {
            b[i] = true;
            c[i] = true;
            d[n - i - 1] = true;
            check(1);
            b[i] = false;
            c[i] = false;
            d[n - i - 1] = false;
        }
        return ans;
    }

    public void check(int depth) {
        if (depth >= n) {
            ans++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!b[i] && !c[i + depth] && !d[n - i + depth - 1]) {
                b[i] = true;
                c[i + depth] = true;
                d[n - i + depth - 1] = true;
                check(depth + 1);
                b[i] = false;
                c[i + depth] = false;
                d[n - i + depth - 1] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.print(new totalNQueens().totalNQueens(8));
    }
}
