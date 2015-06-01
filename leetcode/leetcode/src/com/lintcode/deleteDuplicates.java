package com.lintcode;

/**
 * Created by shiyanghuang on 15/5/27.
 */
public class deleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        int tmp;
        if (head == null || head.next == null) return head;
        ListNode p = head;
        ListNode q = head;
        while (p != null && p.next != null) {
            tmp = p.val;
            //System.out.println(p.val);
            p = p.next;
            while (p != null && tmp == p.val) {
                q.next = p.next;
                p = p.next;
            }
            q = q.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for(int i = 0; i < 2; i ++) {
            ListNode node = new ListNode(i);
            p.next = node;
            //System.out.println(p.val);
            p =  p.next;
            ListNode node2 = new ListNode(i);
            p.next = node2;
            //System.out.println(p.val);
            p =  p.next;
        }
        ListNode newHead = new deleteDuplicates().deleteDuplicates(head);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
