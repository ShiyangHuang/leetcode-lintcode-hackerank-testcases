package com.leetcode;

/**
 * Created by shiyanghuang on 15/11/5.
 */
public class moveZeros {
    public void moveZeroes2(int[] nums) {
        if (nums.length <=1 ) {
            return;
        }
        int i = 0, j = 0;
        while (j < nums.length && nums[j] != 0) {
            j++;
        }
        while (j < nums.length) {
            i = j - 1;
            while (i >= 0) {
                nums[i + 1] = nums[i];
                i--;
            }
            nums[i + 1] = 0;
            j++;
            while (j < nums.length && nums[j] != 0) {
                j++;
            }
        }
    }

    public void moveZeroes(int[] nums) {
        if (nums.length <=1 ) {
            return;
        }
        int i = 0, j = 0;

        while (j < nums.length && i < nums.length) {
            while (i < nums.length && nums[i] != 0) {
                i++;
            }
            while (j < i || (j < nums.length && nums[j] == 0)) {
                j++;
            }
            if (i >= nums.length || j >= nums.length) {
                return;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j++;
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 0};
        new moveZeros().moveZeroes(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
