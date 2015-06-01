package com.lintcode;

/**
 * Created by shiyanghuang on 15/5/28.
 */

public class SegmentTreeNode {
    public int start, end;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = this.right = null;
    }
}

