package com.lintcode;

import java.util.ArrayList;

/**
 * Created by shiyanghuang on 15/6/3.
 */
public class continuousSubarraySum {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code asdfheredfasdf
        ArrayList<Integer> a = new ArrayList<Integer>();
        int i = 0, j = 1, n = A.length;
        int a1 = 0, a2 = 0, max = A[0], sum = A[0];
        while (j < n) {
            if (A[j] > A[j] + sum) {
                if (sum > max) {
                    max = sum;
                    a1 = i;
                    a2 = j-1;
                }
                sum = A[j];
                i = j;
                j++;
            } else {
                sum += A[j];
                if (sum > max) {
                    max = sum;
                    a1 = i;
                    a2 = j;
                }
                j++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(A[a1]);
        ans.add(A[a2]);
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {-3, 1, 3, -3, 4};
        System.out.print(new continuousSubarraySum().continuousSubarraySum(a));
    }
}
