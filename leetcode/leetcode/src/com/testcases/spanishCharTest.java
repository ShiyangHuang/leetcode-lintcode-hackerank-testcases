package com.testcases;

import java.io.*;

/**
 * Created by shiyanghuang on 16/10/18.
 */
public class spanishCharTest {
    public static void main(String[] args) {
        String file = "/Users/shiyanghuang/Documents/Dataguise/spanish/Test_Ritish.csv";
        FileWriter fw = null;
        String line = "";
        int r = 0;
        BufferedReader br = null;
        try {
            // br = new BufferedReader(new FileReader(file));
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"));
            while ((r = br.read()) > 0) {
                System.out.println((int) r + " " + (char) r);
            }
        }
         catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void output() {
        FileWriter fw = null;
        String line = "";
        try {
            fw = new FileWriter("/Users/shiyanghuang/Documents/Dataguise/spanish.txt", true);
            for (int i = 0; i < 255; i++) {
                fw.write((char) i + " ");
                System.out.print((char) i + " ");
                if (i % 10 == 0) {
                    System.out.println();
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
