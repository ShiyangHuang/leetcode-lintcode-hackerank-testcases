package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiyanghuang on 15/6/14.
 */
public class findWords {
    boolean[][] flag;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<String>();
        flag = new boolean[board.length][board[0].length];

        for (int i = 0; i < words.length; i++) {
            if(searchWord(board, words[i])) {
                ans.add(words[i]);
            }
        }
        return ans;
    }

    boolean searchWord(char[][] board, String words) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == words.charAt(0)) {
                    flag[i][j] = false;
                    if (searchLetter(board, i, j, words.substring(1))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean searchLetter(char[][] board, int x, int y, String word) {
        if (word.length() == 0) return true;
        if (x - 1 > 0 && board[x - 1][y] == word.charAt(0)) {
            flag[x][y] = false;
            if (searchLetter(board, x - 1, y, word.substring(1))) {
                return true;
            }
            flag[x][y] = true;
        }
        if (x + 1 < board.length && board[x + 1][y] == word.charAt(0)) {
            flag[x][y] = false;
            if (searchLetter(board, x + 1, y, word.substring(1))) {
                return true;
            }
            flag[x][y] = true;
        }
        if (y - 1 > 0 && board[x][y - 1] == word.charAt(0)) {
            flag[x][y] = false;
            if (searchLetter(board, x, y - 1, word.substring(1))) {
                return true;
            }
            flag[x][y] = true;
        }
        if (y + 1 < board[0].length && board[x][y + 1] == word.charAt(0)) {
            flag[x][y] = false;
            if (searchLetter(board, x, y + 1, word.substring(1))) {
                return true;
            }
            flag[x][y] = true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] c = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] s = {"oath","pea","eat","rain"};
        List<String> n = new findWords().findWords(c,s);
        for (int i = 0; i < n.size(); i++) {
            System.out.println(n.get(i));
        }
    }
}
