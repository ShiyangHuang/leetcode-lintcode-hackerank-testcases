package com.lintcode;

/**
 * Created by shiyanghuang on 15/5/28.
 */
public class buildSegmentTreeNode {
    public SegmentTreeNode build(int start, int end) {
        // write your code here
        if(start == end) {
            return new SegmentTreeNode(start,end);
        }
        else {
            int mid = (start + end) / 2;
            SegmentTreeNode node = new SegmentTreeNode(start, end);
            if (start > end) {
                node.left = build(start,mid+1);
                node.right = build(mid, end);
            } else {
                node.left = build(start,mid);
                node.right = build(mid + 1, end);
            }
            return node;
        }
    }

    public static void main(String[] args) {
        SegmentTreeNode tree = new buildSegmentTreeNode().build(10,4);
    }
}
