package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/3.
 */
public class partitionArray {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (nums[left] % 2 == 1 && left < right) left++;
            while (nums[right] % 2 == 0 && left < right) right--;
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        new partitionArray().partitionArray(a);
        for (int i = 0; i < 4; i ++) {
            System.out.print(a[i]);
        }

    }
}
