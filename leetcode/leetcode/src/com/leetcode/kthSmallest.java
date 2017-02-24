package com.leetcode;

import java.util.Arrays;

/**
 * Created by shiyanghuang on 16/12/13.
 */
public class kthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix[0].length;
        int l = matrix[0][0];
        int r = matrix[n - 1][n - 1];

        while (l < r) {
            int mid = (l + r) / 2;
            int tmp = 0;

            System.out.println("L = " + l  + " R = " + r + " MID = " + mid);

            for (int i = 0; i < n; i++) {
                int index = Arrays.binarySearch(matrix[i], mid);
                tmp += (index >= 0 ? index+ 1 : ~index);
                System.out.println("index = " + index + "  TMP: " + tmp);
            }

            if (tmp < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[][] a = {{1,5,9},{10,11,13},{12,13,15}};
        int[][] b = {{1,2},{1,3}};
        System.out.print(new kthSmallest().kthSmallest(a, 8));
    }
}
