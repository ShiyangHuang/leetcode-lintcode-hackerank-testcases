package com.leetcode;

/**
 * Created by shiyanghuang on 15/5/22.
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int minLength = nums.length + 1;
        if (nums.length == 0) return 0;
        int sum = nums[0];
        int p = 1, q = 0;
        while (p < nums.length) {
            if (sum >= s) {
                minLength = Math.min(minLength, p - q);
                sum -= nums[q++];
            } else {
                sum += nums[p++];
            }
        }
        while (s <= sum && q < nums.length) {
            if (sum >= s) {
                minLength = Math.min(minLength, p - q);
                sum -= nums[q++];
            }
        }
        if (minLength == nums.length + 1) return 0;
        return minLength;
    }

    public static void main(String[] args) {
        int[] array = {2,3,1,2,4,3};
        System.out.print(new MinSubArrayLen().minSubArrayLen(11, array));
    }
}
