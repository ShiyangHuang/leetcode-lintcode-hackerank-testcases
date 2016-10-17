package com.dataguess.Masking;

/**
 * Created by shiyanghuang on 16/6/20.
 */
public class hashCode {
    public static void main(String[] args) {
        str();
    }

    public static void str() {
        String fn = "John";
        String ln = "Master";
        System.out.println(fn.hashCode() + " " + Math.abs(ln.hashCode()) % 34);

    }

    public void digits() {
        String[] s = {"11","11","22","22","33","33","44","44"};
        String s1 = s[0]+s[1]+s[2]+s[3];
        String s2 = s[2]+s[3]+s[4]+s[5];
        System.out.println(Math.abs(((s1).hashCode() + 33) % 13));
        System.out.println(Math.abs(((s2).hashCode() + 33) % 20));
        System.out.println(Math.abs(((s2).hashCode() + 33) % 13));
        System.out.println(Math.abs(((s1).hashCode() + 33) % 20));
    }
}
