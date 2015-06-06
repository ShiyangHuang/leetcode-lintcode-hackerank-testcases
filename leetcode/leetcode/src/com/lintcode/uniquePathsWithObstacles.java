package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/3.
 */
public class uniquePathsWithObstacles {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        if (n == 0) return 0;
        System.out.println(m + " " + n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                obstacleGrid[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                obstacleGrid[0][i] = 1;
            } else {
                break;
            }
        }
        printGrid(obstacleGrid);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] >= 0) {
                    if (obstacleGrid[i-1][j] > 0) {
                        obstacleGrid[i][j] += obstacleGrid[i-1][j];
                    }
                    if (obstacleGrid[i][j-1] > 0) {
                        obstacleGrid[i][j] += obstacleGrid[i][j-1];
                    }
                }
            }
        }
        return obstacleGrid[m-1][n-1];
    }
    void printGrid(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] a = {{1,0,0},{0,0,0},{0,0,0}};
        System.out.print(new uniquePathsWithObstacles().uniquePathsWithObstacles(a));
    }
}
