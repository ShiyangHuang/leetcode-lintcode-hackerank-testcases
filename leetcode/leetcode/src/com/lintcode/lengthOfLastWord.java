package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/1.
 */
public class lengthOfLastWord {
    public int lengthOfLastWord(String s) {
        // Write your code here
        while (s.length() > 0 && s.substring(s.length()-1).equals(" ")) {
            s = s.substring(0,s.length()-1);
        }
        return s.substring(s.lastIndexOf(' ') + 1).length();
    }

    public static void main(String[] args) {
        System.out.print(new lengthOfLastWord().lengthOfLastWord("asdf"));
    }
}
