package com.testcases;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shiyanghuang on 15/6/1.
 */
public class hashMapTest {
    public static void main(String[] args) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        m.put(-1,1);
        System.out.println(m.get(-1));
        m.put(-1,2);
        System.out.println(m.get(-1));
    }
}
