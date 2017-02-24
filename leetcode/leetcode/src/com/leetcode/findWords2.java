package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shiyanghuang on 17/2/21.
 */
public class findWords2 {
    public String[] findWords(String[] words) {
        String[] line = {"qwertyuiopQWERTYUIOP","asdfghjklASDFGHJKL","zxcvbnmZXCVBNM"};
        ArrayList<String> ans = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            int l = -1;
            ArrayList<Integer> lineN = new ArrayList<Integer>();
            for (int j = 0; j < words[i].length(); i++) {
                for (int k = 0; k < 3; k++) {
                    if (line[k].contains("" + words[i].charAt(j))) {
                        lineN.add(k);
                    }
                }
            }
            Collections.sort(lineN);
            if (lineN.get(0) == lineN.get(lineN.size() - 1)) {
                ans.add(words[i]);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}
