package com.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiyanghuang on 15/6/8.
 */
public class numbersByRecursion {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        List<Integer> ans = new ArrayList<Integer>();
        int max = n;
        recursion(ans, max, 1);
        return ans;
    }

    void recursion(List<Integer> ans, int max, int cur) {
        if (cur > max) return;
        for (int i = (int) Math.pow(10,cur - 1); i < (int) Math.pow(10,cur); i++) {
            ans.add(i);
        }
        recursion(ans, max, cur + 1);
    }

    public static void main(String[] args) {
        List<Integer> a = new numbersByRecursion().numbersByRecursion(3);
        System.out.print(a);
    }
}
