package com.lintcode;

import java.util.ArrayList;

/**
 * Created by shiyanghuang on 15/6/7.
 */
public class grayCode {
    /**
     * @param n a number
     * @return Gray code
     */
    public ArrayList<Integer> grayCode(int n) {
        // Write your code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < Math.pow(2,n); i++) {
            int tmp = i ^ (i >> 1);
            ans.add(tmp);
        }
        return ans;
    }

    public static void main(String[] args) {
        new grayCode().grayCode(2);
    }
}
