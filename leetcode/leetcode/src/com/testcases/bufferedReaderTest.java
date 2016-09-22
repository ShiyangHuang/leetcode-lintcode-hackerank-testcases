package com.testcases;

import com.google.gson.Gson;

import java.io.*;

/**
 * Created by shiyanghuang on 15/9/9.
 */
public class bufferedReaderTest {
    public static void main(String[] args) {

        String pathString = "/Users/shiyanghuang/Documents/people.json";
        //Path path = new Path(pathString);
        BufferedReader br = null;
        File in = new File(pathString);
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(in)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        People[] ppl = new Gson().fromJson(br, People[].class);
        for (People p : ppl) {
            System.out.println(p.getName() + " " + p.getAge());
        }
    }
}
