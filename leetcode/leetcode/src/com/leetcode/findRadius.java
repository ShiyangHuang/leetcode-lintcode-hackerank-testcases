package com.leetcode;

import java.util.Arrays;

/**
 * Created by shiyanghuang on 16/12/13.
 */
public class findRadius {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = 0;
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = ~index;
                int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
                int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

                result = Math.max(result, Math.min(dist1, dist2));
            }
        }
        return result;
    }
}
