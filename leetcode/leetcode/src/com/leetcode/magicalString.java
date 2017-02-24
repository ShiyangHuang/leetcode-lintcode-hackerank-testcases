package com.leetcode;

/**
 * Created by shiyanghuang on 17/1/20.
 */
public class magicalString {
    public int magicalString(int n) {
        StringBuilder s = new StringBuilder("122");
        int p = 2;
        int q = 2;
        while (s.length() < n) {
            for (int i = 0; i < s.charAt(q) - '0'; i++) {
                s.append(s.charAt(p) == '1' ? '2' : '1');
            }
            p += s.charAt(q) - '0';
            q ++;
        }
        System.out.println(s.toString());
        return s.substring(0,n).toString().replaceAll("2","").length();
    }

    public static void main(String[] args) {
        System.out.println(new magicalString().magicalString(4));
    }
}
