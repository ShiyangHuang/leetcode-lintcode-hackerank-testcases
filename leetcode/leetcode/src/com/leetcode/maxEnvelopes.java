package com.leetcode;

/**
 * Created by shiyanghuang on 16/12/13.
 */
public class maxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = i + 1; j < envelopes.length; j++) {
                if (envelopes[i][0] < envelopes[j][0]) {
                    int tmp = envelopes[i][0];
                    envelopes[i][0] = envelopes[j][0];
                    envelopes[j][0] = tmp;
                    tmp = envelopes[i][1];
                    envelopes[i][1] = envelopes[j][1];
                    envelopes[j][1] = tmp;
                } else if (envelopes[i][0] == envelopes[j][0] && envelopes[i][1] < envelopes[j][1]) {
                    int tmp = envelopes[i][0];
                    envelopes[i][0] = envelopes[j][0];
                    envelopes[j][0] = tmp;
                    tmp = envelopes[i][1];
                    envelopes[i][1] = envelopes[j][1];
                    envelopes[j][1] = tmp;
                }
            }
        }

        int[] num = new int[envelopes.length];

        for (int i = 0; i < envelopes.length; i++) {
            num[i]++;
        }

        for (int i = 0; i < envelopes.length; i++) {
            for (int j = i + 1; j < envelopes.length; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    num[j] = Math.max(num[i] + 1, num[j]);
                }
            }
        }

        int max = 0;

        for (int i = 0; i < envelopes.length; i++) {
            if (max < num[i]) {
                max = num[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] a = {{5,4},{6,4},{6,7},{2,3}};

        System.out.print(new maxEnvelopes().maxEnvelopes(a));
    }
}
