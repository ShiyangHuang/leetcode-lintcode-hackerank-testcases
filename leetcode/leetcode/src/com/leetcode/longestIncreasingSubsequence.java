package com.leetcode;

import com.lintcode.longestIncreasingContinuousSubsequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiyanghuang on 15/6/19.
 */
public class longestIncreasingSubsequence {

    public int longestIncreasingSubsequence(int[] A) {
        // Write your code here
        int n = A.length;
        List<Integer> s = new ArrayList<Integer>();
        s.add(1);
        int max = 0;
        for (int i = 1; i < n; i ++) {
            int tmp = 0;
            for (int j = i - 1; j >= 0; j --) {
                if (A[i] > A[j]) {
                    tmp = tmp > s.get(j) ? tmp : s.get(j);
                }
                if (j == 0) {
                    s.add(tmp+1);
                    max = max > s.get(i) ? max : s.get(i);
                }
            }
        }

        return max;
    }
    public static void main(String[] args) {
        int[] nums = {12,36,43,55,94,90,74,98,52,99,25,97,28,63,13,72,22,83,93,35,73,87,9,34,0,84,53,20,77,38,3,79,78,18,26,62,91,2,59,31,51,85,1,46,5,39,80,65,30,8,69,75,92,6,32,61,56,21,70,89,88,45,40,57,37,47,17,60,49,58};
        System.out.print(new longestIncreasingContinuousSubsequence().longestIncreasingContinuousSubsequence(nums));
    }
}
