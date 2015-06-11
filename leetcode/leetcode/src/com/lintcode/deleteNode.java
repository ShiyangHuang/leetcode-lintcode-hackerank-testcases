package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/8.
 */
public class deleteNode {
    /**
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // write your code here
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
