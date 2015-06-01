package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shiyanghuang on 15/5/25.
 */
public class containsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> m = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i ++) {
            if (m.contains(nums[i])) return false;
            else {
                m.add(nums[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
