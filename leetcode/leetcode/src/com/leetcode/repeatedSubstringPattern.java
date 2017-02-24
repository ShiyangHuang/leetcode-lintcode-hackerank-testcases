package com.leetcode;

/**
 * Created by shiyanghuang on 16/12/2.
 */
public class repeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String str) {
        if (str == null || str.length() <= 1) { return false; }

        for (int i = 2; i <= str.length(); i++) {
            if (str.length() % i == 0) {
                boolean f = false;
                int l = str.length() / i;
                for (int j = 0; j < l; j++) {
                    boolean flag = false;
                    for (int k = 1; k < i; k++) {
                        if (str.charAt(j) != str.charAt(j + k * l)) {
                            break;
                        }
                        if (k == i - 1) {
                            flag = true;
                        }
                    }
                    if (!flag) {
                        break;
                    } else {
                        flag = false;
                    }
                    if (j == l - 1) {
                        f = true;
                    }
                }
                if (f) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        repeatedSubstringPattern r = new repeatedSubstringPattern();
        String str = "aba";
        System.out.println(r.repeatedSubstringPattern(str));
    }
}
