package com.leetcode;

import java.util.TreeSet;

/**
 * Created by shiyanghuang on 15/6/23.
 */
public class containsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (set.floor(n) != null && n <= t + set.floor(n) || set.ceiling(n) != null && set.ceiling(n) <= t + n) {
                return true;
            }
            set.add(n);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
