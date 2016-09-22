package com.testcases;

/**
 * Created by shiyanghuang on 15/9/25.
 */
public class superClassChild extends superClass{
    public superClassChild(int a) {
        super(a);
    }

    public static void main(String[] args) {
        superClassChild spcc = new superClassChild(1);
    }
}
