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
        a.add(A[0]);
        int max = A[0], subans = A[0], a1 = 0, a2 = 0, ta1 = 0;
        for (int i = 1; i < A.length; i ++) {
            if (A[i] > a.get(i-1) + A[i]) {
                if (a.get(i-1) > max) {
                    max = a.get(i-1);
                    a2 = i - 1;
                    a1 = ta1;
                    ta1 = i;
                }
            } else {

            }

        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(a1);
        ans.add(a2);
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {-3, 1, 3, -3, 4};
        System.out.print(new continuousSubarraySum().continuousSubarraySum(a));
    }
}
