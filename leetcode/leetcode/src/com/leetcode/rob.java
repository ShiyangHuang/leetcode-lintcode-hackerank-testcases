package com.leetcode;

/**
 * Created by shiyanghuang on 15/6/19.
 */
public class rob {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] f = new int[2];
        f[0] = nums[0];
        f[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int tmp = Math.max(f[1], f[0] + nums[i]);
            f[0] = f[1];
            f[1] = tmp;
        }
        return f[1];
    }
    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] f = new int[2];
        f[0] = nums[0];
        f[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            int tmp = Math.max(f[1], f[0] + nums[i]);
            f[0] = f[1];
            f[1] = tmp;
        }
        int[] g = new int[2];
        g[0] = 0;
        g[1] = nums[1];
        for (int i = 2; i < nums.length - 1; i++) {
            int tmp = Math.max(g[1], g[0] + nums[i]);
            g[0] = g[1];
            g[1] = tmp;
        }
        return Math.max(f[1],g[1]);
    }
}
