package com.leetcode;

import java.util.ArrayList;

/**
 * Created by shiyanghuang on 15/6/23.
 */
public class countNodes {
    public int countNodes(TreeNode root) {
        return search(root);
    }

    public int search(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = downLeft(node.left, 0);
        int rightDepth = downRight(node.right, 0);
        System.out.println("LeftDepth: " + leftDepth + " RightDepth: " + rightDepth);
        if (leftDepth == 0 && rightDepth == 0) {
            return 1;
        }
        if (leftDepth == rightDepth) {
            return (1 << (leftDepth + 1)) - 1;
        } else {
            int left = search(node.left);
            int right = search(node.right);
            System.out.println("Left: " + left + " Right: " + right);
            return left + right + 1;
        }
    }

    public int downLeft(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        else {
            System.out.println(node.val);
            return downLeft(node.left, depth + 1);
        }
    }

    public int downRight(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        else {
            System.out.println(node.val);
            return downRight(node.right, depth + 1);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        ArrayList<TreeNode> tree = new ArrayList<TreeNode>();
        int t = 0;
        tree.add(root);
        for (int i = 1; i < 500; i+=2) {
            tree.get(t).left = new TreeNode(i);
            tree.get(t).right = new TreeNode(i + 1);
            tree.add(tree.get(t).left);
            tree.add(tree.get(t).right);
            t++;
        }
        System.out.print(new countNodes().countNodes(root));
    }
}
