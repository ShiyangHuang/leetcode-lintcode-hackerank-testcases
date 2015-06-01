package com.lintcode;

/**
 * Created by shiyanghuang on 15/5/27.
 */
public class longestPalindrome {
    public String longestPalindrome(String s) {
        // Write your code here
        int max = 0;
        int subl = 0, subr = 0;
        for (int i = 0; i < s.length(); i ++) {
            int l = i, r = i;
            int count = -1;
            while ( l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                count += 2;
            }
            if (max < count) {
                subl = l+1;
                subr = r;
                max = count;
            }
            l = i;
            r = i+1;
            count = 0;
            while ( l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                count += 2;
            }
            if (max < count) {
                subl = l+1;
                subr = r;
                max = count;
            }
        }
        return s.substring(subl,subr);
    }

    public static void main(String[] args) {
        System.out.print(new longestPalindrome().longestPalindrome("z"));
    }
}
