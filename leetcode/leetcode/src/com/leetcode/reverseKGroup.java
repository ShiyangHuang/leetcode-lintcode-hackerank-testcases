package com.leetcode;

/**
 * Created by shiyanghuang on 15/6/19.
 */
public class reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode vhead = new ListNode(0);
        vhead.next = head;
        ListNode p = vhead.next;
        ListNode q = vhead;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }
        p = vhead;
        while (len / k > 0) {
            len -= k;
            p = reverseNode(p,k);
        }
        return vhead.next;
    }
    public ListNode reverseNode(ListNode vhead, int k) {
        if (k == 1) return vhead.next;
        ListNode nhead = new ListNode(0);
        ListNode p = vhead;
        while (k > 0) {
            ListNode np = nhead.next;
            nhead.next = vhead.next;
            vhead.next = vhead.next.next;
            nhead.next.next = np;
            k--;
        }
        ListNode tail = nhead;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = vhead.next;
        vhead.next = nhead.next;
        return tail;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 1; i < 3; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        ListNode n = new reverseKGroup().reverseKGroup(head, 2);
        while (n != null) {
            System.out.print(n.val);
            n = n.next;
        }
    }
}

//vh -> 1 -> 2 -> 3 -> 4 -> null
