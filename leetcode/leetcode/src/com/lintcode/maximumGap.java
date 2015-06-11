package com.lintcode;

import java.util.Arrays;

/**
 * Created by shiyanghuang on 15/6/8.
 */
public class maximumGap {
    /**
     * @param nums: an array of integers
     * @return: the maximum difference
     */
    public int maximumGap(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        if (nums.length < 2) {
            return 0;
        }
        int maxgap = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            maxgap = maxgap > nums[i] - nums[i - 1] ? maxgap : nums[i] - nums[i - 1];
        }
        return maxgap;
    }
}
