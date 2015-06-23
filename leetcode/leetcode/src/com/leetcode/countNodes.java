package com.leetcode;

/**
 * Created by shiyanghuang on 15/6/23.
 */
public class countNodes {
    int count;
    public int countNodes(TreeNode root) {
        count = 0;
        search(root);
        return count;
    }

    public void search(TreeNode node) {
        count++;
        if (node.left != null) {
            search(node.left);
        }
        if (node.right != null) {
            search(node.right);
        }
    }

    public static void main(String[] args) {

    }
}
