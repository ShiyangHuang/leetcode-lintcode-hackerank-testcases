package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/10.
 */
public class firstMissingPositive {
    /**
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        // write your code here
        int n = A.length;
        if (n == 0) {
            return 1;
        }
        for (int i = 0; i < n; )
        {
            if (0 < A[i] && A[i] < n && A[i] != i && A[A[i]] != A[i]) {
                int tmp = A[i];
                A[i] = A[tmp];
                A[tmp] = tmp;
            }
            else i++;
        }
        for (int i = 1; i < n; i++)
            if (A[i] != i) return i;

        return A[0] == n? n+1:n;
    }

    public static void main(String[] args) {
        int[] a = {-1,-1,-1,-1,-1,-1};
        System.out.print(new firstMissingPositive().firstMissingPositive(a));
    }
}
