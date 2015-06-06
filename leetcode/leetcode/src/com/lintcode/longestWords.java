package com.lintcode;

import java.util.ArrayList;

/**
 * Created by shiyanghuang on 15/6/5.
 */
public class longestWords {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        // write your code here
        ArrayList<String> ans = new ArrayList<String>();
        int maxlen = 0;
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i].length() > maxlen) {
                maxlen = dictionary[i].length();
                ans.clear();
                ans.add(dictionary[i]);
            } else if (dictionary[i].length() == maxlen) {
                ans.add(dictionary[i]);
            }
        }
        return ans;
    }
}
