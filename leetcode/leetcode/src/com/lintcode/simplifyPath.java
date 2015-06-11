package com.lintcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by shiyanghuang on 15/6/10.
 */
public class simplifyPath {
    /**
     * @param path the original path
     * @return the simplified path
     */
    public String simplifyPath(String path) {
        // Write your code here
        String[] paths = path.split("/");
        Stack<String> stk = new Stack<String>();
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].equals("..")) {
                if (!stk.empty()) {
                    stk.pop();
                }
            } else if (paths[i].length() == 0 || paths[i].equals(".")) {

            } else {
                stk.push(paths[i]);
            }
        }
        if (stk.empty()) {
            return "/";
        }
        ArrayList<String> al = new ArrayList<String>();
        while (!stk.empty()) {
            al.add(stk.pop());
        }
        StringBuffer sb = new StringBuffer();
        for (int i = al.size() - 1; i >= 0; i--) {
            sb.append("/");
            sb.append(al.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.print(new simplifyPath().simplifyPath("/abc/..."));
    }
}
