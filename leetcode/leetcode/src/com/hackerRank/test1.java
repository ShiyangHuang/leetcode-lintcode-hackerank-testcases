package com.hackerRank;

/**
 * Created by shiyanghuang on 15/11/12.
 */
public class test1 {

    public String[] gridLand(String[] inputs) {
        String[] ans = new String[inputs.length];
        for (int t = 0; t < inputs.length; t++) {
            String[] input = inputs[t].split(" ");

            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int target = Integer.parseInt(input[2]);

            int totalSteps = x + y;

            StringBuffer sb = new StringBuffer();
            while (sb.length() < totalSteps) {
                int goH = y;

                if (x > 0) {
                    goH = countSteps(x - 1, y);
                } else {
                    sb.append("V");
                    continue;
                }

                if (target <= goH) {
                    sb.append("H");
                    x -= 1;
                } else {
                    sb.append("V");
                    y -= 1;
                    target -= goH;
                }
            }
            ans[t] = sb.toString();
        }
        return ans;
    }

    private int countSteps(int x, int y) {
        long up = 1;
        long down = 1;
        for (int i = 1; i <= x; i++) {
            up *= i;
        }
        for (int i = 1; i <= y; i++) {
            up *= i;
        }
        for (int i = 1; i <= x + y; i++) {
            down *= i;
        }
        long steps = down / up;
        return (int)steps;
    }

    public static void main(String[] args) {
        String[] str = new String[new test1().countSteps(2, 3)];
        for (int i = 0; i < str.length; i++) {
            str[i] = "10 10 " + ((i + 1) + "");
        }
        String[] ans = new test1().gridLand(str);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
