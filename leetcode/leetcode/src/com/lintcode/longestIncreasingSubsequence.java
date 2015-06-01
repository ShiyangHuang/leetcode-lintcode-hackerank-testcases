package com.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiyanghuang on 15/5/27.
 */
public class longestIncreasingSubsequence {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
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
}
