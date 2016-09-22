package com.leetcode;

/**
 * Created by shiyanghuang on 15/7/8.
 */
public class majorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int mjint = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                mjint = nums[i];
            }
            if (nums[i] == mjint) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == mjint) {
                count++;
            }
        }
        if (count >= (nums.length - 1) / 2) {
            return mjint;
        } else {
            return -1;
        }
    }

    public int majorityElement2(int[] nums) {
        int current = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                current = nums[i];
            } else if (current == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        int[] nums = {6,5,5};
        System.out.print(new majorityElement().majorityElement2(nums));
    }

}
