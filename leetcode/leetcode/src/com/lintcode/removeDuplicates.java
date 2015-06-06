package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/3.
 */
public class removeDuplicates {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums.length == 0) return 0;
        int count = 0;
        int hasOne = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[count] != nums[i]) {
                hasOne = 0;
                count++;
                nums[count] = nums[i];
            } else if (hasOne == 0) {
                hasOne = 1;
                count++;
                nums[count] = nums[i];
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        int[] a = {-8,0,1,2,3};
        System.out.print(new removeDuplicates().removeDuplicates(a));
        for (int i = 0; i < a.length; i ++) {
            System.out.print(a[i]);
        }
    }
}
