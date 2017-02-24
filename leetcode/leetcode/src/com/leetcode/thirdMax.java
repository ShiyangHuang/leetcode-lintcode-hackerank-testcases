package com.leetcode;

/**
 * Created by shiyanghuang on 17/1/6.
 */
public class thirdMax {
    public int thirdMax(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            if (k > max1) {
                int tmp = max1;
                max1 = k;
                k = tmp;
            }
            if (k > max2) {
                int tmp = max2;
                max2 = k;
                k = tmp;
            }
            if (k > max3) {
                max3 = k;
                continue;
            }
        }
        if (max3 > Integer.MIN_VALUE) {
            return max3;
        }
        if (max1 > Integer.MIN_VALUE) {
            return max1;
        }
        return nums[0];
    }
}
