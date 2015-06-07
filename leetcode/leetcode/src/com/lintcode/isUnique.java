package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/6.
 */
public class isUnique {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        int[] l = new int[200];
        for (int i = 0; i < str.length(); i++) {
            if (l[str.charAt(i)] != 0) {
                return false;
            } else {
                l[str.charAt(i)]++;
            }
        }
        return true;
    }
}
