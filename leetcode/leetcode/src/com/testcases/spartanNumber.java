package com.testcases;

import java.util.HashMap;

/**
 * Created by shiyanghuang on 15/7/3.
 */
public class spartanNumber {
    public static int ConvertSpartanNumeral(String sn) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('E',3);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        int ans = 0;
        if (sn.length() == 0) {
            return ans;
        }
        ans += map.get(sn.charAt(0));
        int currentHead = 0;
        for (int i = 1; i < sn.length(); i++) {
            if (map.get(sn.charAt(i)) < map.get(sn.charAt(i - 1))) {
                ans -= map.get(sn.charAt(i));
            } else if (map.get(sn.charAt(i)) == map.get(sn.charAt(i - 1))) {
                if (map.get(sn.charAt(i)) == map.get(sn.charAt(currentHead))) {
                    ans += map.get(sn.charAt(i));
                } else {
                    ans -= map.get(sn.charAt(i));
                }
            } else {
                ans += map.get(sn.charAt(i));
                currentHead = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.print(new spartanNumber().ConvertSpartanNumeral("VVVI"));
    }
}
