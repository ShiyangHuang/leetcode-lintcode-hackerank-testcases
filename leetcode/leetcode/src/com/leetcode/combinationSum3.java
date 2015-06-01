package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiyanghuang on 15/5/25.
 */
public class combinationSum3 {
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<List<Integer>>();
        search(k,n,1,new ArrayList<Integer>());
        return ans;
    }
    private void search(int k, int n, int s, List<Integer> subans) {
        if (k < 0 || n < 0) {
            return;
        }
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<Integer>(subans));
            return;
        }

        for (int i = s; i <= 9; i++) {
            if (n - i < 0) return;
            subans.add(i);
            search(k - 1, n - i, i + 1, subans);
            subans.remove(subans.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> a = new combinationSum3().combinationSum3(3,9);
        System.out.print(a);
    }
}
