package com.lintcode;

import java.util.Stack;

/**
 * Created by shiyanghuang on 15/6/1.
 */
public class isValidParentheses {
    public boolean isValidParentheses(String s) {
        // Write your code here
        Stack<Character> stk = new Stack<Character>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stk.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (stk.empty() || stk.pop() != '(') return false;
            } else if (s.charAt(i) == ']') {
                if (stk.empty() || stk.pop() != '[') return false;
            } else if (s.charAt(i) == '}') {
                if (stk.empty() || stk.pop() != '{') return false;
            }
            i++;
        }
        if (stk.empty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.print(new isValidParentheses().isValidParentheses("(){}]"));
    }
}
