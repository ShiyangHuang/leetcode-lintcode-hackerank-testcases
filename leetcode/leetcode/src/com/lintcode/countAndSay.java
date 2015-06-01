package com.lintcode;

/**
 * Created by shiyanghuang on 15/5/27.
 */
public class countAndSay {
    public String countAndSay(int n) {
        // Write your code here
        String s = "1";
        while (n > 1) {
            int i = 0;
            String subs = "";
            while (i < s.length()) {
                int length = s.length();
                char c = s.charAt(i++);
                int count = 1;
                while (i < s.length() && s.charAt(i) == c) {
                    count ++;
                    i++;
                }
                subs = subs + count + c;
            }
            s = subs;
            n--;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.print(new countAndSay().countAndSay(5));
    }
}
