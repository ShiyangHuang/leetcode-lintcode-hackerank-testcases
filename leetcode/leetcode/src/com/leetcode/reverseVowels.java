package com.leetcode;

import java.util.ArrayList;

/**
 * Created by shiyanghuang on 16/5/3.
 */
public class reverseVowels {
    public String reverseVowels(String s) {
        ArrayList<Character> arrayList = new ArrayList<Character>();
        String vowerls = "aeiouAEIOU";
        for (int i = 0; i < s.length(); i++) {
            if (vowerls.contains(s.charAt(i) + "")) {
                arrayList.add(s.charAt(i));
            }
        }
        int j = arrayList.size() - 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (vowerls.contains(s.charAt(i) + "")) {
                sb.append(arrayList.get(j--));
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "hello";
        System.out.print(new reverseVowels().reverseVowels(str));
    }
}
