package com.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiyanghuang on 15/6/6.
 */
public class anagrams {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> str = new ArrayList<String>();
        for (int i = 0; i < strs.length; i++) {
            str.add(strs[i]);
        }
        int n = strs.length;
        int s = 0;
        List<String> ans = new ArrayList<String>();
        boolean flag = true;
        while (str.size() > 0) {
            if (str.size() == 1) {
                flag = true;
            }
            for (int i = 1; i < str.size(); i++) {
                if (anagram(str.get(i),str.get(0))) {
                    ans.add(str.get(i));
                    ans.add(str.get(0));
                    str.remove(i);
                    str.remove(0);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (int i = 0; i < ans.size(); i++) {
                    if (anagram(str.get(0),ans.get(i))) {
                        ans.add(str.get(0));
                        str.remove(0);
                        break;
                    }
                }
            }
        }
        return ans;
    }

    boolean anagram(String s, String t) {
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

    public static void main(String[] args) {
        String[] str = {"tea","and","ate","eat","den"};
        List<String> a = new anagrams().anagrams(str);
        System.out.print(a);
    }
}
