package com.lintcode;

import java.util.ArrayList;

/**
 * Created by shiyanghuang on 15/6/8.
 */
public class permute {
    private ArrayList<ArrayList<Integer>> ans;
    private ArrayList<Boolean> flag;
    private ArrayList<Integer> tmp;
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ans = new ArrayList<ArrayList<Integer>>();
        flag = new ArrayList<Boolean>();
        tmp = new ArrayList<Integer>();
        for (int i = 0; i < nums.size(); i++) {
            flag.add(true);
        }
        gothrough(0, nums);
        return ans;
    }

    void gothrough(int d, ArrayList<Integer> nums) {
        if (d >= nums.size()) {
            ans.add(new ArrayList<Integer>(tmp));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (flag.get(i)) {
                flag.set(i,false);
                tmp.add(nums.get(i));
                gothrough(d + 1, nums);
                tmp.remove(d);
                flag.set(i,true);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> aa = new ArrayList<Integer>();
        aa.add(1);
        aa.add(2);
        aa.add(3);
        ArrayList<ArrayList<Integer>> a = new permute().permute(aa);
        System.out.print(a);
    }
}
