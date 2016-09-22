package com.testcases;

/**
 * Created by shiyanghuang on 16/5/26.
 */
public class countArray {
    public static int countArray(int a) {
        int[] array = new int[10];
        int ans = 0;
        while(a > 0) {
            array[a%10]++;
            a /= 10;
        }
        for (int i = 9; i >= 0; i--) {
            while (array[i] > 0) {
                ans *= 10;
                ans += i;
                array[i]--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int a = 11244555;
        System.out.print(countArray(a));
    }
}
