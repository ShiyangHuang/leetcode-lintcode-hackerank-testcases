package com.lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shiyanghuang on 15/6/6.
 */
public class anagram {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if (s == null && t == null) return true;
        if (s == null || t == null) return true;
        if (s.length() != t.length()) return false;
        int[] letters = new int[200];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
            letters[t.charAt(i)]--;
        }
        for (int i = 0; i < 200; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
