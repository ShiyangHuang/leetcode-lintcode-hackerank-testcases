package com.lintcode;

/**
 * Created by shiyanghuang on 15/5/27.
 */
public class mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode veryHead = new ListNode(0);
        ListNode p = veryHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
                p.next = null;
            } else {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
                p.next = null;
            }
        }
        if (l1 != null) {
            p.next = l1;
        } else {
            p.next = l2;
        }
        return veryHead.next;
    }
}
