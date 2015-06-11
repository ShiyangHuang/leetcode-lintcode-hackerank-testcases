package com.leetcode;

/**
 * Created by shiyanghuang on 15/6/10.
 */
public class insertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        ListNode current = head;
        while(current != null) {
            pre = helper;
            while(pre.next != null && pre.next.val < current.val) {
                pre = pre.next; }
            ListNode next = current.next;
            current.next = pre.next;
            pre.next = current;
            current = next;
        }
        return helper.next;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(10);
        ListNode s = l;
        for (int i = 0; i < 10; i++) {
            l.next = new ListNode((int) (Math.random() * 10) );
            l = l.next;
        }
        ListNode a = new insertionSortList().insertionSortList(s);
        while (a != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }
}
