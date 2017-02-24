package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiyanghuang on 16/12/13.
 */
public class partitionString {
    public List<List<String>> partition(String s) {
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        if (s == null || s == "") {
            return result;
        }
        ArrayList<String> part = new ArrayList<String>();
        findResult(result, part, 0, s);
        return result;
    }

    private boolean isPartition(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private void findResult(ArrayList<List<String>> result, ArrayList<String> part, int pos, String s) {
        if (pos == s.length()) {
            result.add(new ArrayList<String>(part));
            return;
        }

        for (int i = pos + 1; i <= s.length(); i++) {
            String tmp = s.substring(pos, i);
            if (!isPartition(tmp)) {
                continue;
            }

            part.add(tmp);
            findResult(result, part, i, s);
            part.remove(part.size() - 1);
        }
    }

    public static void main(String[] args) {
        String str = "aab";
        List<List<String>> res = new partitionString().partition(str);
        System.out.println(res);
    }
}
