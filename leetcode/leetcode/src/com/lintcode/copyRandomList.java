package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/12.
 */
public class copyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        RandomListNode p = head;
        while (p != null) {
            RandomListNode q = p.next;
            p.next = new RandomListNode(p.label);
            p.next.next = q;
            p = q;
        }
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        p = head.next;
        RandomListNode newHead = p;
        RandomListNode q = head;

        while (p != null && p.next != null) {
            q.next = q.next.next;
            q = q.next;
            p.next = p.next.next;
            p = p.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(0);
        RandomListNode p = head;
        for (int i = 0; i < 3; i++) {
            p.next = new RandomListNode(i);
            p = p.next;
        }
        RandomListNode nHead = new copyRandomList().copyRandomList(head);
        while (head != null) {
            System.out.println(head.label);
            head = head.next;
        }
    }

}
