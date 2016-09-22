package com.testcases;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by shiyanghuang on 16/9/6.
 */
public class outputStreamTest {
    public static void main(String[] args) {
        FileWriter fw = null;
        String output = "/Users/shiyanghuang/Documents/Dataguise/zip,city,state.csv";
        try {
            fw = new FileWriter(output, true);
            fw.write("hello world!");
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (fw != null)
                try {
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException("Error!");
                }
        }
    }
}
