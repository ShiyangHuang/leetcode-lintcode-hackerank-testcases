package com.leetcode;

/**
 * Created by shiyanghuang on 17/1/23.
 */
public class constructRectangle {
    public int[] constructRectangle(int area) {
        for (int i = (int) Math.sqrt(area); i >= 1; i--) {
            if (area % i == 0) {
                return new int[]{i, area % i};
            }
        }
        return new int[] {area, 1};
    }
}
