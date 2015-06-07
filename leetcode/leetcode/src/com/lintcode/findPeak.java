package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/6.
 */
public class findPeak {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeakOn(int[] A) {
        // write your code here
        if (A.length == 1) return 0;
        if (A[0] > A[1]) return 0;
        if (A[A.length-1] > A[A.length-1]) return A.length-1;
        for (int i = 1; i < A.length-1; i++) {
            if (A[i] > A[i-1] && A[i] > A[i+1]) {
                return i;
            }
        }
        return 0;
    }

    public int findPeak(int[] A) {
        if (A.length == 1) return 0;
        if (A[0] > A[1]) return 0;
        if (A[A.length-1] > A[A.length-1]) return A.length-1;
        int l = 0, r = A.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if ((mid == 0 || A[mid] > A[mid - 1]) && (mid == A.length - 1 || A[mid] > A[mid + 1])) {
                return mid;
            } else if ((mid == 0 || A[mid] >= A[mid - 1]) && (mid == A.length - 1 || A[mid] <= A[mid + 1])) {
                l = mid + 1;
            } else if ((mid == 0 || A[mid] <= A[mid - 1]) && (mid == A.length - 1 || A[mid] >= A[mid + 1])) {
                r = mid - 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] a = {1,2,1,2,3,1};
        System.out.print(new findPeak().findPeak(a));
    }
}
