package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiyanghuang on 15/7/8.
 */
public class summaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        if (nums.length == 0) {
            return list;
        }
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                end = nums[i];
            } else {
                if (start == end) {
                    list.add(start + "");
                } else {
                    list.add(start + "->" + end);
                }
                start = nums[i];
                end = nums[i];
            }
        }
        if (start == end) {
            list.add(start + "");
        } else {
            list.add(start + "->" + end);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,5,6,8,9};
        System.out.print(new summaryRanges().summaryRanges(nums));
    }
}
