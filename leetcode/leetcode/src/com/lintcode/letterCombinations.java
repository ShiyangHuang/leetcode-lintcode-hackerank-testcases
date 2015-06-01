package com.lintcode;

import java.util.ArrayList;

/**
 * Created by shiyanghuang on 15/6/1.
 */
public class letterCombinations {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    ArrayList<String> phone = new ArrayList<String>();
    ArrayList<String> ans = new ArrayList<String>();
    public ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        if (digits.length() == 0) {
            return ans;
        }
        phone.add("0");
        phone.add("1");
        phone.add("abc");
        phone.add("def");
        phone.add("ghi");
        phone.add("jkl");
        phone.add("mno");
        phone.add("pqrs");
        phone.add("tuv");
        phone.add("wxyz");
        String str = "";
        checkNumbers(digits, str);
        return ans;
    }

    public void checkNumbers(String d, String subans) {
        if (d.length() == 0) {
            ans.add(subans);
            return;
        }
        int key = Integer.parseInt(d.charAt(0) + "");
        for (int i = 0; i < phone.get(key).length(); i ++) {
            subans = subans + phone.get(key).charAt(i);
            checkNumbers(d.substring(1),subans);
            subans = subans.substring(0,subans.length()-1);
        }
    }

    public static void main(String[] args) {
        letterCombinations l = new letterCombinations();
        ArrayList<String> s = l.letterCombinations("");
        System.out.print(s);
    }
}
