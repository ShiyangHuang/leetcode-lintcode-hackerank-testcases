package com.leetcode;

/**
 * Created by shiyanghuang on 15/6/19.
 */
public class maximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][j] != '0') {
                    matrix[i][j] = matrix[i - 1][j] == '0' ? matrix[i][j] : (char)(matrix[i - 1][j] + 1);
                }

            }
        }

        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            int tmp = check(matrix[i], matrix.length);
            max = max > tmp ? max : tmp;
        }
        return max * max;
    }

    public int check(char[] matrix, int n) {
        for (int i = n; i >= 1; i--) {
            int count = 0;
            for (int j = 0; j < matrix.length; j++) {
                if ((matrix[j] - '0') >= i) {
                    count++;
                } else {
                        count = 0;
                }
                if (count >= i) {
                    return i;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        char[][] matrix2 = {{'0'},{'1'}};
        System.out.print(new maximalSquare().maximalSquare(matrix2));
    }
}
