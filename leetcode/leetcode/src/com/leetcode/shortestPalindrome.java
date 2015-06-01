package com.leetcode;

/**
 * Created by shiyanghuang on 15/6/1.
 */
public class shortestPalindrome {
    String ans = "";
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return ans;
        for (int i = (n - 1)/2; i >= 0; i --) {
            String ans1 = "";
            String ans2 = "";
            if (checkOdd(i,s)) {
                ans1 = ans;
            }
            if (checkEven(i,s)) {
                ans2 = ans;
            }
            if (ans1.length() != 0 && ans2.length() != 0) {
                return ans1.length() < ans2.length() ? ans1 : ans2;
            } else if (ans1.length() != 0) {
                return ans1;
            } else if (ans2.length() != 0) {
                return ans2;
            }
        }
        System.out.print("None");
        StringBuffer sb = new StringBuffer(s);
        String s1 = sb.reverse().toString();
        ans = s1 + s.substring(1);
        return ans;
    }

    public boolean checkOdd(int mid, String s) {
        int l = mid - 1;
        int r = mid + 1;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l--;
            r++;
        }
        StringBuffer sb = new StringBuffer(s.substring(mid + 1));
        String s1 = sb.reverse().toString();
        ans = s1 + s.substring(mid);
        //System.out.println("odd");
        return true;
    }

    public boolean checkEven(int mid, String s) {
        int l = mid;
        int r = mid + 1;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l--;
            r++;
        }
        StringBuffer sb = new StringBuffer(s.substring(mid + 1));
        String s1 = sb.reverse().toString();
        ans = s1 + s.substring(mid + 1);
        //System.out.println("even");
        return true;
    }

    public static void main(String[] args) {
        shortestPalindrome sh = new shortestPalindrome();
        System.out.println(sh.shortestPalindrome("asadf"));
    }
}
