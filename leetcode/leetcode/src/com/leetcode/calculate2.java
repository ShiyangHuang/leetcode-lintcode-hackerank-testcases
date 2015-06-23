package com.leetcode;

import java.util.Stack;

/**
 * Created by shiyanghuang on 15/6/23.
 */
public class calculate2 {
    public int calculate(String s) {
        s = s.replace(" ","");
        Stack<Integer> nstk = new Stack<Integer>();
        Stack<Character> cstk = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                int j = i + 1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    num *= 10;
                    num += s.charAt(j) - '0';
                    j++;
                }
                i = j - 1;
                nstk.push(num);
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                while (!cstk.empty()) {
                    int a = nstk.pop();
                    int b = nstk.pop();
                    char c = cstk.pop();
                    if (c == '+') {
                        nstk.push(a + b);
                    } else if (c == '-') {
                        nstk.push(b - a);
                    }
                }
                cstk.push(s.charAt(i));
            } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                char c = s.charAt(i);
                int num = 0;
                int j = i + 1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    num *= 10;
                    num += s.charAt(j) - '0';
                    j++;
                }
                i = j - 1;
                int a = nstk.pop();
                if (c == '*') {
                    nstk.push(num * a);
                } else if (c == '/') {
                    nstk.push(a / num);
                }
            }
        }
        while (!cstk.empty()) {
            int a = nstk.pop();
            int b = nstk.pop();
            char c = cstk.pop();
            if (c == '+') {
                nstk.push(a + b);
            } else if (c == '-') {
                nstk.push(b - a);
            }
        }
        System.out.println(nstk);
        System.out.println(cstk);
        return nstk.pop();
    }

    public static void main(String[] args) {
        String s = "3";
        System.out.print(new calculate2().calculate(s));
    }
}
