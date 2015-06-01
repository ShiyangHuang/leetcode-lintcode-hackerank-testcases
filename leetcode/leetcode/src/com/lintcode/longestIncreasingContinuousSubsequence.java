package com.lintcode;

/**
 * Created by shiyanghuang on 15/5/27.
 */
public class longestIncreasingContinuousSubsequence {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        int n = A.length;
        if (n <= 2) return n;
        int max = 1;
        int subans = 1;
        for (int i = 1; i < n; i ++) {
            if (A[i] >= A[i - 1]) {
                subans++;
            } else {
                max = max > subans ? max : subans;
                subans = 1;
            }
        }
        max = max > subans ? max : subans;
        subans = 1;
        for (int i = n - 2; i >= 0; i --) {
            if (A[i] >= A[i + 1]) {
                subans++;
            } else {
                max = max > subans ? max : subans;
                subans = 1;
            }
        }
        max = max > subans ? max : subans;
        return max;
    }

    public static void main(String[] args) {
        int[] A = {5,4,3,2,1,3};
        System.out.print(new longestIncreasingContinuousSubsequence().longestIncreasingContinuousSubsequence(A));
    }
}
