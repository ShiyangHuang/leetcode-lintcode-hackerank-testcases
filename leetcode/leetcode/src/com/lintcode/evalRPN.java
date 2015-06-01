package com.lintcode;

import java.util.Stack;

/**
 * Created by shiyanghuang on 15/6/1.
 */
public class evalRPN {
    /**
     * @param tokens The Reverse Polish Notation
     * @return the value
     */
    public int evalRPN(String[] tokens) {
        // Write your code here
        Stack<Integer> stk = new Stack<Integer>();
        int i = 0;
        while (i < tokens.length) {
            if (tokens[i].equals("+")) {
                int a = stk.pop();
                int b = stk.pop();
                int c = b + a;
                stk.push(c);
            } else if (tokens[i].equals("-")) {
                int a = stk.pop();
                int b = stk.pop();
                int c = b - a;
                stk.push(c);
            } else if (tokens[i].equals("*")) {
                int a = stk.pop();
                int b = stk.pop();
                int c = b * a;
                stk.push(c);
            } else if (tokens[i].equals("/")) {
                int a = stk.pop();
                int b = stk.pop();
                int c = b / a;
                stk.push(c);
            } else {
                stk.push(Integer.parseInt(tokens[i]));
            }
            i++;
        }
        return stk.pop();
    }

    public static void main(String[] args) {
        String[] s = {"0","3","/"};
        System.out.print(new evalRPN().evalRPN(s));
    }
}
