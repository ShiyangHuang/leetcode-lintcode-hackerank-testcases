package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shiyanghuang on 15/6/1.
 */
public class containsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i ++) {
            if (m.containsKey(nums[i])) {
                if (i - m.get(nums[i]) <= k) {
                    return true;
                } else {
                    m.put(nums[i], i);
                }
            } else {
                m.put(nums[i], i);
            }
        }
        return false;
    }
}
