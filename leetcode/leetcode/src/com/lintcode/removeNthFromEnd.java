package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/12.
 */
public class removeNthFromEnd {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (head == null || head.next == null) return null;
        ListNode p = head;
        ListNode h = new ListNode(0);
        ListNode veryhead = new ListNode(0);
        veryhead.next = h;
        h.next = head;
        while (n > 0) {
            p = p.next;
            n--;
        }
        while (p != null) {
            p = p.next;
            h = h.next;
        }
        h.next = h.next.next == null ? null : h.next.next;
        return veryhead.next.next;
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(0);
        ListNode p = h;
        for (int i = 1; i < 12; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        ListNode n = new removeNthFromEnd().removeNthFromEnd(h, 2);
        while (n != null) {
            System.out.print(n.val);
            n = n.next;
        }
    }
}
