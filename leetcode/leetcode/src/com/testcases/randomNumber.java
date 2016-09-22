package com.testcases;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by shiyanghuang on 16/6/29.
 */
public class randomNumber {
    private static ArrayList<Integer> su = new ArrayList();

    public static void main(String[] args) {
        //int maxNum = 1050000;
        int maxNum = 40;
        getSu(maxNum);

        long P = su.get(su.size() - 1);
        long Q = su.get(su.size() - 2);

        long R = (P - 1) * (Q - 1) + 1;
        int T = 0;
        System.out.println("R : " + R);
        System.out.println("P : " + P);
        System.out.println("Q : " + Q);
        for (int i = 0; i < su.size(); i++) {
            if (R % su.get(i) == 0) {
                T = su.get(i);
                break;
            }
        }
        System.out.println("Su: " + T);

        long i = 2;
        while (i < R) {
            if (i % 1 == 0)
            System.out.println(i + " : " + fn(i, T, P, Q));
            i++;
        }

    }

    private static BigInteger fn(long a, int T, long P, long Q) {
        BigInteger ba = new BigInteger(a + "");
        for (int i = 1; i < T; i++) {
            ba = ba.multiply(new BigInteger(a + ""));
        }
        System.out.println(ba.toString() + " ");
        BigInteger baa = ba.mod(new BigInteger(P + "").multiply(new BigInteger(Q + "")));
        return baa;
    }

    private static void getSu(int max) {
        su.add(2);
        for (int i = 3; i < max; i++) {
            for (int j = 0; j < su.size(); j++) {
                if (i % su.get(j) == 0) {
                    break;
                } else if (j == su.size() - 1) {
                    su.add(i);
                }
            }
        }
    }


}
