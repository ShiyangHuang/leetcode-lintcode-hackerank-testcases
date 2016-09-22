package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shiyanghuang on 15/11/5.
 */
public class wordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        Map<String, String> map = new HashMap<String, String>();
        Map<String, String> map2 = new HashMap<String, String>();

        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i) + "") && !map2.containsKey(strs[i])) {
                return false;
            }
            if (!map.containsKey(pattern.charAt(i) + "") && map2.containsKey(strs[i])) {
                return false;
            }

            if (map.containsKey(pattern.charAt(i) + "") && map2.containsKey(strs[i])) {
                if (!map.get(pattern.charAt(i) + "").equals(strs[i]) || !map2.get(strs[i]).equals(pattern.charAt(i) + "")) {
                    return false;
                }
            } else {
                map.put(pattern.charAt(i) + "",strs[i]);
                map2.put(strs[i],pattern.charAt(i) + "");
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new wordPattern().wordPattern("ab","dog dog"));
    }
}
