package com.leetcode;

import java.util.ArrayList;

/**
 * Created by shiyanghuang on 15/6/23.
 */
class dicTree{
    char c;
    boolean end;
    ArrayList<dicTree> list = new ArrayList<dicTree>();
    public dicTree(char c) {
        this.c = c;
        end = false;
    }
}
public class WordDictionary {
    dicTree root = new dicTree('!');
    // Adds a word into the data structure.
    public void addWord(String word) {

            for (int i = 0; i < root.list.size(); i++) {
                if (root.list.get(i).c == word.charAt(0)) {
                    if (word.length() == 1) {
                        root.list.get(i).end = true;
                        return;
                    }
                    addLetter(root.list.get(i), word.substring(1));
                    return;
                }
            }

            root.list.add(new dicTree(word.charAt(0)));
            addLetter(root.list.get(root.list.size() - 1), word.substring(1));

    }
    public void addLetter(dicTree node, String word) {
        if (word.length() == 0) return;

            for (int i = 0; i < node.list.size(); i++) {
                if (node.list.get(i).c == word.charAt(0)) {
                    if (word.length() == 1) {
                        node.list.get(i).end = true;
                        return;
                    }
                    addLetter(node.list.get(i), word.substring(1));
                    return;
                }
            }

            node.list.add(new dicTree(word.charAt(0)));
            if (word.length() == 1) {
                node.list.get(node.list.size() - 1).end = true;
                return;
            }
            addLetter(node.list.get(node.list.size() - 1), word.substring(1));
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        for (int i = 0; i < root.list.size(); i++) {
            if (root.list.get(i).c == word.charAt(0) || word.charAt(0) == '.') {
                if (searchLetter(root.list.get(i), word.substring(1))) {
                    if (word.length() == 1) {
                        if (root.list.get(i).end) {
                            return true;
                        }
                    }

                }
            }
        }
        return false;
    }

    public boolean searchLetter(dicTree node, String word) {
        if (word.length() == 0) {
            return true;
        }
        else {
            for (int i = 0; i < node.list.size(); i++) {
                if (node.list.get(i).c == word.charAt(0) || word.charAt(0) == '.') {
                    if (searchLetter(node.list.get(i), word.substring(1))) {
                        if (word.length() == 1) {
                            if (root.list.get(i).end) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("abc");
        wd.addWord("bcd");
        wd.addWord("ab");
        System.out.print(wd.search("ab"));
    }
}
