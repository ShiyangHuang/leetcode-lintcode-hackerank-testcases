package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/6.
 */
public class houseRobber {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        if (A.length == 0) return 0;
        if (A.length == 1) return A[0];
        long a1 = A[0], a2 = A[1];
        for (int i = 2; i < A.length; i++) {
            long tmp = a2;
            a2 = Math.max(a2, a1 + A[i]);
            a1 = tmp;
        }
        return Math.max(a1, a2);
    }

    public static void main(String[] args) {
        int[] A = {3,8,4};
        System.out.print(new houseRobber().houseRobber(A));
    }
}
