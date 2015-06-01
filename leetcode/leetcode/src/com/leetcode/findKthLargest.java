package com.leetcode;

import java.util.Arrays;

/**
 * Created by shiyanghuang on 15/5/25.
 */
public class findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int i = nums.length-1;
        while (k>1) {
            if (nums[i] != nums[i-1]) k--;
            i--;
        }
        return nums[i];
    }
}
