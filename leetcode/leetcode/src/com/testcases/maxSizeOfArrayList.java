package com.testcases;

import java.util.ArrayList;

/**
 * Created by shiyanghuang on 16/4/28.
 */
public class maxSizeOfArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < 200000; i++) {
            arrayList.add(i);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (i % 1000 == 0) {
                System.out.print(i + " ");
            }
        }
    }
}
