package com.leetcode;

/**
 * Created by shiyanghuang on 15/6/18.
 */
public class copyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) return head;
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
        while (p.next != null && p.next != null) {
            q.next = q.next.next;
            q = q.next;
            p.next = p.next.next;
            p = p.next;
        }
        q.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        RandomListNode h = new RandomListNode(0);
        RandomListNode p = h;
        for (int i = 1; i < 10; i++) {
            p.next = new RandomListNode(i);
            p = p.next;
        }
        RandomListNode nh = new copyRandomList().copyRandomList(h);
        while (h != null) {
            System.out.print(h.label);
            h = h.next;
        }
        System.out.println();
        while (nh != null) {
            System.out.print(nh.label);
            nh = nh.next;
        }
    }
}
