package com.lintcode;

/**
 * Created by shiyanghuang on 15/5/27.
 */



public class reverse {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode veryHead = new ListNode(0);
        ListNode newVeryHead = new ListNode(0);
        veryHead.next = head;
        while (veryHead.next != null) {
            System.out.println(veryHead.next.val);
            ListNode nextNode = veryHead.next.next;
            ListNode newNextNode = newVeryHead.next;
            newVeryHead.next = veryHead.next;
            newVeryHead.next.next = newNextNode;
            veryHead.next = nextNode;
        }
        return newVeryHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for(int i = 0; i < 12; i ++) {
            ListNode node = new ListNode(i);
            p.next = node;
            System.out.println(p.val);
            p =  p.next;
        }

        ListNode newHead = new reverse().reverse(head);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
