package com.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by shiyanghuang on 17/1/6.
 */
public class fourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> ab = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (ab.containsKey((A[i] + B[j]))) {
                    int val = ab.get(A[i] + B[j]) + 1;
                    ab.put(A[i] + B[j], val);
                }
                else {
                    ab.put(A[i] + B[j], 1);
                }
            }
        }
        HashMap<Integer, Integer> cd = new HashMap<Integer, Integer>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                if (cd.containsKey((C[i] + D[j]))) {
                    int val = cd.get(C[i] + D[j]) + 1;
                    cd.put(C[i] + D[j], val);
                }
                else {
                    cd.put(C[i] + D[j], 1);
                }
            }
        }

        Iterator it = ab.entrySet().iterator();
        int sum = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Integer key = (Integer)entry.getKey();
            Integer val = (Integer)entry.getValue();
            if (cd.containsKey(-key)) {
                sum += val * cd.get(-key);
            }
        }
        return sum;
    }
}
