package com.lintcode;

import java.util.ArrayList;

/**
 * Created by shiyanghuang on 15/6/11.
 */
public class recoverRotatedSortedArray {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        int t = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                t = i;
            }
        }
        if (t != 0) {
            reverse(nums,0,t - 1);
            reverse(nums,t,nums.size() - 1);
            reverse(nums,0,nums.size() - 1);
        }
    }
    void reverse(ArrayList<Integer> nums, int l, int r) {
        while (l < r) {
            int tmp = nums.get(l);
            nums.set(l,nums.get(r));
            nums.set(r,tmp);
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 3; i < 10; i++) {
            a.add(i);
        }
        for (int i = 0; i < 3; i++) {
            a.add(i);
        }
        new recoverRotatedSortedArray().recoverRotatedSortedArray(a);
        System.out.print(a);
    }
}
