package com.testcases;

import java.util.ArrayList;

/**
 * Created by shiyanghuang on 15/5/28.
 */
public class test {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.set(0,100);
        System.out.print(a);
    }
}
