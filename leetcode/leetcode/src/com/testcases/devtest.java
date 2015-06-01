package com.testcases;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiyanghuang on 15/6/1.
 */
public class devtest {

    public static String process(String input) {
        if (input == null || input.length() == 0) return "";
        List<ArrayList<Integer>> points = new ArrayList<ArrayList<Integer>>();
        String[] inputs = input.split("\n");
        String[] mapSize = inputs[0].split("x");
        int x = Integer.parseInt(mapSize[1]);
        int y = Integer.parseInt(mapSize[0]);
        char [][] map = new char[x][y];
        for (int i = 0; i < x; i++ ) {
            for (int j = 0; j < y; j++) {
                map[i][j] = '0';
            }
        }
        for (int i = 1; i < inputs.length; i++ ) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            String[] strPoints = inputs[i].split(",");
            map[Integer.parseInt(strPoints[1])][Integer.parseInt(strPoints[0])] = 'X';
        }
        for (int i = 0; i < x; i++ ) {
            for (int j = 0; j < y; j++ ) {
                if (map[i][j] == '0') {
                    map[i][j] = (char) (check(i,j,map,x,y) + '0');
                }
                //System.out.print(map[i][j] + " ");
            }
            //System.out.println();
        }
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < x; i++ ) {
            for (int j = 0; j < y; j++ ) {
                ans.append(map[i][j]);
                if (j == y - 1) {
                    ans.append('\n');
                } else {
                    ans.append(' ');
                }
            }
        }
        return ans.toString();
    }

    public static int check(int x, int y, char[][] map, int mx, int my) {
        int count = 0;
        if (x - 1 >= 0 && y - 1 >= 0) {
            if (map[x - 1][y - 1] == 'X') {
                count++;
            }
        }
        if (x - 1 >= 0) {
            if (map[x - 1][y] == 'X') {
                count++;
            }
        }
        if (x - 1 >= 0 && y + 1 < my) {
            if (map[x - 1][y + 1] == 'X') {
                count++;
            }
        }
        if (y - 1 >= 0) {
            if (map[x][y - 1] == 'X') {
                count++;
            }
        }
        if (y + 1 < my) {
            if (map[x][y + 1] == 'X') {
                count++;
            }
        }
        if (x + 1 < mx && y - 1 >= 0) {
            if (map[x + 1][y - 1] == 'X') {
                count++;
            }
        }
        if (x + 1 < mx) {
            if (map[x + 1][y] == 'X') {
                count++;
            }
        }
        if (x + 1 < mx && y + 1 < my) {
            if (map[x + 1][y + 1] == 'X') {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.print(new devtest().process("1x1\n" +
                "0,0\n"));
    }
}
