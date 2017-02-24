package com.leetcode;

/**
 * Created by shiyanghuang on 17/1/20.
 */
public class licenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("-","");
        int firstPart = S.length() % K;
        int kParts = S.length() / K;
        System.out.println(kParts);
        StringBuilder sb = new StringBuilder();
        if (firstPart != 0) {
            sb.append(S.substring(0, firstPart));
            sb.append("-");
        }
        int t = firstPart;
        while (t < S.length()) {
            sb.append(S.substring(t, t + K));
            sb.append("-");
            t += K;
        }

        return sb.substring(0,sb.length() - 1).toString().toUpperCase();
    }

    public static void main(String[] args) {
        String s = "2-4A0r7-4k";
        int k = 4;

        System.out.println(new licenseKeyFormatting().licenseKeyFormatting(s,k));
    }
}
