package com.lintcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shiyanghuang on 15/6/6.
 */
public class plusOne {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        // Write your code here
        ArrayList<Integer> list = new ArrayList<Integer>(digits.length);
        int flag = 1;
        for (int i = digits.length - 1; i >=0 ; i--) {
            list.add((digits[i] + flag)%10);
            flag = (digits[i] + flag) / 10;
        }
        if (flag == 1) list.add(flag);
        Collections.reverse(list);
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
