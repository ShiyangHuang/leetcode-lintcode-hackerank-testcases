package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/16.
 */
public class updateBits {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        int l = j-i+1;
        int mask = l==32 ? 0xffffffff : ((1<<l)-1);
        return (n & (~(mask<<i))) | ((m & mask) << i);
    }

    public static void main(String[] args) {

        new updateBits().updateBits(1024, 21, 2, 6);
        new updateBits().updateBits(-11, -789, 0, 31);
    }
}
