package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/16.
 */
public class addLists {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode head = new ListNode(0);
        ListNode p = head;
        int flag = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + flag;
            flag = val / 10;
            p.next = new ListNode(val % 10);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int val = l1.val + flag;
            flag = val / 10;
            p.next = new ListNode(val % 10);
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int val = l2.val + flag;
            flag = val / 10;
            p.next = new ListNode(val % 10);
            p = p.next;
            l2 = l2.next;
        }
        if (flag == 1) {
            p.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(0);
        ListNode p1 = h1;
        ListNode h2 = new ListNode(0);
        ListNode p2 = h2;
        for (int i = 0; i < 15; i++) {
            p1.next = new ListNode((int)(Math.random()*10 % 10));
            p1 = p1.next;
            System.out.print(p1.val);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            p2.next = new ListNode((int) (Math.random() * 10 % 10));
            p2 = p2.next;
            System.out.print(p2.val);
        }
        System.out.println();
        ListNode h = new addLists().addLists(h1.next, h2.next);
        while (h != null) {
            System.out.print(h.val);
            h = h.next;
        }
    }
}
