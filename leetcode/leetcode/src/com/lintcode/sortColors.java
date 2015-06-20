package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/11.
 */
public class sortColors {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        int l = 0, r = nums.length - 1;
        while (l < r) {
            while (l < r && nums[l] == 0) {
                l++;
            }
            while (l < r && nums[r] != 0) {
                r--;
            }
            if (l < r) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
                r--;
            }
        }
        l = 0;
        r = nums.length - 1;
        while (l < r) {
            while (l < r && nums[l] != 2) {
                l++;
            }
            while (l < r && nums[r] == 2) {
                r--;
            }
            if (l < r) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
                r--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0,1,2,1,2,0,2,1,0,2,1,2,0,1,1,2};
        new sortColors().sortColors(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
