package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/7.
 */
public class addBinary {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        // Write your code here
        int numa = 0;
        int numb = 0;
        for (int i = 0; i < a.length(); i++) {
            numa *= 2;
            numa += Integer.parseInt(a.charAt(i) + "");
        }
        for (int i = 0; i < b.length(); i++) {
            numb *= 2;
            numb += Integer.parseInt(b.charAt(i) + "");
        }
        int num = numa + numb;
        return Integer.toBinaryString(num);
    }

    public static void main(String[] args) {
        System.out.print(new addBinary().addBinary("101", "1010"));
    }
}
