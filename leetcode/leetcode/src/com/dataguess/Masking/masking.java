package com.dataguess.Masking;

/**
 * Created by shiyanghuang on 16/6/17.
 */
public class masking {
    public static void main(String[] args) {
        String path = "./namelist.txt";
        GenerateNameList nl = new GenerateNameList(path);

        String name = "Shawn";
        System.out.println(name);
        System.out.println(name.hashCode());
        System.out.println(nl.maskName(name));
    }
}
