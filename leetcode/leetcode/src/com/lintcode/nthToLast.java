package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/12.
 */
public class nthToLast {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list.
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        ListNode p = head;
        while (n > 0) {
            p = p.next;
            n--;
        }
        while (p != null) {
            p = p.next;
            head = head.next;
        }
        return head;
    }
}
