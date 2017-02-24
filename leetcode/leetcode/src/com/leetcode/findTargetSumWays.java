package com.leetcode;

/**
 * Created by shiyanghuang on 17/1/24.
 */
public class findTargetSumWays {
    int ans = 0;

    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, S, 0, 0);
        return ans;
    }

    private void dfs(int[] nums, int S, int sum, int k) {
        if (k == nums.length) {
            if (sum == S) {
                ans++;
            }
            return;
        }
        dfs(nums, S, sum + nums[k], k + 1);
        dfs(nums, S, sum - nums[k], k + 1);
    }

    public static void main(String[] args) {
        new findTargetSumWays().findTargetSumWays(new int[]{1,1,1,1,1}, 3);
    }
}
