package com.testcases;

import java.util.ArrayList;

/**
 * Created by shiyanghuang on 16/3/8.
 */
public class recursive {

    static int MAX_LEVEL = 5;
    static ArrayList<ArrayList<Integer>> data = new ArrayList<ArrayList<Integer>>();

    public void rc(ArrayList result, int level, ArrayList answer) {
        if (level >= MAX_LEVEL) {
            ArrayList<Integer> clone = new ArrayList<Integer>(result);
            answer.add(clone);
            return;
        } else {
            for (int i = 0; i < data.get(level).size(); i++) {
                result.add(data.get(level).get(i));
                rc(result, level + 1, answer);
                result.remove(result.size() - 1);
            }
        }
    }

    public static void printArray(ArrayList<ArrayList<Integer>> result) {
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> line = new ArrayList<Integer>();
        for (int j = 0; j < MAX_LEVEL; j++) {
            for (int i = 0; i < 4; i++) {
                line.add(i);
            }
            data.add(line);
            line = new ArrayList<Integer>();
        }

        System.out.println("Data:");
        printArray(data);

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        new recursive().rc(result, 0, answer);

        System.out.println("Answer");
        printArray(answer);
    }
}
