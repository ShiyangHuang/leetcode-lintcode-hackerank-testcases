package com.leetcode;

/**
 * Created by shiyanghuang on 15/6/5.
 */
public class partition {
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode(0);
        ListNode p1 = head1;
        ListNode head2 = new ListNode(0);
        ListNode p2 = head2;
        while (head != null) {
            if (head.val >= x) {
                p2.next = head;
                p2 = p2.next;
                head = head.next;
                p2.next = null;
            } else {
                p1.next = head;
                p1 = p1.next;
                head = head.next;
                p1.next = null;
            }
        }
        p1.next = head2.next;
        return head1.next;
    }
}
