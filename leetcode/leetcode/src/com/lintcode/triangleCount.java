package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/8.
 */
public class triangleCount {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        int count = 0;
        for (int i = 0; i < S.length; i++) {
            for (int j = i + 1; j < S.length; j++) {
                for (int k = j + 1; k < S.length; k++) {
                    if (check(S[i],S[j],S[k])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    boolean check(int a, int b, int c) {
        if (a + b > c && a + c > b && b + c > a) {
            return true;
        }
        return false;
    }
}
