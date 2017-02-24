package com.testcases;

import java.util.Arrays;

/**
 * Created by shiyanghuang on 16/12/13.
 */
public class binarySearch {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,6,7,8,9};
        int index = Arrays.binarySearch(array, 10);
        System.out.println(array.length);
        System.out.println(~index);
        System.out.println(index);
    }
}
