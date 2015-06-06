package com.testcases;

/**
 * Created by shiyanghuang on 15/6/3.
 */
    public class Minesweeper {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public String process(String input) {
        if (input == null) return null;
        String[] newinput = input.split("\n");
        String mapsize = newinput[0];
        String[] size = mapsize.split("x");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        char[][] map = new char[rows][cols];

        Node[] mines = new Node[newinput.length - 1];
        for (int i = 0; i < mines.length; i++) {
            mines[i] = translate(newinput[i + 1]);
        }

        for (int i = 0; i < mines.length; i++) {
            int row = mines[i].row;
            int col = mines[i].col;
            map[row][col] = 'X';
        }
        //map is done

        //next search
        int[][] mask = new int[rows][cols];
        //default with all 0s
        detect(map, mask);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (map[i][j] != 'X') {
                    map[i][j] = Character.forDigit(mask[i][j], 10);
                }
            }
        }

        String result = "";
        for (int i = 0; i < map.length; i++) {
            for (int j =0; j < map[0].length; j++) {
                result += map[i][j];
                if (j != map[0].length-1)
                    result += ' ';
            }
            result += "\n";
        }
        return result;
    }

    class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public Node translate(String string) {
        String[] temp = string.split(",");
        int row = Integer.parseInt(temp[0]);
        int col = Integer.parseInt(temp[1]);
        return new Node(row, col);
    }

    public void detect(char[][] map, int[][] mask) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'X') {
                    if (i - 1 >= 0 && i - 1 <= map.length - 1 && j - 1 >= 0 && j - 1 <= map[0].length - 1)
                        mask[i - 1][j - 1]++;
                    if (i - 1 >= 0 && i - 1 <= map.length - 1 && j >= 0 && j <= map[0].length - 1) mask[i - 1][j]++;
                    if (i - 1 >= 0 && i - 1 <= map.length - 1 && j + 1 >= 0 && j + 1 <= map[0].length - 1)
                        mask[i - 1][j + 1]++;
                    if (i >= 0 && i <= map.length - 1 && j - 1 >= 0 && j - 1 <= map[0].length - 1) mask[i][j - 1]++;
                    if (i >= 0 && i <= map.length - 1 && j + 1 >= 0 && j + 1 <= map[0].length - 1) mask[i][j + 1]++;
                    if (i + 1 >= 0 && i + 1 <= map.length - 1 && j - 1 >= 0 && j - 1 <= map[0].length - 1)
                        mask[i + 1][j - 1]++;
                    if (i + 1 >= 0 && i + 1 <= map.length - 1 && j >= 0 && j <= map[0].length - 1) mask[i + 1][j]++;
                    if (i + 1 >= 0 && i + 1 <= map.length - 1 && j + 1 >= 0 && j + 1 <= map[0].length - 1)
                        mask[i + 1][j + 1]++;
                }
            }
        }
    }
}