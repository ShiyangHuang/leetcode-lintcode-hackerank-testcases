package com.testcases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by shiyanghuang on 15/6/21.
 */
public class inputStreamTest {
    public static void main(String[] args) {
        while (true) {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.println(in.read());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
