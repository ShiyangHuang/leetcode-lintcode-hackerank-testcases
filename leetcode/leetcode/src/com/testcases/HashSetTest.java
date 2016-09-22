package com.testcases;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by shiyanghuang on 16/9/16.
 */
public class HashSetTest {
    public static void main(String[] args) {
        String str = "1,2,3,4,5";
        String[] strs = str.split(",");
        HashSet<String> hashSet = new HashSet<String>(Arrays.asList(strs));
        System.out.print(Arrays.asList(strs).contains("1"));
    }
}
