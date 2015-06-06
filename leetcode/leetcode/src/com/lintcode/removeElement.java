package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/3.
 */
public class removeElement {
    public int removeElement(int[] A, int elem) {
        // write your code here
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem) {
                A[count++] = A[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,3,4};
        System.out.println(new removeElement().removeElement(a,3));
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
