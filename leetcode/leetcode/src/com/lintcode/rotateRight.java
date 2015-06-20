package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/12.
 */
public class rotateRight {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here

        if (head == null || head.next == null) {
            return head;
        }

        ListNode vHead = new ListNode(0);
        ListNode p = head;
        int length = 0;
        while (p != null) {
            p = p.next;
            length++;
        }
        k %= length;
        p = head;
        ListNode q = vHead;
        vHead.next = head;
        while (k > 0) {
            p = p.next;
            k--;
        }
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        ListNode newHead = q.next;
        q.next = null;
        p = newHead;
        while (p.next != null) {
            p = p.next;
        }
        p.next = vHead.next;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(0);
        ListNode p = h;
        for (int i = 1; i < 2; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        ListNode n = new rotateRight().rotateRight(h, 1);
        while (n != null) {
            System.out.print(n.val);
            n = n.next;
        }
    }
}
