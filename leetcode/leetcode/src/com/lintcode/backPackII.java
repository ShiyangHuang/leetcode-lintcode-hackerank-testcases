package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/10.
 */
public class backPackII {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        int[] f = new int[m + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= A[i]; j--) {
                f[j] = Math.max(f[j], f[j - A[i]] + V[i]);
            }
        }
        return f[m];
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 7};
        int[] v = {1, 5, 2, 4};
        int n = 10;
        System.out.print(new backPackII().backPackII(n,a,v));
    }
}
