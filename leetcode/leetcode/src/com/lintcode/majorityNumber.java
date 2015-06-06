package com.lintcode;

import java.util.ArrayList;

/**
 * Created by shiyanghuang on 15/6/5.
 */
public class majorityNumber {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if (nums.size() == 1) return nums.get(0);
        int p = 0, q = 1;
        while (nums.size() > 2) {
            for (int i = 1; i < nums.size(); i++) {
                if (nums.get(i) != nums.get(0)) {
                    nums.remove(i);
                    nums.remove(0);
                    break;
                } else if (i == nums.size() - 1) {
                    return nums.get(0);
                }
            }
        }
        return nums.get(0);
    }
}
