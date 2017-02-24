package com.leetcode;

import java.util.LinkedList;

/**
 * Created by shiyanghuang on 16/10/20.
 */
public class maxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] ans = new int[nums.length - k + 1];
        LinkedList<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.offerLast(i);
            if ((i + 1) >= k) ans[i + 1 - k] = nums[deque.peek()];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] list = {1,3,-1,-3,5,3,6,7};
        int[] ans = maxSlidingWindow(list, 3);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i] + " ");
        }
    }
}
