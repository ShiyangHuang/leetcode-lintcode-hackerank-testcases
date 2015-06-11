package com.lintcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by shiyanghuang on 15/6/8.
 */
public class twoSum {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        ArrayList<Integer> origin = new ArrayList<Integer>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            origin.add(numbers[i]);
        }
        Arrays.sort(numbers);
        int l = 0, r = numbers.length - 1;
        while (numbers[l] + numbers[r] != target) {
            if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        int[] ans = new int[2];
        for (int i = 0; i < origin.size(); i++) {
            if (numbers[l] == origin.get(i)) {
                ans[0] = i + 1;
            }
            if (numbers[r] == origin.get(i)) {
                ans[1] = i + 1;
            }
        }
        if (ans[0] > ans[1]) {
            int tmp = ans[0];
            ans[0] = ans[1];
            ans[1] = tmp;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1,0,-1};
        int[] ans = new twoSum().twoSum(a,-1);
        System.out.print(ans[0] + " " + ans[1]);
    }
}
