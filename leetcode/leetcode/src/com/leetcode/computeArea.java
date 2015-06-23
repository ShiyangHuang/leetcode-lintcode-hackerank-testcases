package com.leetcode;

/**
 * Created by shiyanghuang on 15/6/23.
 */
public class computeArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int ans = (D - B) * (C - A) + (H - F) * (G - E);
        int A1 = Math.max(A, E);
        int B1 = Math.max(B, F);
        int C1 = Math.min(C, G);
        int D1 = Math.min(D, H);
        if (D1 < B1 || C1 <= A1) {
            return ans;
        } else {
            return ans - (D1 - B1) * (C1 - A1);
        }
    }
}
