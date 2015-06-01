package com.lintcode;

/**
 * Created by shiyanghuang on 15/5/27.
 */
public class isPalindrome {
    public boolean isPalindrome(String s) {
        // Write your code here
        int p = 0, q = s.length() - 1;
        s = s.toLowerCase();
        while (p < q) {
            while (p < q && !isChar(s.charAt(p))) p++;
            while (p < q && !isChar(s.charAt(q))) q--;
            if (s.charAt(p) != s.charAt(q)) return false;
            p++;
            q--;
        }
        return true;
    }
    boolean isChar(char c) {
        if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.print(new isPalindrome().isPalindrome("Bob"));
        System.out.print("Bob".toLowerCase());
    }
}
