package com.leetcode;

/**
 * Created by shiyanghuang on 15/11/5.
 */
public class reverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode v = new ListNode(0);
        ListNode p = head;
        ListNode q = null;
        while (p.next != null) {
            v.next = p.next;
            p.next = q;
            q = p;
            p = v.next;
            q.next = p;
        }
        return v.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 1; i < 10; i++) {
            ListNode q = new ListNode(i);
            p.next = q;
            p = p.next;
        }
        ListNode rhead = new reverseList().reverseList(head);
        while (rhead != null) {
            System.out.print(rhead.val + " ");
        }
    }
}
