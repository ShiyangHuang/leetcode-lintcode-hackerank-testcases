package com.leetcode;

/**
 * Created by shiyanghuang on 15/6/20.
 */
public class findMissing {
    public int findMissing(int[] nums) {
        // write your code here
        for (int i = 0; i < nums.length; i++) {
            nums[i] ++;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i])  <= nums.length) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] a = {9,8,7,6,2,0,1,5,4};
        System.out.print(new findMissing().findMissing(a));
    }
}
