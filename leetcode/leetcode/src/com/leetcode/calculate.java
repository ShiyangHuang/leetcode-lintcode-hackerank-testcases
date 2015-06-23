package com.leetcode;

import java.util.Stack;

/**
 * Created by shiyanghuang on 15/6/23.
 */
public class calculate {
    public int calculate1(String s) {
        s = s.replace(" ","");
        Stack<Integer> nstk = new Stack<Integer>();
        Stack<Character> cstk = new Stack<Character>();
        int p = 0;
        while (p < s.length()) {
            switch (s.charAt(p)) {
                case '(':
                    p++;
                    StringBuffer sb = new StringBuffer();
                    int countLeft = 0;
                    while (s.charAt(p) != ')' || countLeft > 0) {
                        if (s.charAt(p) == '(') {
                            countLeft++;
                        }
                        if (s.charAt(p) == ')') {
                            countLeft--;
                        }
                        sb.append(s.charAt(p++));
                    }
                    nstk.push(calculate1(sb.toString()));
                    break;
                case '+':
                    cstk.push('+');
                    break;
                case '-':
                    cstk.push('-');
                    break;
                case '*':
                    if (s.charAt(p + 1) != '(') {
                        int a = nstk.pop();
                        int b = nstk.pop();
                        nstk.push(a * b);
                    } else {
                        cstk.push('*');
                    }
                    break;
                case '/':
                    if (s.charAt(p + 1) != '(') {
                        int a = nstk.pop();
                        int b = nstk.pop();
                        nstk.push(b / a);
                    } else {
                        cstk.push('/');
                    }
                    break;
                case ')':
                    p++;
                    break;
                default:
                    int num = 0;
                    while (p < s.length() && s.charAt(p) <= '9' && s.charAt(p) >= '0') {
                        num *= 10;
                        num += s.charAt(p) - '0';
                        p++;
                    }
                    nstk.push(num);
                    p--;
            }
            while (nstk.size() > 1) {
                char c = cstk.pop();
                int a = nstk.pop();
                int b = nstk.pop();
                if (c == '+') {
                    nstk.push(b + a);
                } else if (c == '-') {
                    nstk.push(b - a);
                }
            }
            p++;
        }
        while (!cstk.empty()) {
            char c = cstk.pop();
            int a = nstk.pop();
            int b = nstk.pop();
            if (c == '+') {
                nstk.push(b + a);
            } else if (c == '-') {
                nstk.push(b - a);
            }
        }
        return nstk.pop();
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                int j = i + 1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    num = 10 * num + (s.charAt(j) - '0');
                    j++;
                }
                res += stack.pop() * num;
                i = j - 1;
            } else if (c == '+' || c == '(') {
                stack.push(stack.peek());
            } else if (c == '-') {
                stack.push(-1 * stack.peek());
            } else if (c == ')') {
                stack.pop();
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "(1)-(2-1)";
        System.out.print(new calculate().calculate(s));
    }
}
