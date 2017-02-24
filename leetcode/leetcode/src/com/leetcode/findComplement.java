package com.leetcode;

/**
 * Created by shiyanghuang on 17/1/20.
 */
public class findComplement {
    public int findComplement(int num) {
        int cp,ans;
        cp=num;
        int m=1;
        while(cp!=0){
            cp=cp/2;m=m*2;
        }
        ans=m-1-num;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new findComplement().findComplement(4));
    }
}
