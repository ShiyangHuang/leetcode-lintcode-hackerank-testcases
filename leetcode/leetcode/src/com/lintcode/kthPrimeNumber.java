package com.lintcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shiyanghuang on 15/6/11.
 */
public class kthPrimeNumber {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public long kthPrimeNumber(int k) {
        // write your code here
        ArrayList<Long> a = new ArrayList<Long>();
        a.add(3L);
        a.add(5L);
        a.add(7L);
        for (int i = 1; i < k * 7; i++) {
            int n = a.size();
            if (n > k * 7) break;
            for (int j = 0; j < n; j++) {
                if (a.get(j) * 3 > 0 && !a.contains(a.get(j) * 3)) {
                    a.add((long)a.get(j) * 3);
                }
                if (a.get(j) * 9 > 0 && !a.contains(a.get(j) * 9)) {
                    a.add((long)a.get(j) * 9);
                }
                if (a.get(j) * 5 > 0 && !a.contains(a.get(j) * 5)) {
                    a.add((long)a.get(j) * 5);
                }
                if (a.get(j) * 7 > 0 && !a.contains(a.get(j) * 7)) {
                    a.add((long)a.get(j) * 7);
                }
            }
        }
        Collections.sort(a);
        return a.get(k - 1);
    }

    public static void main(String[] args) {
        System.out.print(new kthPrimeNumber().kthPrimeNumber(599));
    }
}
